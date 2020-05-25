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
import ua.nure.pakki.SummaryTask4.web.Commands.Util.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreatePersonCommand extends Command {
    private static final Logger LOG = Logger.getLogger(CreatePersonCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("Create person command start");

        int id = Integer.valueOf(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.valueOf(request.getParameter("age"));
        String position = request.getParameter("position");

        MemberOfTeam memberOfTeam;
        DAOFactory daoFactory;
        DAO dao;

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
        String forward = Path.ERROR_PAGE;

        memberOfTeam.setId(id);
        memberOfTeam.setFirstName(firstName);
        memberOfTeam.setLastName(lastName);
        memberOfTeam.setAge(age);

        LOG.trace("Creating new person");
        try{
            LOG.trace("before inserting" +  dao.getAll().size() );
            dao.insert(memberOfTeam);
            LOG.trace("after inserting" +  dao.getAll().size() );
            forward = Path.ADMIN_PAGE;
        }catch (DAOExceptions ex){
            LOG.error("Cannot obtain connection", ex);
            throw new AppExceptions("Connection problem");
        }

        return forward;
    }
}
