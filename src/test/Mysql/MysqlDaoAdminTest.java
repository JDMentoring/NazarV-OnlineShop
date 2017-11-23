package Mysql;

import domain.Admin;
import domain.Customer;
import domain.UserState;
import domain.Admin;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MysqlDaoAdminTest {
   /* @Test
   public void create() throws Exception {
        dao = dbFactory.getDao(dbFactory.getConnection(), Admin.class);
        Admin cm = new Admin();
        cm.setName("Ігор ");
        cm.setSurname("Купчак");
        cm.setBirthDay(LocalDate.of(1998,6,9));
        cm.setLogin("igor_kk");
        cm.setPassword("igor_k");
        cm.setStatus(UserState.New);
        cm.setEmail("igor.k@gmail.com");
        cm.setAddress("Шевченка 24");
        cm.setPhone("0680363042");
        Admin cmFromDb = (Admin) dao.create(cm);

        assertNotNull(cmFromDb);
        System.out.println(cmFromDb.toString());

    }

    @Test
    public void read() throws Exception {
        dao = dbFactory.getDao(dbFactory.getConnection(), Customer.class);
        Customer cmFromDb = (Customer) dao.read(2);
        assertEquals("igor_k",cmFromDb.getLogin());

    }

    @Test
    public void update() throws Exception {
        dao = dbFactory.getDao(dbFactory.getConnection(), Customer.class);
        String newPassword = "1234";
        Customer cmFromDb = (Customer) dao.read(2);
        cmFromDb.setPassword(newPassword);
        dao.update(cmFromDb);
        Customer cmFromDbUpdated = (Customer) dao.read(2);
        assertEquals(newPassword,cmFromDbUpdated.getPassword());

    }

    @Test
    public void delete() throws Exception {
        dao = dbFactory.getDao(dbFactory.getConnection(), Customer.class);
        Customer cmFromDb = (Customer) dao.read(3);
        assertTrue(dao.delete(cmFromDb));
    }

    @Test
    public void getAll() throws Exception {
    }
*/
}