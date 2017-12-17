package dao;


import java.io.Serializable;
import java.util.ArrayList;

public interface GenericDao<T,PK extends Serializable> {
    public T create() throws DaoException;

    public T create(T object) throws DaoException;

    public T read(int key) throws DaoException;

    public void update(T object) throws DaoException;

    public boolean delete(T object) throws DaoException;

    public ArrayList<T> getAll() throws DaoException;
}
