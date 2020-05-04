package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.AirportDAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.VoyageDAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactory;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactoryExtends.VoyageDAOFactory;
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
import java.util.List;

public class SortedListOfVoyagesCommand extends Command {
    private static final Logger LOG = Logger.getLogger(SelectOfVoyagesCommand.class.getName());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Sort list of voyages started");

        String forward = Path.ERROR_PAGE;
        VoyageDAO voyageDAO = new VoyageDAO();

        LOG.trace("Get list of all voyages");
        try {
            ArrayList<Voyage> voyages = voyageDAO.getAll();

            String option = request.getParameter("Sorted by");

            if (option.equals("name")){
                voyages = voyageDAO.sortByName(voyages);
            }else if (option.equals("id")){
                voyages = voyageDAO.sortedByID(voyages);
            }

            LOG.trace("Set attribute to voyages");
            request.setAttribute("sortedVoyages", voyages);

            forward = Path.GUEST_PAGE;
            LOG.trace("forward is " + forward);

        }catch (DAOExceptions ex){
            LOG.error("Connection problem", ex);
            throw new AppExceptions("Some problem with connection");
        }

        return forward;
    }

}
