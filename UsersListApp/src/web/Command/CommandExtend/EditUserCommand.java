package web.Command.CommandExtend;

import DataBase.DAO.DAOExtends.UserDAO;
import DataBase.Model.User;
import Exceptions.AppExceptions;
import Exceptions.DAOExceptions;
import org.apache.log4j.Logger;
import web.Command.Command;
import web.Command.Util.CommandContainer;
import web.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditUserCommand extends Command {
    private static final Logger LOG = Logger.getLogger(EditUserCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.trace("Edit user command");
        String forward = Path.ERROR_PAGE_PHONE;

        int idUser = Integer.parseInt(request.getParameter("idUser"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if(!nameValidate(firstName,lastName)){
            return forward = Path.ERROR_PAGE_NAME;
        }
        String email = request.getParameter("email");

        if (!validate(email)){
            return forward = Path.ERROR_PAGE_EMAIL;
        }

        String phone = request.getParameter("phone");

        User user = new User(idUser, firstName, lastName, email, phone);

        UserDAO userDAO = new UserDAO();

        LOG.trace("Updating user with id = " + idUser);
        try {
            userDAO.update(user);
            forward = Path.SAVED_USER_LIST_PAGE;
        } catch (DAOExceptions ex) {
            LOG.error("Problem with connection", ex);
            throw new AppExceptions("Connection problem", ex);
        }
        return forward;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private boolean nameValidate(String firstName, String lastName){
        boolean result = true;

        if ((firstName.length() == 0) || (firstName.length() > 30)){
            result = false;
        }

        if ((lastName.length() == 0) || (lastName.length() > 30)){
            result = false;
        }

        return result;
    }
}
