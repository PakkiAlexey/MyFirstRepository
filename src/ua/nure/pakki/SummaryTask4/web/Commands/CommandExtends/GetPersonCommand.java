package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAO;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactory;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactoryExtends.NavigatorDAOFactory;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactoryExtends.OperatorDAOFactory;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.DAOFactoryExtends.StewardessDAOFactory;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.Factory.PilotDAOFactory;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeam;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Navigator;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Operator;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Pilot;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Stewardess;
import ua.nure.pakki.SummaryTask4.Exceptions.AppExceptions;
import ua.nure.pakki.SummaryTask4.Exceptions.DAOExceptions;
import ua.nure.pakki.SummaryTask4.Path;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetPersonCommand extends Command {
    private static final Logger LOG = Logger.getLogger(GetPersonCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Update person command start");

        MemberOfTeam memberOfTeam;
        DAO dao;
        DAOFactory daoFactory;
        String position = request.getParameter("position");

        LOG.trace("Creating instance of member of team");
        switch (position) {
            case "pilot": {
                daoFactory = new PilotDAOFactory();
                dao = daoFactory.createDAO();
                memberOfTeam = new Pilot();
                LOG.trace("Member is pilot");
                break;
            }
            case "navigator": {
                daoFactory = new NavigatorDAOFactory();
                dao = daoFactory.createDAO();
                LOG.trace("member is navigator");
                memberOfTeam = new Navigator();
                break;
            }

            case "operator": {
                daoFactory = new OperatorDAOFactory();
                dao = daoFactory.createDAO();
                memberOfTeam = new Operator();
                LOG.trace("member is operator");
                break;
            }
            case "stewardess": {
                daoFactory = new StewardessDAOFactory();
                dao = daoFactory.createDAO();
                memberOfTeam = new Stewardess();
                LOG.info("member is stewardess");
                break;
            }

            default: {
                return Path.ERROR_PAGE;
            }
        }

        int id = Integer.valueOf(request.getParameter("id"));

        String forward = Path.ERROR_PAGE;

        try {
            memberOfTeam = (MemberOfTeam)dao.getById(id);
            request.setAttribute("member",memberOfTeam);
            forward = Path.PERSON_UPDATE_PAGE;

        } catch (DAOExceptions ex) {
            LOG.error("Can not obtain connection", ex);
            throw new AppExceptions("Connection problem");

        }
        return forward;
    }
}
