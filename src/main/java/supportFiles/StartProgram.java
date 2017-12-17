package supportFiles;

import Mysql.MysqlDaoFactory;
import dao.DaoException;
import dao.DaoFactory;
import dao.GenericDao;
import domain.Customer;
import domain.Person;
import domain.UserGroup;
import domain.UserState;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

public class StartProgram {
    private static MysqlDaoFactory factory;
    private static GenericDao personDao;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        try {
            factory = new MysqlDaoFactory();
            personDao = factory.getDao(factory.getConnection(), Person.class);

            System.out.print("Enter your name");
            String name = input.next();

            System.out.print("Enter your surname");
            String surname = input.next();
            LocalDate bd = LocalDate.now();


            Person pr = new Person(name, surname, bd);
            personDao.create(pr);

        } catch (DaoException e) {
            e.printStackTrace();
        }


    }
}
