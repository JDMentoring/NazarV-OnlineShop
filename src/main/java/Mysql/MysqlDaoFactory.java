package Mysql;

import dao.DaoException;
import dao.DaoFactory;
import dao.GenericDao;
import domain.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MysqlDaoFactory implements DaoFactory<Connection>{
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://servlab.mysql.ukraine.com.ua:3306/servlab_shopnv?useSSL=false";
    private String USERNAME = "servlab_shopnv";
    private String PASSWORD = "jxxbnqz2";
    private Map<Class, DaoCreator> allDaoObjects;


    public MysqlDaoFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        allDaoObjects = new HashMap<Class,DaoCreator>();

        allDaoObjects.put(Customer.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new MysqlDaoCustomer(connection);
            }
        });
    }

    @Override
    public Connection getConnection() throws DaoException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return connection;
    }

    @Override
    public GenericDao getDao(Connection connection, Class daoClass) throws DaoException {
        DaoCreator creator = allDaoObjects.get(daoClass);
        if(creator== null) throw new DaoException("Не знайдено реалізацію дао для класу " + daoClass);
        return creator.create(connection);
    }
}
