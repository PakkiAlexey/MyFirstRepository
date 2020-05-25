package DataBase.DAO.DAOExtends;

import DataBase.DAO.DAO;
import DataBase.DAO.Util.ConnectionPool;
import DataBase.Model.User;
import Exceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends DAO<User> {

    @Override
    public boolean insert(User user) throws DAOExceptions {
        boolean rowsInserted;
        String sql = "insert into users (first_name, last_name,email,phone) values (?,?,?,?);";
        //LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());

            rowsInserted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            //LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsInserted;

    }

    @Override
    public boolean update(User user) throws DAOExceptions {
        boolean rowsUpdated;
        String sql = "update users set first_name = ?, last_name = ?, email = ?, phone = ? where ID = ?";
        //LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.setInt(5, user.getIdUser());

            rowsUpdated = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            //LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsUpdated;
    }

    @Override
    public User getById(int idUser) throws DAOExceptions {
        User user = new User();
        String sql = "select * from users where ID = ?;";

        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idUser);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = createUser(resultSet);
            }

        } catch (SQLException ex) {
            //LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return user;
    }

    @Override
    public boolean delete(User user) throws DAOExceptions {
        boolean rowsDeleted;
        String sql = "delete from users where ID = ?";
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setInt(1, user.getIdUser());
            rowsDeleted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            throw new DAOExceptions("Cannot obtain connection", ex);
        }

        return rowsDeleted;
    }

    @Override
    public ArrayList<User> getAll() throws DAOExceptions {
        ArrayList<User> listOfUsers = new ArrayList<>();

        String sql = "select * from users";

        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = createUser(resultSet);
                listOfUsers.add(user);
            }
        } catch (SQLException ex) {
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return listOfUsers;
    }

    private User createUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        int idUser = resultSet.getInt("ID");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");

        user.setIdUser(idUser);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);

        return user;
    }
}
