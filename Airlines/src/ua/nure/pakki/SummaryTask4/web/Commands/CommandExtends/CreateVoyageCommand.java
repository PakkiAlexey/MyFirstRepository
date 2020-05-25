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

public class CreateVoyageCommand extends Command  {
    private static final Logger LOG = Logger.getLogger(CreateVoyageCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        int id = Integer.valueOf(request.getParameter("id"));
        int idAirport = Integer.valueOf(request.getParameter("idAirport"));
        int idTeam = Integer.valueOf(request.getParameter("idTeam"));
        String placeOfSending = request.getParameter("placeOfSending");
        String placeOfArriving = request.getParameter("placeOfArriving");
        String timeOfSending = request.getParameter("timeOfSending");
        String timeOfArriving = request.getParameter("timeOfArriving");
        int status = Integer.valueOf(request.getParameter("status"));

        Voyage voyage = new Voyage.Builder(id)
                .fromAirport(idAirport)
                .withTeam(idTeam)
                .fromPlaceOfSending(placeOfSending)
                .toPlaceOfArriving(placeOfArriving)
                .atTimeOfSending(timeOfSending)
                .atTimeOfArriving(timeOfArriving)
                .isStatus(status)
                .build();

        String forward = Path.ERROR_PAGE;

        LOG.trace("Updating voyage with id = " + id);
        try {
            new VoyageDAO().insert(voyage);
            forward = Path.ADMIN_PAGE;
        }catch (DAOExceptions ex){
            LOG.error("Connection problem", ex);
            throw new AppExceptions("Connection problem");
        }

        return forward;
    }

}


