package dao;

public interface DaoFactory<T>  {
    public interface DaoCreator<T>{
        public GenericDao create(T connection);
    }
    public T getConnection() throws DaoException;

    public GenericDao getDao(T connection, Class daoClass) throws DaoException;
}
