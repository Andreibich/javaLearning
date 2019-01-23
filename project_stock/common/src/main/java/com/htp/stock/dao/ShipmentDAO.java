package com.htp.stock.dao;

import com.htp.stock.domain.to.Shipment;
import com.htp.stock.exceptions.DaoException;

import java.sql.Date;

public interface ShipmentDAO extends GenericDAO<Shipment, Integer>{

    Shipment findByPeriod(Date dateBeginning, Date dateEnd) throws DaoException;

    Shipment findByProductNameAndPeriod(String productName, Date dateBeginning, Date dateEnd) throws DaoException;

    Shipment findByCompanyNameAndPeriod(String companyName, Date dateBeginning, Date dateEnd) throws DaoException;

    Shipment findResult() throws DaoException;

    Shipment findResultDate(Date date) throws DaoException;



}
