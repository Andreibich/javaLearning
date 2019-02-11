package com.htp.stock.controller.command.impl;

import com.htp.stock.controller.command.CommandException;
import com.htp.stock.controller.command.CommandInterface;
import com.htp.stock.service.ReceiptService;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.impl.CompaniesServiceImpl;
import com.htp.stock.service.impl.ReceiptServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReceiptView implements CommandInterface {

    private static final ReceiptService SERVICE = ReceiptServiceImpl.getInstance();

    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String ERROR_PAGE = "/error";

    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private ReceiptView() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException {
        try {
            request.setAttribute("receiptList",SERVICE.loadAll());
        } catch (ServiceException e) {
            LOGGER.error("CommandException", e);
            response.sendRedirect(request.getContextPath() + ERROR_PAGE);
            throw new CommandException();
        }
        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);

        return "/receiptList";
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new ReceiptView();
    }
}
