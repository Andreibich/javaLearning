package com.htp.stock.dao;

import com.htp.stock.domain.to.User;
import com.htp.stock.exceptions.DaoException;

public interface UserDAO extends GenericDAO <User, Long> {

    User getUserNode(String login, String password) throws DaoException;

    boolean checkUser(String login, String password) throws DaoException;


}
