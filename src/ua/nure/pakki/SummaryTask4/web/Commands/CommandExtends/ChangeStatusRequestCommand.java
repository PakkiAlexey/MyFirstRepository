package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.RequestDAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.VoyageDAO;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Request;
import ua.nure.pakki.SummaryTask4.Exceptions.AppExceptions;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;
import ua.nure.pakki.SummaryTask4.Path;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeStatusRequestCommand extends Command {
    private static final Logger LOG = Logger.getLogger(ChangeStatusRequestCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {

        LOG.info("Start changeVoyageStatus command");
        String forward = Path.ERROR_PAGE;
        int id = Integer.valueOf(request.getParameter("id"));


        try {
            LOG.trace("Changing status of request with id = " + id);
           new RequestDAO().changeStatusOfRequest(id);
            forward = Path.ADMIN_PAGE;
        } catch (DAOExceptions ex) {
            LOG.error("Connection obtain problem", ex);
            throw new AppExceptions("Problem with connection");
        }

        return forward;
    }
}

