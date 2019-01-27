package com.htp.stock.service.impl;

import com.htp.stock.dao.ReceiptDAO;
import com.htp.stock.dao.factory.DaoFactory;
import com.htp.stock.domain.to.Receipt;
import com.htp.stock.exceptions.DaoException;
import com.htp.stock.exceptions.NoSuchEntityException;
import com.htp.stock.service.ReceiptService;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.validator.ReceiptValidator;
import com.htp.stock.service.validator.ValidationException;
import com.htp.stock.service.validator.ValidatorInterface;

import java.sql.Date;
import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private static final ValidatorInterface<Receipt> VALIDATE = ReceiptValidator.getInstance();

    private ReceiptServiceImpl() {
    }

    public static ReceiptServiceImpl getInstance() {
        return ReceiptServiceImpl.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final ReceiptServiceImpl instance = new ReceiptServiceImpl();
    }

    @Override
    public Long create(Receipt receipt) throws ServiceException {
        try {
            ReceiptDAO receiptDao = factory.getReceiptDao();
            if (VALIDATE.isValid(receipt)) {
                Integer receiptLastID = receiptDao.create(receipt);
                return receiptLastID.longValue();
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException | ValidationException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Receipt> loadAll() throws ServiceException {
        try {
            ReceiptDAO receiptDao = factory.getReceiptDao();
            List<Receipt> receiptList = receiptDao.findAll();
            if (receiptList != null) {
                return receiptList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Receipt> loadByPeriod(Date dateBeginning, Date dateEnd) throws ServiceException {
        try {
            ReceiptDAO receiptDao = factory.getReceiptDao();
            List<Receipt> receiptList = receiptDao.findByPeriod(dateBeginning, dateEnd);
            if (receiptList != null) {
                return receiptList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Receipt> loadByProductNameAndPeriod(String productName, Date dateBeginning, Date dateEnd) throws ServiceException {
        try {
            ReceiptDAO receiptDao = factory.getReceiptDao();
            List<Receipt> receiptList = receiptDao.findByProductNameAndPeriod(productName, dateBeginning, dateEnd);
            if (receiptList != null) {
                return receiptList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Receipt> loadByCompanyNameAndPeriod(String companyName, Date dateBeginning, Date dateEnd) throws ServiceException {
        try {
            ReceiptDAO receiptDao = factory.getReceiptDao();
            List<Receipt> receiptList = receiptDao.findByCompanyNameAndPeriod(companyName, dateBeginning, dateEnd);
            if (receiptList != null) {
                return receiptList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public Receipt loadById(Long id) throws ServiceException {
        try {
            ReceiptDAO receiptDao = factory.getReceiptDao();
            Receipt receipt = receiptDao.findById(id.intValue());
            if (receipt != null) {
                return receipt;
            } else {
                throw new NoSuchEntityException(" NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }
}
