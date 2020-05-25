package ua.nure.pakki.SummaryTask4.web.Commands.Util;

import org.apache.log4j.Logger;
import ua.nure.pakki.SummaryTask4.web.Commands.Command;
import ua.nure.pakki.SummaryTask4.web.Commands.CommandExtends.*;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private static final Logger LOG = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new HashMap<>();

    static {

        commands.put("login", new LoginCommand());
        commands.put("createRequest", new CreateRequestCommand());
        commands.put("selectVoyages", new SelectOfVoyagesCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("findVoyage", new FindVoyageByIDCommand());
        commands.put("changeStatus", new ChangeVoyageStatusCommand());
        commands.put("ListOfVoyages", new AllListOfVoyagesCommand());
        commands.put("sortedList", new SortedListOfVoyagesCommand());
        commands.put("organizationTeam", new OrganizationTeamCommand());
        commands.put("noCommand", new NoCommand());
        commands.put("listOfPersons", new ListOfPersonsCommand());
        commands.put("updatePerson", new UpdatePersonCommand());
        commands.put("getPerson", new GetPersonCommand());
        commands.put("createPerson", new CreatePersonCommand());
        commands.put("deletePerson", new DeletePersonCommand());
        commands.put("getVoyage", new GetVoyageCommand());
        commands.put("deleteVoyages", new DeleteVoyageCommand());
        commands.put("updateVoyage", new UpdateVoyageCommand());
        commands.put("listOfRequest", new GetListOfRequestCommand());
        commands.put("closeRequest", new CloseRequestCommand());
        commands.put("createVoyage", new CreateVoyageCommand());
        commands.put("changeStatusVoyage", new ChangeVoyageStatusCommand());
        commands.put("changeStatusRequest", new ChangeStatusRequestCommand());

    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOG.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
