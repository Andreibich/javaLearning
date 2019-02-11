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

public class UserEdit implements CommandInterface {

    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String ERROR_PAGE = "/error";

    private static final UserService SERVICE = UserServiceImpl.getInstance();

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

    private UserEdit() {
    }

    public static CommandInterface getInstance() {
        return UserEdit.SingletonHolder.INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException {

        try {

            String userId = request.getParameter(USER_ID);
            String name = request.getParameter(NAME_ATTRIBUTE);
            String surname = request.getParameter(SURNAME_ATTRIBUTE);
            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);
            String phoneNumber = request.getParameter(PHONE_NUMBER);
            String email = request.getParameter(EMAIL);
            String creationDate = request.getParameter(CREATION_DATE);
            String type = request.getParameter(TYPE);


            User user = new User();

            user.setUserId(Long.valueOf(userId));
            user.setUserName(name);
            user.setSurname(surname);
            user.setLogin(login);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            user.setEmail(email);
            user.setCreationDate(creationDate);
            user.setType(type);


            SERVICE.update(user);

        } catch (ServiceException e) {
            LOGGER.error("CommandException", e);
            response.sendRedirect(request.getContextPath() + ERROR_PAGE);
            throw new CommandException();
        }

        request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
        return "/FrontController?command=test_command";
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new UserEdit();
    }
}
