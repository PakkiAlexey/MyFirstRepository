package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.UserDAO;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.User;
import ua.nure.pakki.SummaryTask4.Exceptions.AppExceptions;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;
import ua.nure.pakki.SummaryTask4.Path;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand extends Command {

    private static final long serialVersionUID = -3071536505245623473L;
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Login command start ");

        HttpSession httpSession = request.getSession(false);

        if (httpSession == null){
            LOG.trace("No session available");
            LOG.trace("creating one");
            httpSession = request.getSession();
        }

        String local = null;
        if (httpSession.getAttribute("local") != null) {
            local = httpSession.getAttribute("local").toString();
        }

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null || login.isEmpty() || password.isEmpty()){
            throw new AppExceptions("Login and password must be filled ");
        }
        LOG.trace("Request parameters are : " + login + " " + password);

        UserDAO userDAO = new UserDAO();
        User user;

        try {
            user = userDAO.getUserByLogin(login);
            LOG.info("Getting user by login = " + login);
            LOG.trace("Get user with id = " + user.getId());
        }catch (DAOExceptions ex){
            LOG.error("Cannot obtain connection", ex);
            throw new AppExceptions("Some problem with connection");
        }


        if (user == null || !password.equals(user.getPassword())){
            if ((local != null) && (local.equals("en"))) {
                LOG.trace("There is no such user");
                throw new AppExceptions("Cannot find user with such login/password");
            } else if ((local == null) || (local.equals("ru"))) {
                LOG.info("user is null azazaz");
                throw new AppExceptions("По такой логину/паролю пользователя не существует");
            }
        }
        LOG.info("still controller");
        String forward = Path.ERROR_PAGE;
        LOG.trace("forward is " + forward);

        if (user.getRole().equals("Admin")){
             forward = Path.ADMIN_PAGE;
             LOG.trace("forward is " + forward);
        }else if (user.getRole().equals("Dispatcher")){
            forward = Path.DISPATCHER_PAGE;
            LOG.trace("forward is " + forward);
        }else if (user.getRole().equals("Guest")){
            forward = Path.GUEST_PAGE;
        }

        return forward;
    }
}
