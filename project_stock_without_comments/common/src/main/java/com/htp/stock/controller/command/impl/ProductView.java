package com.htp.stock.controller.command.impl;

import com.htp.stock.controller.command.CommandException;
import com.htp.stock.controller.command.CommandInterface;
import com.htp.stock.service.ProductCatalogService;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.impl.ProductCatalogServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductView implements CommandInterface {

    private static final ProductCatalogService SERVICE = ProductCatalogServiceImpl.getInstance();

    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String ERROR_PAGE = "/error";

    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private ProductView() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException {
        try {
            request.setAttribute("productList",SERVICE.loadAll());
        } catch (ServiceException e) {
            LOGGER.error("CommandException", e);
            response.sendRedirect(request.getContextPath() + ERROR_PAGE);
            throw new CommandException();
        }
        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);

        return "/productList";
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new ProductView();
    }
}
