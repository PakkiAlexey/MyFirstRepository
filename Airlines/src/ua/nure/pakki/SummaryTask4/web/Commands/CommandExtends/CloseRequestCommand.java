package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.RequestDAO;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Request;
import ua.nure.pakki.SummaryTask4.Exceptions.AppExceptions;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;
import ua.nure.pakki.SummaryTask4.Path;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CloseRequestCommand extends Command {
    private static final Logger LOG = Logger.getLogger(CloseRequestCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Get request command start");

        int id = Integer.valueOf(request.getParameter("id"));
        Request myRequest;
        String forward = Path.ERROR_PAGE;

        try {
            myRequest = new RequestDAO().getById(id);
            LOG.trace("deleting voyage with id = " + id);
            new RequestDAO().delete(myRequest);

            forward = Path.ADMIN_PAGE;
        }catch (DAOExceptions ex){
            LOG.error("Cannot obtain connection",ex);
            throw new AppExceptions("Problem with connection");
        }

        return forward;
    }
}
