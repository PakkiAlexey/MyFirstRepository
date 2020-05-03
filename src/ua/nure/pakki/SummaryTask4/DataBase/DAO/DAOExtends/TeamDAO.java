package ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Util.ConnectionPool;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Airport;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Team;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.*;
import java.util.ArrayList;

public class TeamDAO extends DAO<Team> {
    private static final Logger LOG = Logger.getLogger(RequestDAO.class.getName());

    @Override
    public boolean insert(Team team) throws DAOExceptions {
        LOG.info("Insert team");
        boolean rowsInserted;
        String sql = "INSERT INTO team (idteam,idnavigator,idoperator) value (?,?,?)";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, team.getIdTeam());
            statement.setLong(2, team.getIdNavigator());
            statement.setLong(3, team.getIdOperator());

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return true;
    }

    @Override
    public Team getById(int id) throws DAOExceptions {
        LOG.info("Get team with id = " + id);
        String sql = "SELECT * FROM team where idteam = ?";
        Team team = new Team();
        team.setPilots(getIdOfPilots(id));
        team.setStewardesses(getIdOfStewardesses(id));

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            team.setIdTeam(id);

            if (resultSet.next()) {
                long idOperator = resultSet.getLong("idoperator");
                long idNavigator = resultSet.getLong("idnavigator");

                team.setIdTeam(id);
                team.setIdOperator(idOperator);
                team.setIdNavigator(idNavigator);
            }
        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return team;
    }


    @Override
    public boolean update(Team team) throws DAOExceptions {
        LOG.info("Update team with id = " + team.getIdTeam());
        boolean rowsUpdated;
        String sql = "UPDATE team SET idoperator = ?, idnavigator = ? where idteam = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, team.getIdOperator());
            statement.setLong(2, team.getIdNavigator());

            rowsUpdated = (statement.executeUpdate() > 0);


        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsUpdated;
    }

    @Override
    public boolean delete(Team team) throws DAOExceptions {
        LOG.info("delete team with id = " + team.getIdTeam());
        boolean rowsDeleted;
        String sql = "DELETE from team where idteam = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, team.getIdTeam());
            rowsDeleted = (statement.executeUpdate() > 0);

        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }
        return rowsDeleted;
    }

    @Override
    public ArrayList getAll() throws DAOExceptions {
        LOG.info("get list of teams");
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<Integer> idOfTeam = new ArrayList<>();

        String sql = "SELECT idteam from team";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("idteam");
                teams.add(getById(id));
            }
        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);
        }

        for (Integer id : idOfTeam){
            teams.add(getById(id));
        }

        return teams;

    }

    public ArrayList<Integer> getIdOfStewardesses(long idOfTeam) throws DAOExceptions {
        LOG.info("get id of stewardesses with id of team = " + idOfTeam);
        ArrayList<Integer> listOfId = new ArrayList<>();
        String sql = "SELECT id_stewardess from stewardess_have_team where id_team = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, idOfTeam);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int stewardessId = resultSet.getInt("id_stewardess");
                listOfId.add(stewardessId);
            }
        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);

        }

        return listOfId;
    }

    public ArrayList<Integer> getIdOfPilots(long idOfTeam) throws DAOExceptions {
        LOG.info("get id of pilots with id of team = " + idOfTeam);
        ArrayList<Integer> listOfId = new ArrayList<>();
        String sql = "SELECT id_pilots from pilot_have_team where id_team = ?";

        LOG.trace("Creating connection");
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, idOfTeam);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int stewardessId = resultSet.getInt("id_pilots");
                listOfId.add(stewardessId);
            }
        } catch (SQLException ex) {
            LOG.error("Cannot obtain connection", ex);
            throw new DAOExceptions("Cannot obtain connection", ex);

        }

        return listOfId;
    }
}
