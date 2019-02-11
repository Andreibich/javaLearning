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
import java.io.IOException;

public class UserGetId implements CommandInterface {


    private static final UserService SERVICE = UserServiceImpl.getInstance();

    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String ERROR_PAGE = "/error";

    private static final String ADMIN_ROLE = "admin";
    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;
    private static final int ERROR_FLAG_VALUE_2 = 2;

    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";

    private static final String NAME_ATTRIBUTE = "name";
    private static final String SURNAME_ATTRIBUTE = "surname";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String EMAIL = "email";
    private static final String CREATION_DATE = "creation_date";
    private static final String TYPE = "type";
    private static final String USER_ID = "userId";

    private UserGetId() {
    }

    public static CommandInterface getInstance() {
        return UserGetId.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new UserGetId();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException {
        try {
            String userId = request.getParameter(USER_ID);

            User oldUser = SERVICE.loadById(Long.valueOf(userId));

            request.getSession().setAttribute(USER_ID, userId);
            request.setAttribute(NAME_ATTRIBUTE, oldUser.getUserName());
            request.setAttribute(SURNAME_ATTRIBUTE, oldUser.getSurname());
            request.setAttribute(LOGIN, oldUser.getLogin());
            request.setAttribute(PASSWORD, oldUser.getPassword());
            request.setAttribute(PHONE_NUMBER, oldUser.getPhoneNumber());
            request.setAttribute(EMAIL, oldUser.getEmail());
            request.setAttribute(CREATION_DATE, oldUser.getCreationDate());
            request.setAttribute(TYPE, oldUser.getType());

        } catch (ServiceException e) {
            LOGGER.error("CommandException", e);
            response.sendRedirect(request.getContextPath() + ERROR_PAGE);
            throw new CommandException();
        }
        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
        return "/userUpdate";

    }
}
