package com.htp.stock.controller.command.impl;

import com.htp.stock.controller.command.CommandException;
import com.htp.stock.controller.command.CommandInterface;
import com.htp.stock.domain.to.User;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.UserService;
import com.htp.stock.service.impl.UserServiceImpl;
import com.htp.stock.service.validator.ValidationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Class is designed for the log in in system as administrator or client
 */
public class LoginCommand implements CommandInterface {

    private static final UserService SERVICE = UserServiceImpl.getInstance();
//    private static final PagesConfigManager MANAGER = PagesConfigManager.getInstance();
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ADMIN_ROLE = "admin";
    private static final String CLIENT_ROLE = "client";
    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;
    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private LoginCommand() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new LoginCommand();
    }

    /**
     * Method performs the procedure for authorization in system
     * In first, getting login and password parameters from request
     * Then finding node with equals parameters. If procedure return not null, then necessary define client or admin
     * log in. According to role of user creating admin or client object and put into session.
     * <p>
     * Also determines what action must be made for transition(forward or sendRedirect)
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException if authorization method process fail
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        PagePath page;
        try {
            User tempUser = new User();
            tempUser.setLogin(request.getParameter(LOGIN));
            String password = request.getParameter(PASSWORD);
            tempUser.setPassword(password);

            HttpSession session = request.getSession(true);
            User user = SERVICE.authorization(tempUser);

            if (user == null) {
                request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE);// одна из возможных реализаций error message в
                request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
                page = PagePath.INDEX;
            } else {
                if (user.getType().equals(ADMIN_ROLE)) {
                    User admin = new User();
                    admin.setPassword(user.getPassword());
                    admin.setLogin(user.getLogin());
                    admin.setType(user.getType());
                    session.setAttribute(ADMIN_ROLE, admin);
                    page = PagePath.ADMIN;
                } else {
                    User client = new User();
                    client.setType(user.getType());
                    client.setLogin(user.getLogin());
                    client.setPassword(user.getPassword());
                    client.setUserId(user.getUserId());

                    session.setAttribute(CLIENT_ROLE, client);
                    page = PagePath.RESULT;
                }
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
            }
//        } catch (ValidationException e) {
            request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE);
            request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
            page = PagePath.INDEX;
        } catch (ServiceException e) {
            throw new CommandException("Command Exception", e);
        }
//        return MANAGER.getProperty(page.toString());
        return "ok";
    }

    public enum PagePath {
        ADMIN, RESULT, INDEX
    }
}

