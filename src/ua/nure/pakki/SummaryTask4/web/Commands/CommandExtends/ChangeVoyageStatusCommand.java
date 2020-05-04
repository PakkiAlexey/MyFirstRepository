package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.VoyageDAO;
import ua.nure.pakki.SummaryTask4.Exceptions.AppExceptions;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;
import ua.nure.pakki.SummaryTask4.Path;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ChangeVoyageStatusCommand extends Command {
    private static final Logger LOG = Logger.getLogger(CreateRequestCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Start changeVoyageStatus command");
        String forward = Path.ERROR_PAGE;
        int idVoyage = Integer.valueOf(request.getParameter("idМщнфпу"));

        VoyageDAO voyageDAO = new VoyageDAO();

        try{
            LOG.trace("Changing status of voyage with id = " + idVoyage);
            voyageDAO.changeStatusOfVoyage(idVoyage);
            forward = Path.DISPATCHER_PAGE;
        }catch (DAOExceptions ex){
            LOG.error("Connection obtain problem", ex);
            throw new AppExceptions("Problem with connection");
        }

        return forward;
    }
}
