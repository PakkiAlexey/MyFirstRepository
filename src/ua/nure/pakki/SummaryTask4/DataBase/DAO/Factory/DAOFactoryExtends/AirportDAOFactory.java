package ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactoryExtends;

import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.AirportDAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactory;

public class AirportDAOFactory extends DAOFactory {
    @Override
    public DAO createDAO() {
        return new AirportDAO();
    }
}
