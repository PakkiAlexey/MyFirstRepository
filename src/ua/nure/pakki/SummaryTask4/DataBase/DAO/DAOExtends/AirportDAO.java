package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;


import org.apache.log4j.BasicConfigurator;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Util.ConnectionPool;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Airport;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.*;
import java.util.ArrayList;


public class AirportDAO extends DAO<Airport> {

    private static final Logger LOG = Logger.getLogger(AirportDAO.class.getName());

    @Override
    public boolean insert(Airport airport) throws DAOExceptions {
        boolean rowsInserted;
        LOG.info("Creating new Airport");
        String sql = "INSERT INTO airport (Name) values (?)";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, airport.getName());
            rowsInserted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsInserted;
    }

    @Override
    public Airport getById(int idAirport) throws DAOExceptions {
        Airport airport = new Airport();
        LOG.info("Getting Airport by id" + idAirport);
        String sql = "SELECT * FROM airport where idairport = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, idAirport);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long idairport = resultSet.getLong("idairport");
                String name = resultSet.getString("Name");

                airport.setIdAirport(idAirport);
                airport.setName(name);

            }

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }

        return airport;
    }

    @Override
    public boolean update(Airport airport) throws DAOExceptions {
        LOG.info("update airport with id = " + airport.getId());
        boolean rowsUpdated = false;
        String sql = "UPDATE airport SET Name = ? where idairport = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, airport.getName());
            statement.setLong(2, airport.getIdAirport());

            rowsUpdated = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsUpdated;
    }

    @Override
    public boolean delete(Airport airport) throws DAOExceptions {
        LOG.info("delete airport with id = " + airport.getId());
        boolean rowsDeleted;
        String sql = "DELETE from airport where idairport = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, airport.getIdAirport());
            rowsDeleted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsDeleted;
    }

    @Override
    public ArrayList<Airport> getAll() throws DAOExceptions {
        ArrayList<Airport> listOfAirports = new ArrayList<>();
        LOG.info("Getting list of airports");
        String sql = "SELECT * FROM airport";

        LOG.info("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            LOG.trace("creating result set");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idairport");
                String name = resultSet.getString("Name");

                Airport airport = new Airport(id, name);
                listOfAirports.add(airport);
            }
        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);

        }
        return listOfAirports;
    }

}
