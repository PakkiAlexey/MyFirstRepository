package ua.nure.pakki.SummaryTask4.DataBase.DAO.Util;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.AirportDAO;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
    private static final Logger LOG = Logger.getLogger(ConnectionPool.class.getName());
    private static ConnectionPool instance;


    private ConnectionPool(){

    }

    public static ConnectionPool getConnectionPool(){
        if (instance==null)
            instance = new ConnectionPool();
        return instance;
    }

    public Connection getConnection() throws DAOExceptions{
        Context ctx;

        Connection connection = null;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/airline");
            LOG.trace("Data source ==> " + ds);
            connection = ds.getConnection();

        } catch (NamingException ex) {
            LOG.error("Cannot obtain data source",ex);
            throw new DAOExceptions("Cannot obtain data source",ex);

        } catch (SQLException ex) {
           LOG.error("cannot obtain connection");
            throw new DAOExceptions("cannot obtain connection",ex);
        }
        return connection;
    }




}
