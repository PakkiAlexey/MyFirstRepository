package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Util.ConnectionPool;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Airport;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Request;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Voyage;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VoyageDAO extends DAO<Voyage> {
    private static final Logger LOG = Logger.getLogger(RequestDAO.class.getName());

    @Override
    public boolean insert(Voyage voyage) throws DAOExceptions {
        LOG.info("Create new voyage");
        boolean rowsInserted;
        String sql = "INSERT INTO voyage (idvoyage,idairport,idteam,place_of_sending,place_of_arriving," +
                "time_of_sending,time_of_arriving) values (?,?,?,?,?,?,?)";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, voyage.getIdVoyage());
            statement.setLong(2, voyage.getIdAirport());
            statement.setLong(3, voyage.getIdTeam());
            statement.setString(4, voyage.getPlaceOfSending());
            statement.setString(5, voyage.getPlaceOfArriving());
            statement.setString(6, voyage.getTimeOfSending());
            statement.setString(7, voyage.getTimeOfArriving());


            rowsInserted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsInserted;
    }

    @Override
    public Voyage getById(int idvoyage) throws DAOExceptions {
        Voyage voyage = new Voyage();
        LOG.info("Get voyage by id" + idvoyage);
        String sql = "SELECT * FROM voyage where idvoyage = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, idvoyage);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                voyage = createVoyage(resultSet);
            }

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return voyage;
    }

    @Override
    public boolean update(Voyage voyage) throws DAOExceptions {
        LOG.info("update voyage with id = " + voyage.getIdVoyage());
        boolean rowsUpdated;
        String sql = "UPDATE voyage SET idairport = ?, idteam = ?, place_of_sending = ?,place_of_arriving = ?, " +
                "time_of_sending = ?, time_of_arriving = ?,status = ? where idvoyage = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, voyage.getIdAirport());
            statement.setLong(2, voyage.getIdTeam());
            statement.setString(3, voyage.getPlaceOfSending());
            statement.setString(4, voyage.getPlaceOfArriving());
            statement.setString(5, voyage.getTimeOfSending());
            statement.setString(6, voyage.getTimeOfArriving());
            statement.setBoolean(7, voyage.isStatus());
            statement.setLong(8,voyage.getIdVoyage());

            rowsUpdated = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsUpdated;
    }

    @Override
    public boolean delete(Voyage voyage) throws DAOExceptions {
        LOG.info("delete voyage with id = " + voyage.getIdVoyage());
        boolean rowsUpdated;
        String sql = "DELETE FROM voyage where idvoyage = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, voyage.getIdVoyage());
            rowsUpdated = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsUpdated;

    }

    @Override
    public ArrayList<Voyage> getAll() throws DAOExceptions {
        LOG.info("Get list of airports");
        ArrayList<Voyage> listOfVoyages = new ArrayList<>();
        String sql = "SELECT * FROM voyage";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Voyage voyage = createVoyage(resultSet);
                listOfVoyages.add(voyage);
            }
        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return listOfVoyages;
    }


    public ArrayList<Voyage> getListByParam(String setting, String value) throws DAOExceptions {
        LOG.info("Get list by parameter");
        String sql = null;
        switch (setting) {
            case "place of sending": {
                sql = "SELECT * FROM voyage where place_of_sending = ? ";
                break;
            }
            case "place of arriving": {
                sql = "SELECT * FROM voyage where place_of_arriving = ? ";
                break;
            }

            case "time of sending": {
                sql = "SELECT * FROM voyage where time_of_sending = ? ";
                break;
            }
        }

        ArrayList<Voyage> listOfVoyages = new ArrayList<>();

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Voyage voyage = createVoyage(resultSet);
                listOfVoyages.add(voyage);
            }
        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return listOfVoyages;
    }


    private Voyage createVoyage(ResultSet resultSet) throws SQLException {
        LOG.info("create new instance of voyage");

        long idvoyage = resultSet.getLong("idvoyage");
        long idAirport = resultSet.getLong("idairport");
        long idTeam = resultSet.getLong("idteam");
        String placeOfSending = resultSet.getString("place_of_sending");
        String placeOfArriving = resultSet.getString("place_of_arriving");
        String timeOfSending = resultSet.getString("time_of_sending");
        String timeOfArriving = resultSet.getString("time_of_arriving");
        int status = resultSet.getInt("status");

        Voyage voyage = new Voyage.Builder(idvoyage)
                .fromAirport(idAirport)
                .withTeam(idTeam)
                .fromPlaceOfSending(placeOfSending)
                .toPlaceOfArriving(placeOfArriving)
                .withName()
                .atTimeOfSending(timeOfSending)
                .atTimeOfArriving(timeOfArriving)
                .isStatus(status)
                .build();

        return voyage;
    }

    public ArrayList<Voyage> sortedByID(ArrayList<Voyage> list) throws DAOExceptions{
        LOG.info("Sort list of voyages by id");
        ArrayList<Voyage>  listForSorted = getAll();
        listForSorted.sort((Voyage v1, Voyage v2) ->(int) (v1.getIdVoyage() - v2.getIdVoyage()));

        return listForSorted;
    }

    public ArrayList<Voyage> sortByName(ArrayList<Voyage> list) throws DAOExceptions{
        LOG.info("Sort list of voyages by name");
        ArrayList<Voyage> listForSorted = getAll();
       listForSorted.sort((Voyage v1,Voyage v2) -> v1.getName().compareTo(v2.getName()));

        return listForSorted;
    }

}

