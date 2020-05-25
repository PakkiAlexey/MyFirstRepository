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
import java.util.stream.IntStream;

public class DeleteUserCommand extends Command {
    private static final Logger LOG = Logger.getLogger(DeleteUserCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.trace("Delete User");
        UserDAO userDAO = new UserDAO();

        int id = Integer.valueOf(request.getParameter("idUser"));
        LOG.trace("ID of deleting user is: " + id);

        String forward = Path.ERROR_PAGE;

        LOG.trace("Deleting user from database");
        try{
            User user = userDAO.getById(id);
            userDAO.delete(user);
            forward = Path.SAVED_USER_LIST_PAGE;
        }catch (DAOExceptions ex){
            LOG.error("Cannot obtain connection",ex);
            throw new AppExceptions("Connection problem",ex);
        }


        return forward;
    }
}
