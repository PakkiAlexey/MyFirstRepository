package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;

import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Util.ConnectionPool;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.StewardessHasTeam;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StewardessHasTeamDAO extends DAO<StewardessHasTeam> {
    @Override
    public boolean insert(StewardessHasTeam stewardessHasTeam) throws DAOExceptions {
        boolean rowsInserted;
        //LOG.info("Creating new Airport");
        String sql = "INSERT INTO stewardess_have_team (id_stewardess, id_team) values (?,?)";

        // LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, stewardessHasTeam.getIdStewardess());
            statement.setLong(2, stewardessHasTeam.getIdTeam());
            rowsInserted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            // LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsInserted;
    }


    @Override
    public StewardessHasTeam getById(int id) throws DAOExceptions {
        return null;
    }

    @Override
    public boolean update(StewardessHasTeam element) throws DAOExceptions {
        return false;
    }

    @Override
    public boolean delete(StewardessHasTeam element) throws DAOExceptions {
        return false;
    }

    @Override
    public ArrayList<StewardessHasTeam> getAll() throws DAOExceptions {
        return null;
    }
}
