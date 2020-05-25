package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.VoyageDAO;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Voyage;
import ua.nure.pakki.SummaryTask4.Exceptions.AppExceptions;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;
import ua.nure.pakki.SummaryTask4.Path;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetVoyageCommand extends Command {
    private static final Logger LOG = Logger.getLogger(GetVoyageCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Update voyage command starts");

        int id = Integer.valueOf(request.getParameter("id"));

        String forward = Path.ERROR_PAGE;

        LOG.trace("Getting voyage");

        try{
            Voyage voyage = new VoyageDAO().getById(id);
            request.setAttribute("voyage", voyage);
            forward = Path.VOYAGE_UPDATE_PAGE;
        }catch (DAOExceptions ex){
            LOG.error("Cannot obtain connection");
            throw new AppExceptions("Problem with connection");
        }

        return forward;
    }
}
