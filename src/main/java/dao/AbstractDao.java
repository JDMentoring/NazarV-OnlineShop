package dao;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class AbstractDao<T extends Identeficator<PK>, PK extends Serializable> implements GenericDao<T, PK> {
    private Connection connection;
    private static final Logger log = Logger.getLogger(AbstractDao.class);

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectQuery();

    public abstract String getUpdateQuery();

    public abstract String getCreateQuery();

    public abstract String getDeleteQuery();

    public abstract ArrayList<T> parseResultSet(ResultSet rs) throws DaoException;

    public abstract void parseUpdate(PreparedStatement prSt, T obj) throws DaoException;

    public abstract void parseInsert(PreparedStatement prSt, T obj) throws DaoException;

    @Override
    public T create(T object) throws DaoException {
        T temp = null;

        String query = getCreateQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            parseInsert(preparedStatement, object);
            int count = preparedStatement.executeUpdate();
            if (count != 1) throw new DaoException("Додано більше ніж один об'єкт :" + count);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException obj) {
            System.out.println(obj.getMessage());
            log.error(obj.getMessage());
        }

        query = getSelectQuery() + "(SELECT last_insert_id());";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<T> list = parseResultSet(resultSet);
            if (list == null || list.size() != 1) throw new DaoException("Неможливо знайти об'єкт в базі данних");
            temp = list.iterator().next();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException obj) {
            System.out.println(obj.getMessage());
            log.error(obj.getMessage());
        }
        return temp;
    }

    @Override
    public T read(int key) throws DaoException {
        ArrayList<T> list;
        String SELECT_QUERY = getSelectQuery();
        SELECT_QUERY += " WHERE id =?";
        try (PreparedStatement prStatment = connection.prepareStatement(SELECT_QUERY)) {
            prStatment.setInt(1, key);
            ResultSet rs = prStatment.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            log.error("Помилка отримання інформації про об'єкт  по id = " + key);
            log.error(e.getStackTrace());
            throw new DaoException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            try {
                throw new DaoException("Отримано більше ніж один об'єкт по даному id" + key);
            } catch (DaoException e) {
                log.error(e.getMessage());
                log.error(e.getStackTrace());
            }
        }
        return list.iterator().next();

    }

    @Override
    public void update(T object) throws DaoException {
        String UPDATE_QUERY = getUpdateQuery();

        try (PreparedStatement prStatment = connection.prepareStatement(UPDATE_QUERY)) {
            parseUpdate(prStatment, object);
            int count = prStatment.executeUpdate();
            if (count != 1) throw new DaoException("Обновлено більше ніж одне поле в таблиці" + count);
        } catch (SQLException e) {
            System.out.println("");
            System.out.println(e.getMessage());
        } catch (DaoException obj) {
            log.error(obj.getMessage());
            log.error(obj.getStackTrace());
        }
    }

    @Override
    public boolean delete(T object) throws DaoException {
        String DELETE_QUERY = getDeleteQuery();
        try (PreparedStatement prStatement = connection.prepareStatement(DELETE_QUERY)) {
            prStatement.setObject(1, object.getId());
            int count = prStatement.executeUpdate();
            if (count != 1) throw new DaoException("Видалено більше ніж одне поле в таблиці");
            else return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException obj) {
            log.error(obj.getMessage());
            log.error(obj.getStackTrace());
        }
        return false;
    }

    @Override
    public ArrayList<T> getAll() throws DaoException {
        String SELECT_QUERY = getSelectQuery();
        ArrayList<T> someList = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            ResultSet rs = preparedStatement.executeQuery();
            someList = parseResultSet(rs);
            if (someList == null) throw new DaoException("Не отримано данних із таблиці");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException obj) {
            log.error(obj.getMessage());
            log.error(obj.getStackTrace());
        }
        return someList;
    }

    protected LocalDate convertToLocalDate(Date date) {
        return date.toLocalDate();
    }

    protected Date convertToSqlDate(LocalDate localDate) {
        return Date.valueOf(localDate);
    }
}
