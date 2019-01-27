package com.htp.stock.service.impl;

import com.htp.stock.dao.UserDAO;
import com.htp.stock.dao.factory.DaoFactory;
import com.htp.stock.domain.to.User;
import com.htp.stock.exceptions.DaoException;
import com.htp.stock.exceptions.NoSuchEntityException;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.UserService;
import com.htp.stock.service.validator.LoginValidator;
import com.htp.stock.service.validator.ValidationException;
import com.htp.stock.service.validator.ValidatorInterface;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private static final ValidatorInterface<User> VALIDATE = LoginValidator.getInstance();

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final UserServiceImpl instance = new UserServiceImpl();
    }

    @Override
    public List<User> loadAll() throws ServiceException, NoSuchEntityException {
        try {
            UserDAO userDao = factory.getUserDao();
            List<User> userList = userDao.findAll();
            if (userList != null) {
                return userList;
            } else {
                throw new NoSuchEntityException(" NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public User loadById(Long userId) throws ServiceException, NoSuchEntityException {
        try {
            UserDAO userDao = factory.getUserDao();
            User user = userDao.findById(userId);
            if (user != null) {
                return user;
            } else {
                throw new NoSuchEntityException(" NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }


    public Long create(User user) throws ServiceException {
        try {
            UserDAO userDao = factory.getUserDao();
            if (VALIDATE.isValid(user)) {
                Integer userLastID = userDao.create(user);
                return userLastID.longValue();
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException | ValidationException e) {
            throw new ServiceException("ServiceException");
        }
    }

    public Long update(User user) throws ServiceException {
        try {
            UserDAO userDao = factory.getUserDao();
            if (VALIDATE.isValid(user)) {
                return userDao.update(user);
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException | ValidationException e) {
            throw new ServiceException("ServiceException");
        }

    }


    public boolean delete(Long id) throws ServiceException, NoSuchEntityException {
        try {
            UserDAO userDao = factory.getUserDao();
            boolean userBool = userDao.delete(id);
            if (userBool) {
                return true;
            } else {
                throw new NoSuchEntityException(" NoSuchEntityException");
            }

        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }


    /**
     * Method check login and password information from some user and get user object if authorization success
     *
     * @param user object, that provides authorization operation
     * @return null if client not exists in system; user object if authorization execute correctly
     * @throws ServiceException
     */
    @Override
    public User authorization(User user) throws ServiceException {
        try {
            UserDAO userDao = factory.getUserDao();

            if (VALIDATE.isValid(user)) {

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
        } catch (DaoException | ValidationException e) {
            throw new ServiceException("Service Exception", e);
        }
    }
}
