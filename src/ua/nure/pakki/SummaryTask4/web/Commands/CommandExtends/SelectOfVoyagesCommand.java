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
import java.util.ArrayList;

public class SelectOfVoyagesCommand extends Command {
    private static final Logger LOG = Logger.getLogger(SelectOfVoyagesCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Get selection command start");
        String option = request.getParameter("Selection by");
        String value = request.getParameter("value");

        ArrayList<Voyage> voyages = new ArrayList<>();
        VoyageDAO voyageDAO = new VoyageDAO();
        String forward = Path.ERROR_PAGE;

        try {
            LOG.trace("Get select by " + option + "and" + value);

            voyages = voyageDAO.getListByParam(option,value);
            LOG.trace("Set attribute to voyages");
            request.setAttribute("voyagesSelection", voyages);
            forward = Path.GUEST_PAGE;

        }catch (DAOExceptions ex){
            LOG.error("Problem with connection", ex);
            throw new AppExceptions("Problem with connection");
        }

        return forward;
    }
}
