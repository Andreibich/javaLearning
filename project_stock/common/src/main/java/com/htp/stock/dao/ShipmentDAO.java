package com.htp.stock.dao;

import com.htp.stock.domain.to.Shipment;
import com.htp.stock.exceptions.DaoException;

import java.sql.Date;
import java.util.List;

public interface ShipmentDAO extends GenericDAO<Shipment, Integer>{

    List<Shipment> findByPeriod(Date dateBeginning, Date dateEnd) throws DaoException;

    List<Shipment> findByProductNameAndPeriod(String productName, Date dateBeginning, Date dateEnd) throws DaoException;

    List<Shipment> findByCompanyNameAndPeriod(String companyName, Date dateBeginning, Date dateEnd) throws DaoException;

    List<Shipment> findResult() throws DaoException;

    List<Shipment> findResultDate(Date date) throws DaoException;



}
