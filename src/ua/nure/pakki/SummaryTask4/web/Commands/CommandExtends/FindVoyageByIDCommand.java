package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
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
import java.util.List;

public class FindVoyageByIDCommand extends Command {

    private static final long serialVersionUID = 7732286214029478505L;
    private static final Logger LOG = Logger.getLogger(FindVoyageByIDCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Find command starts");
        String id = request.getParameter("idVoyage");
        if (id == null || id.isEmpty()){
            throw new AppExceptions("Cant be empty");
        }
        DAOFactory daoFactory = new VoyageDAOFactory();
        DAO voyageDAO = daoFactory.createDAO();
        String forward = Path.ERROR_PAGE;

        try{
            LOG.trace("Getting voyage by id");
            Voyage voyage = (Voyage)voyageDAO.getById(Integer.valueOf(id));

            LOG.trace("Setting voyage attribute");
            request.setAttribute("foundedVoyage", voyage);

            forward = Path.GUEST_PAGE;
            LOG.trace("forward is " + forward);

        }catch (DAOExceptions ex){
            throw new AppExceptions("Some problem with connection");
        }

        return forward;
    }
}
