package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Util.ConnectionPool;


import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Navigator;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Request;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NavigatorDAO extends DAO<Navigator> {
    private static final Logger LOG = Logger.getLogger(NavigatorDAO.class.getName());

    @Override
    public boolean insert(Navigator navigator) throws DAOExceptions {
        boolean rowsInserted;
        LOG.info("Create new navigator");
        String sql = "INSERT INTO navigator (idnavigator, first_name, last_name, age) values (?,?,?,?)";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, navigator.getId());
            statement.setString(2, navigator.getFirstName());
            statement.setString(3, navigator.getLastName());
            statement.setInt(4,navigator.getAge());
            
            rowsInserted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsInserted;
    }

    @Override
    public Navigator getById(int idNavigator) throws DAOExceptions {
        LOG.info("Get navigator by id" + idNavigator);
        Navigator navigator = new Navigator();
        String sql = "SELECT * FROM navigator where idnavigator = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, idNavigator);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                navigator = createNavigator(resultSet);
            }

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }

        return navigator;
    }


    @Override
    public boolean update(Navigator navigator) throws DAOExceptions {
        LOG.info("update navigator with id = " + navigator.getId());
        boolean rowsUpdated = false;
        String sql = "UPDATE navigator SET first_name = ?, last_name = ?, age = ? where idnavigator = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, navigator.getFirstName());
            statement.setString(2, navigator.getLastName());
            statement.setInt(3, navigator.getAge());
            statement.setInt(4,navigator.getId());


            rowsUpdated = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsUpdated;
    }

    @Override

    public boolean delete(Navigator navigator) throws DAOExceptions {
        LOG.info("delete navigator with id = " + navigator.getId());
        boolean rowsDeleted;
        String sql = "DELETE from navigator where idnavigator = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, navigator.getId());
            rowsDeleted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsDeleted;
    }

    @Override
    public ArrayList<Navigator> getAll() throws DAOExceptions {
        LOG.info("get all list of navigator");
        ArrayList<Navigator> listOfnavigators = new ArrayList<>();
        String sql = "SELECT * FROM navigator";

        LOG.info("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Navigator navigator = createNavigator(resultSet);
                listOfnavigators.add(navigator);
            }
        } catch (SQLException ex) {
             LOG.error("Cannot obtain connection", ex);
             throw new DAOExceptions("Cannot obtain connection", ex);

        }
        return listOfnavigators;
    }

    private Navigator createNavigator(ResultSet resultSet) throws SQLException{
        LOG.info("create entity of navigator");
        Navigator navigator = new Navigator();

        int idNavigator = resultSet.getInt("idnavigator");
        String firstNameOfNavigator = resultSet.getString("first_name");
        String lastNameOfNavigator = resultSet.getString("last_name");
        int ageOfNavigator = resultSet.getInt("age");

        navigator.setId(idNavigator);
        navigator.setFirstName(firstNameOfNavigator);
        navigator.setLastName(lastNameOfNavigator);
        navigator.setAge(ageOfNavigator);

        return navigator;
    }
}
