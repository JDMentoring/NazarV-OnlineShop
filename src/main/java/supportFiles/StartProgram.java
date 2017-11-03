package supportFiles;

import Mysql.MysqlDaoFactory;
import dao.DaoException;
import dao.DaoFactory;
import dao.GenericDao;
import domain.Customer;
import domain.UserGroup;
import domain.UserState;

import java.sql.Connection;
import java.time.LocalDate;

public class StartProgram {
    public static void main(String[] args) {
        DaoFactory<Connection> factory = new MysqlDaoFactory();
        GenericDao dao = null;
        Connection connection = null;
        try {
            connection = factory.getConnection();
            dao = factory.getDao(connection, Customer.class);
            Customer cm = new Customer();
            cm.setName("Назар");
            cm.setSurname("Войчак");
            cm.setBirthDay(LocalDate.of(1998,6,9));
            cm.setLogin("nazzik_v");
            cm.setPassword("qwerty");
            cm.setStatus(UserState.Active);
            cm.setEmail("nazar@gmail.com");
            cm.setAddress("Шевченка 12");
            cm.setPhone("0680363051");
            dao.create(cm);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
