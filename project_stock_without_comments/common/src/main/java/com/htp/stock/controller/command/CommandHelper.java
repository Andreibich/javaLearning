package com.htp.stock.controller.command;

import com.htp.stock.controller.command.impl.*;

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
        commands.put(CommandName.USER_EDIT, UserEdit.getInstance());
        commands.put(CommandName.USER_GET_ID, UserGetId.getInstance());
        commands.put(CommandName.PRODUCT_LIST, ProductView.getInstance());
        commands.put(CommandName.CODES_LIST, CodesView.getInstance());
        commands.put(CommandName.SHIPMENT_LIST, ShipmentView.getInstance());
        commands.put(CommandName.RECEIPT_LIST, ReceiptView.getInstance());
        commands.put(CommandName.COMPANIES_LIST, CompaniesView.getInstance());
        commands.put(CommandName.STOCK_VIEW, StockView.getInstance());
    }

    public CommandInterface getCommand(HttpServletRequest request) {
        String commandName = request.getParameter(ATTRIBUTE_COMMAND);
        if (commandName != null) {
            CommandName name = CommandName.valueOf(commandName.toUpperCase().replace(DASH, UNDERSCORE));
            return commands.get(name);
        } else {
            return null;
        }
    }

    private enum CommandName {
        AUTORIZATION, REGISTRATION, TEST_COMMAND, USER_DELETE, USER_EDIT, USER_GET_ID, PRODUCT_LIST, CODES_LIST,
        SHIPMENT_LIST, RECEIPT_LIST, COMPANIES_LIST, STOCK_VIEW
    }
}
