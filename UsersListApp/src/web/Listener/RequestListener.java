//package web.Listener;
//
//import DataBase.DAO.DAO;
//import DataBase.DAO.DAOExtends.UserDAO;
//import DataBase.Model.User;
//import Exceptions.DAOExceptions;
//import org.apache.log4j.Logger;
//import web.Command.Util.CommandContainer;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebListener;
//import java.util.ArrayList;
//
//@WebListener
//public class RequestListener implements ServletRequestListener {
//    private static final Logger LOG = Logger.getLogger(RequestListener.class);
//    private ArrayList<User> listOfSavedUsers = new ArrayList<>();
//
//
//    @Override
//    public void requestDestroyed(ServletRequestEvent sre) {
//        LOG.trace("DESTROYING REQUEST");
//        ServletContext servletContext = sre.getServletContext();
//        UserDAO userDAO = new UserDAO();
//        try {
//            LOG.trace("Get list of saved users");
//            listOfSavedUsers = userDAO.getAll();
//            LOG.trace("Set attribute listOfUsers with size" + listOfSavedUsers.size());
//            servletContext.setAttribute("listOfSavedUsers", listOfSavedUsers);
//        } catch (DAOExceptions ex) {
//            LOG.error("Problem with connection", ex);
//        }
//    }
//
//    @Override
//    public void requestInitialized(ServletRequestEvent sre) {
//        ArrayList<User> listOfSavedUsers = new ArrayList<>();
//        LOG.trace("INITIALIZATION REQUEST");
//        ServletContext servletContext = sre.getServletContext();
//        UserDAO userDAO = new UserDAO();
//        try {
//            LOG.trace("Get list of saved users");
//            listOfSavedUsers = userDAO.getAll();
//            LOG.trace("Set attribute listOfUsers with size" + listOfSavedUsers.size());
//            servletContext.setAttribute("listOfSavedUsers", listOfSavedUsers);
//        } catch (DAOExceptions ex) {
//            LOG.error("Problem with connection", ex);
//        }
//    }
//}
