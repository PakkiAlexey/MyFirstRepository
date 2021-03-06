package DataBase.DAO;
import DataBase.Model.User;
import Exceptions.DAOExceptions;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class DAO<T> {
    public abstract boolean insert(T element) throws DAOExceptions;
    public abstract boolean update(T element) throws DAOExceptions;
    public abstract User getById(int idUser) throws DAOExceptions;
    public abstract boolean delete(T element) throws DAOExceptions;
    public abstract CopyOnWriteArrayList<T> getAll() throws DAOExceptions;
}
