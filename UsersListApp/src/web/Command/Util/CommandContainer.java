package web.Command.Util;

import org.apache.log4j.Logger;
import web.Command.Command;
import web.Command.CommandExtend.*;


import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private static final Logger LOG = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new HashMap<>();



    static {
        commands.put("savedUsers", new SavedUserListCommand());
        commands.put("users", new UsersListCommand());
        commands.put("deleteUser", new DeleteUserCommand());
        commands.put("showEditUser", new ShowEditUserCommand());
        commands.put("editUser", new EditUserCommand());
        commands.put("insertUser", new AddNewUserCommand());

    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOG.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
