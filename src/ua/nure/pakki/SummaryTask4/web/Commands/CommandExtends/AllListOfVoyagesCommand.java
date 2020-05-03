package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
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
import java.util.List;

public class AllListOfVoyagesCommand extends Command {
    private static final long serialVersionUID = 7732286214029478505L;

    private static final Logger LOG = Logger.getLogger(AllListOfVoyagesCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("All list of voyages command start");

        String forward = Path.ERROR_PAGE;

        DAOFactory factory = new VoyageDAOFactory();
        DAO voyageDao = factory.createDAO();

        LOG.trace("Get list of all voyages");
        try {
            List<Voyage> voyages = voyageDao.getAll();

            LOG.trace("Set attribute to voyages");
            request.setAttribute("voyages", voyages);

            forward = Path.GUEST_PAGE;
            LOG.trace("forward is " + forward);

        }catch (DAOExceptions ex){
            LOG.error("Connection problem", ex);
            throw new AppExceptions("Some problem with connection");
        }
        return forward;
    }
}
