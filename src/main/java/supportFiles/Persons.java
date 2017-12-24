package supportFiles;

import Mysql.MysqlDaoFactory;
import dao.DaoException;
import dao.GenericDao;
import domain.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public class Persons {
    private static ArrayList<Person> persons = new ArrayList<>();
    private static MysqlDaoFactory factory;
    private static GenericDao personDao;

    public static void addPerson() {
        try {
            factory = new MysqlDaoFactory();
            personDao = factory.getDao(factory.getConnection(), Person.class);

            Person pr = new Person();
            pr.setName();
            pr.setSurname();
            pr.setBirthDay();

            persons.add((Person) personDao.create(pr));

        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public static void getAllPersons() {
        try {
            factory = new MysqlDaoFactory();
            personDao = factory.getDao(factory.getConnection(), Person.class);

            persons = personDao.getAll();

        } catch (DaoException e) {
            e.printStackTrace();
        }


    }

    public static void showPersonsInfo() {
        for(Person pr: persons){
            System.out.println(pr.toString());
        }

    }

    public static void main(String[] args) {
        //addPerson();
        getAllPersons();
        showPersonsInfo();
    }
}
