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
        commands.put("allList", new AllListOfVoyagesCommand());
        commands.put("sortedList", new SortedListOfVoyagesCommand());
        commands.put("organizationTeam", new OrganizationTeamCommand());
        commands.put("noCommand", new NoCommand());

    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOG.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
