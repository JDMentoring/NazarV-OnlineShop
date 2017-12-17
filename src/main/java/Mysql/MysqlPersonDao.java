package Mysql;

import dao.AbstractDao;
import dao.DaoException;
import domain.Person;

import java.sql.*;
import java.util.ArrayList;

public class MysqlPersonDao extends AbstractDao<Person, Integer> {

    public MysqlPersonDao(Connection connection) {
        super(connection);
    }

    private class PersonDAO extends Person {
        @Override
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public Person create() throws DaoException {
        Person person = new Person();
        return create(person);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id,f_name,l_name,born_date FROM persons ";
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO `persons` (f_name, l_name, born_date) \n" +
                "    VALUES (?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public String getWhereQuery() {
        return "WHERE id =";
    }

    @Override
    public ArrayList<Person> parseResultSet(ResultSet rs) throws DaoException, SQLException {
        return null;
    }

    @Override
    public void parseUpdate(PreparedStatement prSt, Person obj) throws DaoException {

    }

    @Override
    public void parseInsert(PreparedStatement prSt, Person obj) throws DaoException {
        try {
            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getSurname());
            prSt.setDate(3, Date.valueOf(obj.getBirthDay()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
