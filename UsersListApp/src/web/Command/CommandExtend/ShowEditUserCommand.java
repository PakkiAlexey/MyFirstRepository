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

public class ShowEditUserCommand extends Command {
    private static final Logger LOG = Logger.getLogger(ShowEditUserCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.trace("Show edit user command");
        int userId = Integer.parseInt(request.getParameter("idUser"));

        LOG.trace("Editing user with ");
        UserDAO userDAO = new UserDAO();

        String forward;
        LOG.trace("Getting user by id");
        User user;

        if (request.getParameter("typeOfList").equals("users")) {
            LOG.trace("Getting user with id = " + userId);
            user = UsersListCommand.getListOfUsers().get(userId - 1);
            request.setAttribute("user", user);
            forward = Path.EDIT_USER_PAGE;
        } else {
            try {
                user = userDAO.getById(userId);
                LOG.trace("Setting attribute");
                request.setAttribute("user", user);
                forward = Path.EDIT_USER_PAGE;
            } catch (DAOExceptions ex) {
                LOG.error("Connection problem", ex);
                throw new AppExceptions("Connection problem", ex);
            }
        }

            return forward;
        }
    }
