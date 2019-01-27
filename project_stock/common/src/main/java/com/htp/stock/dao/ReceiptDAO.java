package com.htp.stock.dao;

import com.htp.stock.domain.to.Receipt;
import com.htp.stock.exceptions.DaoException;

import java.sql.Date;
import java.util.List;

public interface ReceiptDAO extends GenericDAO<Receipt, Integer> {

    List<Receipt> findByPeriod(Date dateBeginning, Date dateEnd) throws DaoException;

    List<Receipt> findByProductNameAndPeriod(String productName, Date dateBeginning, Date dateEnd) throws DaoException;

    List<Receipt> findByCompanyNameAndPeriod(String companyName, Date dateBeginning, Date dateEnd) throws DaoException;

}
