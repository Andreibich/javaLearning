package com.htp.stock.controller.command.impl;


import com.htp.stock.controller.command.CommandException;
import com.htp.stock.controller.command.CommandInterface;
import com.htp.stock.domain.to.User;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.UserService;
import com.htp.stock.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class RegistrationCommand implements CommandInterface {

    /**
     * Method performs the procedure for adding a new customer to the system.
     * Getting all information about new client and then create new node in system.
     * Also determines what action must be made for transition(forward or sendRedirect).
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException when creating fail
     */
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String ERROR_PAGE = "/error";

    private static final UserService SERVICE = UserServiceImpl.getInstance();

    private static final String ADMIN_ROLE = "admin";
    private static final String USER_ROLE = "user";

    private static final String NAME_ATTRIBUTE = "name";
    private static final String SURNAME_ATTRIBUTE = "surname";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String EMAIL = "email";
    private static final String CREATION_DATE = "creation_date";
    private static final String TYPE = "type";

    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;
    private static final int ERROR_FLAG_VALUE_2 = 2;

    private RegistrationCommand() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new RegistrationCommand();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException {

        String page = "/userCreation";
        try {
            String name = request.getParameter(NAME_ATTRIBUTE);
            String surname = request.getParameter(SURNAME_ATTRIBUTE);
            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);
            String phoneNumber = request.getParameter(PHONE_NUMBER);
            String email = request.getParameter(EMAIL);
            String creationDate = request.getParameter(CREATION_DATE);
            String type = request.getParameter(TYPE);

            User user = new User();

            user.setUserName(name);
            user.setSurname(surname);
            user.setLogin(login);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            user.setEmail(email);
            user.setCreationDate(creationDate);
            user.setType(type);

// TODO
            Long resultUser = SERVICE.create(user);
            if (resultUser == null) {
                request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE_2);
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);


            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute(ADMIN_ROLE, resultUser);
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
                page = "/admin";
            }
//
//        } catch (ServiceException e) {
//            request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE);
//            request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
        } catch (Exception e) {
            LOGGER.error("CommandException", e);
            response.sendRedirect(request.getContextPath() + ERROR_PAGE);
            throw new CommandException();
        }
        return page;
    }
}

