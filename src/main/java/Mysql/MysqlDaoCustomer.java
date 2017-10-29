package Mysql;

import dao.AbstractDao;
import dao.DaoException;
import domain.Customer;
import domain.UserGroup;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MysqlDaoCustomer extends AbstractDao<Customer, Integer> {

    public MysqlDaoCustomer(Connection connection) {
        super(connection);
    }

    private class ExtraCustomer extends Customer {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT customer_id,name,surname,birthday,address,phone,group,login FROM customers WHERE customer_id = ";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE customers SET " +
                "name = ?, " +
                "surname =?," +
                "birthday=?" +
                "address=?" +
                "phone=?" +
                "group=?" +
                "login=?" +
                "WHERE customer_id = ?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO сustomers (name,surname,birthday,address,phone,group,login)" +
                " VALUES(?,?,?,?,?,?,?)";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM customers WHERE id=?;";
    }

    @Override
    public ArrayList<Customer> parseResultSet(ResultSet rs) throws DaoException {
        Logger log = Logger.getLogger(AbstractDao.class);
        ArrayList<Customer> customer = new ArrayList<Customer>();
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                LocalDate birthday = convertToLocalDate(rs.getDate(4));
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String group = rs.getString(7);
                String login = rs.getString(8);

                UserGroup uGroup = null;
                switch (group) {
                    case "New":
                        uGroup = UserGroup.New;
                        break;
                    case "Active":
                        uGroup = UserGroup.Active;
                        break;
                    case "Blocked":
                        uGroup = UserGroup.Blocked;
                        break;
                    case "Banned":
                        uGroup = UserGroup.Banned;
                        break;
                }

                ExtraCustomer cm = new ExtraCustomer();
                cm.setId(id);
                cm.setName(name);
                cm.setSurname(surname);
                cm.setBirthDay(birthday);
                cm.setAddress(address);
                cm.setPhone(phone);
                cm.setGroup(uGroup);
                cm.setLogin(login);
                customer.add(cm);
            }
        } catch (Exception e) {
            log.error("Неможливо отримати дані з ResultSet для Customer");
            log.error(e.getStackTrace());
            throw new DaoException(e);
        }

        return customer;
    }

    @Override
    public void parseUpdate(PreparedStatement prSt, Customer obj) throws DaoException {
        try {
            prSt.setInt(1,obj.getId());
            prSt.setString(2,obj.getName());
            prSt.setString(3,obj.getSurname());
            prSt.setDate(4, convertToSqlDate(obj.getBirthDay()));
            prSt.setString(5,obj.getAddress());
            prSt.setString(6,obj.getPhone());
            prSt.setString(7,obj.getGroup().toString());
            prSt.setString(8,obj.getLogin());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void parseInsert(PreparedStatement prSt, Customer obj) throws DaoException {
        try {
            prSt.setString(1,obj.getName());
            prSt.setString(2,obj.getSurname());
            prSt.setDate(3, convertToSqlDate(obj.getBirthDay()));
            prSt.setString(4,obj.getAddress());
            prSt.setString(5,obj.getPhone());
            prSt.setString(6,obj.getGroup().toString());
            prSt.setString(7,obj.getLogin());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
