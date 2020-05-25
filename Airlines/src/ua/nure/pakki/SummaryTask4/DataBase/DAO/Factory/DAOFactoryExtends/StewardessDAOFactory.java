package ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactoryExtends;

import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.StewardessDAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactory;

public class StewardessDAOFactory extends DAOFactory {
    @Override
    public DAO createDAO() {
        return new StewardessDAO();
    }
}
