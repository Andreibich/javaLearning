package com.htp.stock.service.impl;


import com.htp.stock.dao.CompaniesDAO;
import com.htp.stock.dao.factory.DaoFactory;
import com.htp.stock.domain.to.Companies;
import com.htp.stock.exceptions.DaoException;
import com.htp.stock.exceptions.NoSuchEntityException;
import com.htp.stock.service.CompaniesService;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.validator.CompaniesValidator;
import com.htp.stock.service.validator.ValidationException;
import com.htp.stock.service.validator.ValidatorInterface;

import java.util.List;

public class CompaniesServiceImpl implements CompaniesService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private static final ValidatorInterface<Companies> VALIDATE = CompaniesValidator.getInstance();

    private CompaniesServiceImpl() {
    }

    public static CompaniesServiceImpl getInstance() {
        return CompaniesServiceImpl.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final CompaniesServiceImpl instance = new CompaniesServiceImpl();
    }

    @Override
    public Long create(Companies companies) throws ServiceException {
        try {
            CompaniesDAO companiesDao = factory.getCompaniesDao();
            if (VALIDATE.isValid(companies)) {
                Integer companyLastID = companiesDao.create(companies);
                return companyLastID.longValue();
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException | ValidationException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Companies> loadAll() throws ServiceException {
        try {
            CompaniesDAO companiesDao = factory.getCompaniesDao();
            List<Companies> companiesList = companiesDao.findAll();
            if (companiesList != null) {
                return companiesList;
            } else {
                throw new NoSuchEntityException(" NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public Companies loadById(Long id) throws ServiceException {
        try {
            CompaniesDAO companiesDao = factory.getCompaniesDao();
            Companies companies = companiesDao.findById(id.intValue());
            if (companies != null) {
                return companies;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public Companies loadByCompanyName(String companyName) throws ServiceException {
        try {
            CompaniesDAO companiesDao = factory.getCompaniesDao();
            Companies companies = companiesDao.findByCompanyName(companyName);
            if (companies != null) {
                return companies;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }
}
