package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Util.ConnectionPool;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Pilot;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PilotDAO extends DAO<Pilot> {
    private static final Logger LOG = Logger.getLogger(RequestDAO.class.getName());

    @Override
    public boolean insert(Pilot pilot) throws DAOExceptions {
        LOG.info("Create new pilot");
        boolean rowsInserted;
        String sql = "INSERT INTO pilot (idpilot, first_name, last_name, age) values (?,?,?,?)";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, pilot.getIdPilot());
            statement.setString(2, pilot.getFirstName());
            statement.setString(3, pilot.getLastName());
            statement.setInt(4,pilot.getAge());

            rowsInserted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsInserted;
    }

    @Override
    public Pilot getById(int idpilot) throws DAOExceptions {
        LOG.info("Getting pilot by id" + idpilot);
        Pilot pilot = new Pilot();
        String sql = "SELECT * FROM pilot where idpilot = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, idpilot);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                pilot = createPilot(resultSet);
            }

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }

        return pilot;
    }


    @Override
    public boolean update(Pilot pilot) throws DAOExceptions {
        LOG.info("update pilot with id = " + pilot.getIdPilot());
        boolean rowsUpdated = false;
        String sql = "UPDATE pilot SET first_name = ?, last_name = ?, age = ? where idpilot = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, pilot.getFirstName());
            statement.setString(2, pilot.getLastName());
            statement.setInt(3, pilot.getAge());
            statement.setLong(4, pilot.getIdPilot());

            rowsUpdated = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsUpdated;
    }

    @Override
    public boolean delete(Pilot pilot) throws DAOExceptions {
        LOG.info("delete pilot with id = " + pilot.getIdPilot());
        boolean rowsDeleted;
        String sql = "DELETE from pilot where idpilot = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, pilot.getIdPilot());
            rowsDeleted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsDeleted;
    }

    @Override
    public ArrayList<Pilot> getAll() throws DAOExceptions {
        LOG.info("Get list of pilots");
        ArrayList<Pilot> listOfpilots = new ArrayList<>();
        String sql = "SELECT * FROM pilot";

        LOG.info("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pilot pilot = createPilot(resultSet);
                listOfpilots.add(pilot);
            }
        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);

        }
        return listOfpilots;
    }

    private Pilot createPilot(ResultSet resultSet) throws SQLException{
        LOG.info("create new instance of pilot");
        Pilot pilot = new Pilot();

        long idpilot = resultSet.getLong("idpilot");
        String firstNameOfPilot = resultSet.getString("first_name");
        String lastNameOfPilot = resultSet.getString("last_name");
        int ageOfpilot = resultSet.getInt("age");

        pilot.setId(idpilot);
        pilot.setFirstName(firstNameOfPilot);
        pilot.setLastName(lastNameOfPilot);
        pilot.setAge(ageOfpilot);

        return pilot;
    }
}
