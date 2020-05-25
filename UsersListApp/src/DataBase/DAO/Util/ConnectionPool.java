package DataBase.DAO.Util;

import Exceptions.DAOExceptions;
import org.apache.log4j.Logger;


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
        if (instance == null)
            instance = new ConnectionPool();
        return instance;
    }



    public Connection getConnection() throws DAOExceptions {
        LOG.trace("Get connection");
        Context ctx;

        Connection connection = null;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/usersApplication");
            //LOG.trace("Data source ==> " + ds);
            connection = ds.getConnection();

        } catch (NamingException ex) {
           // LOG.error("Cannot obtain data source",ex);
            throw new DAOExceptions("Cannot obtain data source",ex);

        } catch (SQLException ex) {
            //LOG.error("cannot obtain connection");
            throw new DAOExceptions("cannot obtain connection",ex);
        }
        return connection;
    }
}

