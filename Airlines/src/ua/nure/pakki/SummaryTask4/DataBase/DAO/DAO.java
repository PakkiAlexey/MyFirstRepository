package ua.nure.pakki.SummaryTask4.DataBase.DAO;

import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.util.ArrayList;

public abstract class DAO<T> {
    public abstract boolean insert(T element) throws DAOExceptions;
    public abstract T getById(int id) throws DAOExceptions;
    public abstract boolean update(T element) throws DAOExceptions;
    public abstract boolean delete(T element) throws DAOExceptions;
    public abstract ArrayList<T> getAll() throws DAOExceptions;
}
