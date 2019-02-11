package com.htp.stock.controller.command.impl;

import com.htp.stock.controller.command.CommandException;
import com.htp.stock.controller.command.CommandInterface;
import com.htp.stock.domain.to.ProductCatalog;
import com.htp.stock.service.ProductCatalogService;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.impl.ProductCatalogServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreationProductCatalog implements CommandInterface {

    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String ERROR_PAGE = "/error";

    private static final ProductCatalogService SERVICE = ProductCatalogServiceImpl.getInstance();

    private static final String PRODUCT_CATALOG_ATTRIBUTE = "product_catalog_attribute";

    private static final String PRODUCT_NAME = "product_name";
    private static final String PRODUCT_UNIT = "product_unit";

    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;
    private static final int ERROR_FLAG_VALUE_2 = 2;

    private CreationProductCatalog() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new CreationProductCatalog();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, CommandException {
        String page = "work";
        try {
            String productName = request.getParameter(PRODUCT_NAME);
            String productUnit = request.getParameter(PRODUCT_UNIT);

            ProductCatalog productCatalog = new ProductCatalog();

            productCatalog.setProductName(productName);
            productCatalog.setProductUnit(productUnit);

// TODO
            Long resultProduct = SERVICE.create(productCatalog);
            if (resultProduct == null) {
                request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE_2);
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
//                page = MANAGER.getProperty(PagePath.REGISTRATION.toString());

            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute(PRODUCT_CATALOG_ATTRIBUTE, resultProduct);    //TODO
//                page = MANAGER.getProperty(PagePath.RESULT.toString());
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
            }

        } catch (ServiceException e) {
            LOGGER.error("CommandException", e);
            response.sendRedirect(request.getContextPath() + ERROR_PAGE);
            throw new CommandException();
        }
        return page;
    }
}
