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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNewUserCommand extends Command {
    private static final Logger LOG = Logger.getLogger(AddNewUserCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.trace("Add new user command");
        String forward = Path.ERROR_PAGE_PHONE;

        int idUser = Integer.parseInt(request.getParameter("idUser"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

       if(!nameValidate(firstName,lastName)){
           return forward = Path.ERROR_PAGE_NAME;
       }
        String email = request.getParameter("email");

        if (!emailValidate(email)){
            return forward = Path.ERROR_PAGE_EMAIL;
        }
        String phone = request.getParameter("phone");

        User user = new User(idUser,firstName,lastName,email,phone);

        UserDAO userDAO = new UserDAO();

        try{
            forward = Path.SAVED_USER_LIST_PAGE;
            LOG.trace("Insert new user");
            userDAO.insert(user);

        }catch (DAOExceptions ex){
            LOG.error("Problem with connection",ex);
            throw new AppExceptions("problem with connection",ex);
        }
        return forward;
    }

    private Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("[\\w-]+@([\\w-]+\\.)+[\\w-]+", Pattern.CASE_INSENSITIVE);

    private boolean emailValidate(String emailStr) {
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
