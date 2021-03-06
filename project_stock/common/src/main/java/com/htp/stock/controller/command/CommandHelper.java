package com.htp.stock.controller.command;

import com.htp.stock.controller.command.impl.LoginCommand;
import com.htp.stock.controller.command.impl.RegistrationCommand;
import com.htp.stock.controller.command.impl.TestCommand;
import com.htp.stock.controller.command.impl.UserDelete;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private static final String ATTRIBUTE_COMMAND = "command";
    private static final String DASH = "-";
    private static final String UNDERSCORE = "_";

    private final Map<CommandName, CommandInterface> commands = new HashMap<>();

    public CommandHelper() {
        commands.put(CommandName.AUTORIZATION, LoginCommand.getInstance());
        commands.put(CommandName.REGISTRATION, RegistrationCommand.getInstance());
        commands.put(CommandName.TEST_COMMAND, TestCommand.getInstance());
        commands.put(CommandName.USER_DELETE, UserDelete.getInstance());
    }

    /**
     * Method determines by request of which command is needed and returns the command object
     *
     * @param request HttpServletRequest
     * @return command object if command exists in map, else return null
     */

    public CommandInterface getCommand(HttpServletRequest request) {
        String commandName = request.getParameter(ATTRIBUTE_COMMAND);
        if(commandName != null) {
            CommandName name = CommandName.valueOf(commandName.toUpperCase().replace(DASH, UNDERSCORE));
            return commands.get(name);
        } else {
            return null;
        }
    }

    private enum CommandName {
        AUTORIZATION, REGISTRATION, TEST_COMMAND, USER_DELETE;
    }
}
