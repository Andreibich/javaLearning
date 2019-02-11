package com.htp.stock.service;


import com.htp.stock.domain.to.User;
import com.htp.stock.exceptions.NoSuchEntityException;


public interface UserService extends GenericServiceInterface<User, Long> {

    User loadById(Long userId) throws ServiceException, NoSuchEntityException;

    User authorization(User user) throws ServiceException;

    boolean delete (Long id) throws ServiceException;

    Long update (User user) throws ServiceException;

}
