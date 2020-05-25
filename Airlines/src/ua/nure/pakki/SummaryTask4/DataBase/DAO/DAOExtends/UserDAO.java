package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Util.ConnectionPool;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.User;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends DAO<User> {
    private static final Logger LOG = Logger.getLogger(RequestDAO.class.getName());

    @Override
    public boolean insert(User user) throws DAOExceptions {
       return false;
    }

    @Override
    public User getById(int id) throws DAOExceptions {
        return null;
    }

    @Override
    public boolean update(User element) throws DAOExceptions {
        return false;
    }

    @Override
    public boolean delete(User element) throws DAOExceptions {
        return false;
    }

    @Override
    public ArrayList<User> getAll() throws DAOExceptions {
        return null;
    }

    public User getUserByLogin(String login) throws DAOExceptions{
        LOG.info("Get user by login " + login);
        String sql = "SELECT * from users where Login = ?";
        User user = new User();

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                int idUser = resultSet.getInt("idUser");
                int idAirport = resultSet.getInt("idAirport");
                String password = resultSet.getString("Password");
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String role = resultSet.getString("Role");

                user = new User.Builder(idUser)
                        .workingInAirport(idAirport)
                        .withFirstName(firstName)
                        .withLastName(lastName)
                        .hasLogin(login)
                        .hasPassword(password)
                        .isRole(role)
                        .build();

            }


        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }

        return user;
    }
}
