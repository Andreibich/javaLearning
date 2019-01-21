package com.htp.stock.service.impl;

import com.google.protobuf.ServiceException;
import com.htp.stock.dao.UserDAO;
import com.htp.stock.dao.factory.DaoFactory;
import com.htp.stock.domain.to.User;
import com.htp.stock.exceptions.DaoException;
import com.htp.stock.exceptions.NoSuchEntityException;
import com.htp.stock.service.UserService;
import com.htp.stock.service.validator.LoginValidator;
import com.htp.stock.service.validator.ValidationException;
import com.htp.stock.service.validator.ValidatorInterface;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private static final ValidatorInterface<User> VALIDATE = LoginValidator.getInstance();

    private UserServiceImpl(){}

    public static UserService getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public List<User> loadAll() throws ServiceException {
        return null;
    }

    @Override
    public User loadById(Long userId) throws ServiceException, NoSuchEntityException {
        return null;
    }



    private static class SingletonHolder {
        private static final UserServiceImpl instance = new UserServiceImpl();
    }


    public Long create(User obj) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    /**
     * Method check login and password information from some user and get user object if authorization success
     * @param user object, that provides authorization operation
     * @return null if client not exists in system; user object if authorization execute correctly
     * @throws ServiceException
     */
    @Override
    public User authorization(User user) throws ServiceException {
        try {
            UserDAO userDao = factory.getUserDao();

            if(VALIDATE.isValid(user)) {

                String password = user.getPassword();
                String passwordMD5 = DigestUtils.md5Hex(password);
                user.setPassword(passwordMD5);

                boolean check = userDao.checkUser(user.getLogin(), user.getPassword());
                if (!check) {
                    return null;
                } else {
                    return userDao.getUserNode(user.getLogin(), user.getPassword());
                }
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }
//    @Override
//    public List<User> viewAll() throws ServiceException {
//        throw new UnsupportedOperationException();
//    }

//    @Override
//    public User create(Long entity) throws ServiceException {
//        return null;
//    }
}
