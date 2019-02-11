package com.htp.stock;

import com.htp.stock.dao.UserDAO;
import com.htp.stock.dao.CompaniesDAO;
import com.htp.stock.dao.connection_pool.ConnectionPool;
import com.htp.stock.dao.connection_pool.ConnectionPoolException;
import com.htp.stock.dao.factory.DaoFactory;
import com.htp.stock.domain.to.User;
import com.htp.stock.exceptions.DaoException;

public class Test {
    public static void main(String[] args) {
        try {
            ConnectionPool.getInstance().init();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
        DaoFactory factory = DaoFactory.getDaoFactory();
        UserDAO userDao = factory.getUserDao();
        CompaniesDAO companiesDao = factory.getCompaniesDao();
        try {
            System.out.println(userDao.findById(2L));
//            userDao.getUserNode("12q", "12qw");
//            System.out.println(userDao.findAll());
//            System.out.println(companiesDao.findById(3));
            User user = new User("Logunovaxx", "qwrt");
//            System.out.println(userDao.create(user));
////            if (VALIDATE.isValid(user)) {
                Long userLastID = userDao.create(user);
            System.out.println(userLastID);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
