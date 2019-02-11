package com.htp.stock.controller.command.impl;

import com.htp.stock.controller.command.CommandException;
import com.htp.stock.controller.command.CommandInterface;
import com.htp.stock.domain.to.Companies;
import com.htp.stock.service.CompaniesService;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.impl.CompaniesServiceImpl;
import com.htp.stock.service.validator.ValidationException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreationCompany implements CommandInterface {

    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String ERROR_PAGE = "/error";

    private static final CompaniesService SERVICE = CompaniesServiceImpl.getInstance();

    private static final String COMPANY_ATTRIBUTE = "company_attribute";

    private static final String COMPANY_NAME = "company_name";
    private static final String CITY = "city";
    private static final String ADDRESS = "address";

    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;
    private static final int ERROR_FLAG_VALUE_2 = 2;

    private CreationCompany() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new CreationCompany();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, CommandException {
        String page = "work";
        try {
            String companyName = request.getParameter(COMPANY_NAME);
            String city = request.getParameter(CITY);
            String address = request.getParameter(ADDRESS);

            Companies companies = new Companies();

            companies.setCompanyName(companyName);
            companies.setCity(city);
            companies.setAddress(address);

// TODO
            Long resultCompany = SERVICE.create(companies);
            if (resultCompany == null) {
                request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE_2);
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);

            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute(COMPANY_ATTRIBUTE, resultCompany);    //TODO
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
