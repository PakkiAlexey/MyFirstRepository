package ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactoryExtends;

import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.RequestDAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactory;

public class RequestDAOFactory extends DAOFactory {
    @Override
    public DAO createDAO() {
        return new RequestDAO();
    }
}
