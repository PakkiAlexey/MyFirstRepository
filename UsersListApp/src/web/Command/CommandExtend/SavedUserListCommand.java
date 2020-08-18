package web.Command.CommandExtend;

import DataBase.DAO.DAOExtends.UserDAO;
import DataBase.Model.User;
import Exceptions.AppExceptions;
import Exceptions.DAOExceptions;
import org.apache.log4j.Logger;
import web.Command.Command;
import web.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class SavedUserListCommand extends Command {
    private static final Logger LOG = Logger.getLogger(SavedUserListCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        CopyOnWriteArrayList<User> listOfSavedUsers = new CopyOnWriteArrayList<>();
        String forward;
        UserDAO userDAO = new UserDAO();

        LOG.trace("Getting list of users");
        try{
           listOfSavedUsers = userDAO.getAll();
           request.setAttribute("listOfSavedUsers",listOfSavedUsers);
           forward = Path.SAVED_USER_LIST_PAGE;
        }catch (DAOExceptions ex){
           throw new AppExceptions("Cannot obtain connection", ex);
        }
        return forward;
    }
}
