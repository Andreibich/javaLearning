package com.htp.stock.dao;

import com.htp.stock.domain.to.Receipt;
import com.htp.stock.exceptions.DaoException;

import java.sql.Date;

public interface ReceiptDAO extends GenericDAO<Receipt, Integer> {

    Receipt findByPeriod(Date dateBeginning, Date dateEnd) throws DaoException;

    Receipt findByProductNameAndPeriod(String productName, Date dateBeginning, Date dateEnd) throws DaoException;

    Receipt findByCompanyNameAndPeriod(String companyName, Date dateBeginning, Date dateEnd) throws DaoException;

}
