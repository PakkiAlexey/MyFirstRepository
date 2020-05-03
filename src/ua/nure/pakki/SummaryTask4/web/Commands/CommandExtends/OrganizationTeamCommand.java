package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.TeamDAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactory;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactoryExtends.TeamDAOFactory;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.Team;
import ua.nure.pakki.SummaryTask4.Exceptions.AppExceptions;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;
import ua.nure.pakki.SummaryTask4.Path;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class OrganizationTeamCommand extends Command {
    private static final Logger LOG = Logger.getLogger(SelectOfVoyagesCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Organization team command start");
        DAOFactory daoFactory = new TeamDAOFactory();
        TeamDAO teamDAO = new TeamDAO();

        int id = Integer.valueOf(request.getParameter("teamId"));

        String forward = Path.ERROR_PAGE;
        Team team = new Team();
        ArrayList<Integer> pilots = new ArrayList<>();
        ArrayList<Integer> stewardesses = new ArrayList<>();

        try{
            team = teamDAO.getById(id);
            pilots = teamDAO.getIdOfPilots(id);
            stewardesses = teamDAO.getIdOfStewardesses(id);

            request.setAttribute("team", team);
            LOG.trace("pilots " + pilots.size());
            request.setAttribute("pilots",pilots);
            LOG.trace("stewardesses " + stewardesses.size());
            request.setAttribute("stewardesses",stewardesses);

            forward = Path.DISPATCHER_PAGE;

        }catch (DAOExceptions ex){
            LOG.error("Problem with connection", ex);
            throw new AppExceptions("Problem with connection");
        }
        return forward;
    }
}
