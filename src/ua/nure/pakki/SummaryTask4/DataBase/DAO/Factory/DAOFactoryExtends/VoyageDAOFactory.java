package ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactoryExtends;

import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.VoyageDAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactory;

public class VoyageDAOFactory extends DAOFactory {
    @Override
    public DAO createDAO() {
        return new VoyageDAO();
    }
}
