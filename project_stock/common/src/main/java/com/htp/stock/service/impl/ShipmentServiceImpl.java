package com.htp.stock.service.impl;

import com.htp.stock.dao.ShipmentDAO;
import com.htp.stock.dao.factory.DaoFactory;
import com.htp.stock.domain.to.Shipment;
import com.htp.stock.exceptions.DaoException;
import com.htp.stock.exceptions.NoSuchEntityException;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.ShipmentService;
import com.htp.stock.service.validator.ShipmentValidator;
import com.htp.stock.service.validator.ValidationException;
import com.htp.stock.service.validator.ValidatorInterface;

import java.sql.Date;
import java.util.List;

public class ShipmentServiceImpl implements ShipmentService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private static final ValidatorInterface<Shipment> VALIDATE = ShipmentValidator.getInstance();

    private ShipmentServiceImpl() {
    }

    public static ShipmentServiceImpl getInstance() {
        return ShipmentServiceImpl.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final ShipmentServiceImpl instance = new ShipmentServiceImpl();
    }

    @Override
    public Long create(Shipment shipment) throws ServiceException {
        try {
            ShipmentDAO shipmentDao = factory.getShipmentDao();
            if (VALIDATE.isValid(shipment)) {
                Integer shipmentLastID = shipmentDao.create(shipment);
                return shipmentLastID.longValue();
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException | ValidationException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Shipment> loadAll() throws ServiceException {
        try {
            ShipmentDAO shipmentDao = factory.getShipmentDao();
            List<Shipment> shipmentList = shipmentDao.findAll();
            if (shipmentList != null) {
                return shipmentList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Shipment> findByPeriod(Date dateBeginning, Date dateEnd) throws ServiceException {
        try {
            ShipmentDAO shipmentDao = factory.getShipmentDao();
            List<Shipment> shipmentList = shipmentDao.findByPeriod(dateBeginning, dateEnd);
            if (shipmentList != null) {
                return shipmentList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Shipment> findByProductNameAndPeriod(String productName, Date dateBeginning, Date dateEnd) throws ServiceException {
        try {
            ShipmentDAO shipmentDao = factory.getShipmentDao();
            List<Shipment> shipmentList = shipmentDao.findByProductNameAndPeriod(productName, dateBeginning, dateEnd);
            if (shipmentList != null) {
                return shipmentList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Shipment> findByCompanyNameAndPeriod(String companyName, Date dateBeginning, Date dateEnd) throws ServiceException {
        try {
            ShipmentDAO shipmentDao = factory.getShipmentDao();
            List<Shipment> shipmentList = shipmentDao.findByCompanyNameAndPeriod(companyName, dateBeginning, dateEnd);
            if (shipmentList != null) {
                return shipmentList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Shipment> findResult() throws ServiceException {
        try {
            ShipmentDAO shipmentDao = factory.getShipmentDao();
            List<Shipment> shipmentList = shipmentDao.findResult();
            if (shipmentList != null) {
                return shipmentList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<Shipment> findResultDate(Date date) throws ServiceException {
        try {
            ShipmentDAO shipmentDao = factory.getShipmentDao();
            List<Shipment> shipmentList = shipmentDao.findResultDate(date);
            if (shipmentList != null) {
                return shipmentList;
            } else {
                throw new NoSuchEntityException("NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public Shipment loadById(Long id) throws ServiceException {
        try {
            ShipmentDAO shipmentDao = factory.getShipmentDao();
            Shipment shipment = shipmentDao.findById(id.intValue());
            if (shipment != null) {
                return shipment;
            } else {
                throw new NoSuchEntityException(" NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }
}
