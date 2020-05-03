package ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory;

import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.PilotDAO;

public class PilotDAOFactory extends DAOFactory {
    @Override
    public DAO createDAO() {
        return new PilotDAO();
    }
}
