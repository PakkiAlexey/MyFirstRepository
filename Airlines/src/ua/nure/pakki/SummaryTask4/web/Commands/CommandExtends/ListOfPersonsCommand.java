package ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.DataBase.DAO.DAOExtends.*;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeam;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Navigator;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Operator;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Pilot;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Stewardess;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends.Pilot;
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
import java.util.HashSet;
import java.util.Set;

public class ListOfPersonsCommand extends Command {
    private static final Logger LOG = Logger.getLogger(ListOfPersonsCommand.class.getName());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppExceptions {
        LOG.info("List of Person command start");
        String forward = Path.ERROR_PAGE;


        try {
            LOG.trace("Getting list of persons");

            Set<Navigator> setOfNavigators = new HashSet<>(new NavigatorDAO().getAll());
            Set<Pilot> setOfPilots = new HashSet<>(new PilotDAO().getAll());
            Set<Stewardess> setOfStewardess = new HashSet<>(new StewardessDAO().getAll());
            Set<Operator> setOfOperators = new HashSet<>(new OperatorDAO().getAll());

            request.setAttribute("navigators", setOfNavigators);
            request.setAttribute("operators", setOfOperators);
            request.setAttribute("pilots", setOfPilots);
            request.setAttribute("stewardesses", setOfStewardess);

            forward = Path.ADMIN_PAGE;
            LOG.trace("forward is " + forward);


        } catch (DAOExceptions ex) {
            LOG.error("Problem with connection");
            throw new AppExceptions("Problem with connection");
        }
        return forward;
    }





}
