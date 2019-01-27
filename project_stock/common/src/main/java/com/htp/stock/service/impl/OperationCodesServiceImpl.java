package com.htp.stock.service.impl;


import com.htp.stock.dao.OperationCodesDAO;
import com.htp.stock.dao.factory.DaoFactory;
import com.htp.stock.domain.to.OperationCodes;
import com.htp.stock.exceptions.DaoException;
import com.htp.stock.exceptions.NoSuchEntityException;
import com.htp.stock.service.OperationCodesInterface;
import com.htp.stock.service.ServiceException;

import java.util.List;

public class OperationCodesServiceImpl implements OperationCodesInterface {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private  OperationCodesServiceImpl() {
    }

    public static  OperationCodesServiceImpl getInstance() {
        return  OperationCodesServiceImpl.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final  OperationCodesServiceImpl instance = new  OperationCodesServiceImpl();
    }
    @Override
    public Long create(OperationCodes operationCodes) throws ServiceException {
        throw new ServiceException("ServiceException");
    }

    @Override
    public List loadAll() throws ServiceException {
        try {
            OperationCodesDAO operationCodesDao = factory.getOperationCodesDao();
            List<OperationCodes> operationCodesList = operationCodesDao.findAll();
            if (operationCodesList != null) {
                return operationCodesList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public OperationCodes findByPurpose(String purpose) throws ServiceException {
        try {
            OperationCodesDAO operationCodesDao = factory.getOperationCodesDao();
            OperationCodes operationCodes = operationCodesDao.findByPurpose(purpose);
            if (operationCodes != null) {
                return operationCodes;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public OperationCodes loadById(Long id) throws ServiceException {
        try {
            OperationCodesDAO operationCodesDao = factory.getOperationCodesDao();
            OperationCodes operationCodes = operationCodesDao.findById(id.intValue());
            if (operationCodes != null) {
                return operationCodes;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }
}
