package Mysql;

import dao.AbstractDao;
import dao.DaoException;
import domain.Customer;
import domain.UserGroup;
import domain.UserState;
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
        return "SELECT id,name,surname,born_date,login,password,user_status,email,address,phone_number FROM customers WHERE id = ";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE customers SET " +
                "name=?," +
                "surname=?," +
                "born_date=?," +
                "login=?," +
                "password=?," +
                "user_status=?," +
                "email=?," +
                "address=?," +
                "phone_number=?" +
                " WHERE id = ?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO customers (name,surname,born_date,login,password,user_status,email,address,phone_number) " +
                "VALUES(?,?,?,?,?,?,?,?,?);";
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
                LocalDate bornDate = convertToLocalDate(rs.getDate(4));
                String login = rs.getString(5);
                String password = rs.getString(6);
                String user_status = rs.getString(7);
                String email = rs.getString(8);
                String address = rs.getString(9);
                String phone = rs.getString(10);

                UserState state = null;
                switch (user_status) {
                    case "New":
                       state = UserState.New;
                        break;
                    case "Active":
                        state = UserState.Active;
                        break;
                    case "Blocked":
                        state = UserState.Blocked;
                        break;
                    case "Banned":
                        state = UserState.Banned;
                        break;
                }

                ExtraCustomer cm = new ExtraCustomer();
                cm.setId(id);
                cm.setName(name);
                cm.setSurname(surname);
                cm.setBirthDay(bornDate);
                cm.setLogin(login);
                cm.setPassword(password);
                cm.setStatus(state);
                cm.setEmail(email);
                cm.setAddress(address);
                cm.setPhone(phone);
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
            prSt.setInt(10,obj.getId());
            prSt.setString(1,obj.getName());
            prSt.setString(2,obj.getSurname());
            prSt.setDate(3, convertToSqlDate(obj.getBirthDay()));
            prSt.setString(4,obj.getLogin());
            prSt.setString(5,obj.getPassword());
            prSt.setString(6,obj.getStatus().toString());
            prSt.setString(7,obj.getEmail());
            prSt.setString(8,obj.getAddress());
            prSt.setString(9,obj.getPhone());
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
            prSt.setString(4,obj.getLogin());
            prSt.setString(5,obj.getPassword());
            prSt.setString(6,obj.getStatus().toString());
            prSt.setString(7,obj.getEmail());
            prSt.setString(8,obj.getAddress());
            prSt.setString(9,obj.getPhone());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
