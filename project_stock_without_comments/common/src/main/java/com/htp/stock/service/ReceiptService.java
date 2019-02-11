package com.htp.stock.service;

//import com.google.protobuf.ServiceException;
import com.htp.stock.domain.to.Receipt;

import java.sql.Date;
import java.util.List;

public interface ReceiptService extends GenericServiceInterface<Receipt, Long>{

    List<Receipt> loadByPeriod(Date dateBeginning, Date dateEnd) throws ServiceException;

    List<Receipt> loadByProductNameAndPeriod(String productName, Date dateBeginning, Date dateEnd) throws ServiceException;

    List<Receipt> loadByCompanyNameAndPeriod(String companyName, Date dateBeginning, Date dateEnd) throws ServiceException;
}
