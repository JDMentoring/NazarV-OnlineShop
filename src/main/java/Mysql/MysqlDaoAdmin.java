package Mysql;

import dao.AbstractDao;
import dao.DaoException;
import domain.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


import org.apache.log4j.Logger;

public class MysqlDaoAdmin extends AbstractDao<Admin,Integer>{
    public MysqlDaoAdmin(Connection connection) {super(connection); }

    private class ExtraAdmin extends Admin{
        public void setId(int id){super.setId(id);}
    }
    @Override
    public String getSelectQuery() {
        return "SELECT id,name,surname,birthday,login,password,state," +
                "email,status FROM Admins WHERE id = ";
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public ArrayList<Admin> parseResultSet(ResultSet rs) throws DaoException, SQLException {
        Logger log = org.apache.log4j.Logger.getLogger(AbstractDao.class);
        ArrayList<Admin> admins = new ArrayList<>();

        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                LocalDate Date = convertToLocalDate(rs.getDate(4));
                String login = rs.getString(5);
                String password = rs.getString(6);
                String state = rs.getString(7);
                String email = rs.getString(8);
                String status = rs.getString(9);

                MysqlDaoAdmin.ExtraAdmin cm = new MysqlDaoAdmin.ExtraAdmin();
                cm.setId(id);
                cm.setName(name);
                cm.setSurname(surname);
                cm.setBirthDay(Date);
                cm.setLogin(login);
                cm.setPassword(password);
                cm.setState(state);
                cm.setEmail(email);
                cm.setStatus(status);
                admins.add(cm);
            }
        } catch (Exception e) {
            log.error("Неможливо отримати дані з ResultSet для Customer");
            log.error(e.getStackTrace());
            throw new DaoException(e);
        }
        return admins;
    }

    @Override
    public void parseUpdate(PreparedStatement prSt, Admin obj) throws DaoException {
        try {
            prSt.setInt(   1,obj.getId());
            prSt.setString(2,obj.getName());
            prSt.setString(3,obj.getSurname());
            prSt.setDate(  4, convertToSqlDate(obj.getBirthDay()));
            prSt.setString(5,obj.getLogin());
            prSt.setString(6,obj.getPassword());
            prSt.setString(7,obj.getState().toString());
            prSt.setString(8,obj.getEmail());
            prSt.setString(9, String.valueOf(obj.getStatus()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void parseInsert(PreparedStatement prSt, Admin obj) throws DaoException {
        try {
            prSt.setString(1,obj.getName());
            prSt.setString(2,obj.getSurname());
            prSt.setDate(3, convertToSqlDate(obj.getBirthDay()));
            prSt.setString(4,obj.getLogin());
            prSt.setString(5,obj.getPassword());
            prSt.setString(6,obj.getState().toString());
            prSt.setString(7,obj.getEmail());
            prSt.setString(8, String.valueOf(obj.getStatus()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
