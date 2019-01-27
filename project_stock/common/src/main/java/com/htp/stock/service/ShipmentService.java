package com.htp.stock.service;

//import com.google.protobuf.ServiceException;
import com.htp.stock.domain.to.Shipment;

import java.sql.Date;
import java.util.List;

public interface ShipmentService extends GenericServiceInterface<Shipment, Long> {

    List<Shipment> findByPeriod(Date dateBeginning, Date dateEnd) throws ServiceException;

    List<Shipment> findByProductNameAndPeriod(String productName, Date dateBeginning, Date dateEnd) throws ServiceException;

    List<Shipment> findByCompanyNameAndPeriod(String companyName, Date dateBeginning, Date dateEnd) throws ServiceException;

    List<Shipment> findResult() throws ServiceException;

    List<Shipment> findResultDate(Date date) throws ServiceException;
}
