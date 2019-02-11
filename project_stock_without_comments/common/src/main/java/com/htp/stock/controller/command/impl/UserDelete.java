package com.htp.stock.controller.command.impl;

import com.htp.stock.controller.command.CommandException;
import com.htp.stock.controller.command.CommandInterface;
import com.htp.stock.dao.factory.DaoFactory;
import com.htp.stock.exceptions.DaoException;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.UserService;
import com.htp.stock.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserDelete implements CommandInterface {

    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String ERROR_PAGE = "/error";

    private static final String ADMIN_ROLE = "admin";
    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;
    private static final int ERROR_FLAG_VALUE_2 = 2;

    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";

    private static final UserService SERVICE = UserServiceImpl.getInstance();

    private UserDelete() {
    }

    public static CommandInterface getInstance() {
        return UserDelete.SingletonHolder.INSTANCE;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException {

        String page = null;

        try {
            Long deleteUserId = Long.valueOf(request.getParameter("userId"));
            boolean userDelete = SERVICE.delete(deleteUserId);

            if (!userDelete) {
                request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE_2);
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);


            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute(ADMIN_ROLE, deleteUserId);
                page = "/FrontController?command=test_command";
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
            }

        } catch (/*ValidationException*/ ServiceException e) {
            LOGGER.error("CommandException", e);
            response.sendRedirect(request.getContextPath() + ERROR_PAGE);
            throw new CommandException();
        }

        return page;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new UserDelete();
    }
}

