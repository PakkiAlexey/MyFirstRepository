package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Util.ConnectionPool;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Operator;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperatorDAO extends DAO<Operator> {
    private static final Logger LOG = Logger.getLogger(RequestDAO.class.getName());

    @Override
    public boolean insert(Operator operator) throws DAOExceptions {
        boolean rowsInserted;
        LOG.info("Create new operator");
        String sql = "INSERT INTO operator (idoperator, first_name, last_name, age) values (?,?,?,?)";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, operator.getId());
            statement.setString(2, operator.getFirstName());
            statement.setString(3, operator.getLastName());
            statement.setInt(4, operator.getAge());

            rowsInserted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsInserted;
    }

    @Override
    public Operator getById(int idoperator) throws DAOExceptions {
        LOG.info("Getting operator by id" + idoperator);
        Operator operator = new Operator();
        String sql = "SELECT * FROM operator where idoperator = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, idoperator);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                operator = createOperator(resultSet);
            }

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }

        return operator;
    }


    @Override
    public boolean update(Operator operator) throws DAOExceptions {
        LOG.info("Update operator with id = " + operator.getId());
        boolean rowsUpdated = false;
        String sql = "UPDATE operator SET first_name = ?, last_name = ?, age = ? where idoperator = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, operator.getFirstName());
            statement.setString(2, operator.getLastName());
            statement.setInt(3, operator.getAge());
            statement.setLong(4, operator.getId());

            rowsUpdated = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsUpdated;
    }

    @Override
    public boolean delete(Operator operator) throws DAOExceptions {
        LOG.info("delete operator with id = " + operator.getId());
        boolean rowsDeleted;
        String sql = "DELETE from operator where idoperator = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, operator.getId());
            rowsDeleted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsDeleted;
    }

    @Override
    public ArrayList<Operator> getAll() throws DAOExceptions {
        LOG.info("Get list of operators");

        ArrayList<Operator> listOfoperators = new ArrayList<>();
        String sql = "SELECT * FROM operator";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Operator operator = createOperator(resultSet);
                listOfoperators.add(operator);
            }
        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);

        }
        return listOfoperators;
    }

    private Operator createOperator(ResultSet resultSet) throws SQLException {
        LOG.info("create new operator instance");
        Operator operator = new Operator();

        int idoperator = resultSet.getInt("idoperator");
        String firstNameOfoperator = resultSet.getString("first_name");
        String lastNameOfoperator = resultSet.getString("last_name");
        int ageOfoperator = resultSet.getInt("age");

        operator.setId(idoperator);
        operator.setFirstName(firstNameOfoperator);
        operator.setLastName(lastNameOfoperator);
        operator.setAge(ageOfoperator);

        return operator;
    }
}
