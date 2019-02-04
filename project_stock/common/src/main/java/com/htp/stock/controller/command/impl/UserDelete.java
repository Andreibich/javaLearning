package com.htp.stock.controller.command.impl;

import com.htp.stock.controller.command.CommandException;
import com.htp.stock.controller.command.CommandInterface;
import com.htp.stock.dao.factory.DaoFactory;
import com.htp.stock.exceptions.DaoException;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.UserService;
import com.htp.stock.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDelete implements CommandInterface {
    private static final UserService SERVICE = UserServiceImpl.getInstance();

    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private UserDelete() {
    }

    public static CommandInterface getInstance() {
        return UserDelete.SingletonHolder.INSTANCE;
    }

    /**
     * Method performs the procedure for adding hotel room information on page and further viewing and updating
     * Also determines what action must be made for transition(forward or sendRedirect)
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException when getting all nodes fail
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        try {
            Long deleteUserId = Long.valueOf(request.getParameter("userId"));
            boolean delete = SERVICE.delete(deleteUserId);

        } catch (ServiceException e) {
            throw new CommandException();
        }
//        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
        request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
        return "/userList";
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new UserDelete();
    }
}

