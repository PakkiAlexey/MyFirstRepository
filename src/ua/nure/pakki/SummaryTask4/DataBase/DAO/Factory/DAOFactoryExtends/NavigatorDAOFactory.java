package ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactoryExtends;

import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.NavigatorDAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactory;

public class NavigatorDAOFactory extends DAOFactory {
    @Override
    public DAO createDAO() {
        return new NavigatorDAO();
    }
}
