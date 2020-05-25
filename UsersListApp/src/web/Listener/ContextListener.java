//package web.Listener;
//
//import DataBase.DAO.DAO;
//import DataBase.DAO.DAOExtends.UserDAO;
//import DataBase.Model.User;
//import Exceptions.DAOExceptions;
//import org.apache.log4j.Logger;
//import web.Command.Util.CommandContainer;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import java.util.ArrayList;
//
//@WebListener
//public class ContextListener implements ServletContextListener {
//    private static final Logger LOG = Logger.getLogger(ContextListener.class);
//    private ArrayList<User> listOfSavedUsers = new ArrayList<>();
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        LOG.trace("Initialization context");
//        ServletContext servletContext = sce.getServletContext();
//        UserDAO userDAO = new UserDAO();
//        try {
//            LOG.trace("Get list of saved users");
//            listOfSavedUsers = userDAO.getAll();
//            LOG.trace("Set attribute listOfUsers with size" + listOfSavedUsers.size());
//            servletContext.setAttribute("listOfSavedUsers",listOfSavedUsers);
//        }catch (DAOExceptions ex){
//            LOG.error("Problem with connection",ex);
//
//        }
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//
//    }
//}
