package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Util.ConnectionPool;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Stewardess;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StewardessDAO extends DAO<Stewardess> {
    private static final Logger LOG = Logger.getLogger(RequestDAO.class.getName());

    @Override
    public boolean insert(Stewardess stewardess) throws DAOExceptions {
        boolean rowsInserted;
        LOG.info("Creating new stewardess");
        String sql = "INSERT INTO stewardess (idstewardess, first_name, last_name, age) values (?,?,?,?)";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, stewardess.getIdStewardess());
            statement.setString(2, stewardess.getFirstName());
            statement.setString(3, stewardess.getLastName());
            statement.setInt(4,stewardess.getAge());

            rowsInserted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsInserted;
    }

    @Override
    public Stewardess getById(int idstewardess) throws DAOExceptions {
        LOG.info("Getting stewardess by id" + idstewardess);
        Stewardess stewardess = new Stewardess();
        String sql = "SELECT * FROM stewardess where idstewardess = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, idstewardess);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                stewardess = createStewardess(resultSet);
            }

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }

        return stewardess;
    }


    @Override
    public boolean update(Stewardess stewardess) throws DAOExceptions {
        LOG.info("update stewardess with id = " + stewardess.getIdStewardess());
        boolean rowsUpdated = false;
        String sql = "UPDATE stewardess SET first_name = ?, last_name = ?, age = ? where idstewardess = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, stewardess.getFirstName());
            statement.setString(2, stewardess.getLastName());
            statement.setInt(3, stewardess.getAge());
            statement.setLong(4, stewardess.getIdStewardess());

            rowsUpdated = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsUpdated;
    }

    @Override
    public boolean delete(Stewardess stewardess) throws DAOExceptions {
        LOG.info("delete stewardess with id = " + stewardess.getIdStewardess());
        boolean rowsDeleted;
        String sql = "DELETE from stewardess where idstewardess = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, stewardess.getIdStewardess());
            rowsDeleted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsDeleted;
    }

    @Override
    public ArrayList<Stewardess> getAll() throws DAOExceptions {
        LOG.info("Getting list of stewardesss");
        ArrayList<Stewardess> listOfstewardesss = new ArrayList<>();
        String sql = "SELECT * FROM stewardess";

        LOG.info("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Stewardess stewardess = createStewardess(resultSet);
                listOfstewardesss.add(stewardess);
            }
        } catch (SQLException ex) {
             LOG.error("Cannot obtain connection", ex);
             throw new DAOExceptions("Cannot obtain connection", ex);

        }
        return listOfstewardesss;
    }

    private Stewardess createStewardess(ResultSet resultSet) throws SQLException{
        LOG.info("create new instance of stewardess");
        Stewardess stewardess = new Stewardess();

        long idstewardess = resultSet.getLong("idstewardess");
        String firstNameOfstewardess = resultSet.getString("first_name");
        String lastNameOfstewardess = resultSet.getString("last_name");
        int ageOfstewardess = resultSet.getInt("age");

        stewardess.setId(idstewardess);
        stewardess.setFirstName(firstNameOfstewardess);
        stewardess.setLastName(lastNameOfstewardess);
        stewardess.setAge(ageOfstewardess);

        return stewardess;
    }
}
