package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Util.ConnectionPool;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Request;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Voyage;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequestDAO extends DAO<Request> {
    private static final Logger LOG = Logger.getLogger(RequestDAO.class.getName());

    @Override
    public boolean insert(Request request) throws DAOExceptions {
        boolean rowsInserted;
        LOG.info("Create new request");
        String sql = "INSERT INTO request (idrequest,idteam,idvoyage, status, massage) values (?,?,?,?,?)";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setInt(1,request.getId());
            statement.setInt(2, request.getIdTeam());
            statement.setInt(3, request.getIdVoyage());
            statement.setBoolean(4, request.isStatus());
            statement.setString(5,request.getMassage());

            rowsInserted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsInserted;
    }

    @Override
    public Request getById(int id) throws DAOExceptions {
        Request request = new Request();
        LOG.info("Getting request by id" + id);
        String sql = "SELECT * FROM request where idrequest = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idrequest = id;
                int idTeam = resultSet.getInt("idteam");
                int idVoyage = resultSet.getInt("idvoyage");
                boolean status = resultSet.getBoolean("status");

                request.setId(idrequest);
                request.setIdTeam(idTeam);
                request.setIdVoyage(idVoyage);
                request.setStatus(status);
            }

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }

        return request;
    }

    public boolean changeStatusOfRequest(int id) throws DAOExceptions {
        LOG.info("Changing status of voyage");

        boolean rowsUpdated;

        String sql = "UPDATE request set status = ? where idrequest = ?";
        Request request = getById(id);

        LOG.trace("Create connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            LOG.trace("change voyage status");
            statement.setBoolean(1,!request.isStatus());
            statement.setInt(2,id);

            rowsUpdated = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("cannot obtain connection", ex);
            throw new DAOExceptions("cannot obtain connection", ex);
        }

        return rowsUpdated;
    }


    @Override
    public boolean update(Request request) throws DAOExceptions {
        LOG.info("update request with id = " + request.getId());
        boolean rowsUpdated = false;
        String sql = "UPDATE request SET idteam = ?, idvoyage = ?, status = ? where idvoyage = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, request.getIdTeam());
            statement.setInt(2, request.getIdVoyage());
            statement.setBoolean(3, request.isStatus());
            statement.setInt(4, request.getId());

            rowsUpdated = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsUpdated;
    }

    @Override
    public boolean delete(Request request) throws DAOExceptions {
        LOG.info("delete request with id = " + request.getId());
        boolean rowsDeleted;
        String sql = "DELETE from request where idteam = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setInt(1, request.getId());
            rowsDeleted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsDeleted;
    }

    @Override
    public ArrayList<Request> getAll() throws DAOExceptions {
        LOG.info("Get list of requests");
        ArrayList<Request> listOfrequests = new ArrayList<>();
        ;
        String sql = "SELECT * FROM request";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idRequest = resultSet.getInt("idrequest");
                int idTeam = resultSet.getInt("idteam");
                int idVoyage = resultSet.getInt("idvoyage");
                boolean status = resultSet.getBoolean("status");

                Request request = new Request();

                request.setId(idRequest);
                request.setIdTeam(idTeam);
                request.setIdVoyage(idVoyage);
                request.setStatus(status);

                listOfrequests.add(request);
            }
        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);

        }
        return listOfrequests;
    }
}
