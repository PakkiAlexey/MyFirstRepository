package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;

import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Role;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.util.ArrayList;

public class RoleDAO extends DAO<Role> {
    @Override
    public boolean insert(Role element) throws DAOExceptions {
        return false;
    }

    @Override
    public Role getById(int id) throws DAOExceptions {
        return null;
    }

    @Override
    public boolean update(Role element) throws DAOExceptions {
        return false;
    }

    @Override
    public boolean delete(Role element) throws DAOExceptions {
        return false;
    }

    @Override
    public ArrayList<Role> getAll() throws DAOExceptions {
        return null;
    }


}
