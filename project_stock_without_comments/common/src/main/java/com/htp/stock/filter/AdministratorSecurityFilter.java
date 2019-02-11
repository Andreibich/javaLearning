package com.htp.stock.filter;

import com.htp.stock.domain.to.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdministratorSecurityFilter implements Filter {
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String INDEX_PAGE = "/index";
    private static final String RESULT_PAGE = "/result";

    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;

        HttpSession session = request.getSession();
//        Administrator, User
        User administrator = (User) session.getAttribute(ADMIN);
        User user = (User) session.getAttribute(USER);

        if (user == null) {
            if (administrator == null) {
                LOGGER.info("Unauthorized attempt to enter the admin page");
                request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
            }
        } else {
            LOGGER.info("Client" + user.getLogin() +  " attempt to enter the admin page");
            request.getRequestDispatcher(RESULT_PAGE).forward(request, response);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {}
}
