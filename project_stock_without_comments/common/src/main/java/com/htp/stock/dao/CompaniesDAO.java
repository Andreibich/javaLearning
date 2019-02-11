package com.htp.stock.dao;

import com.htp.stock.domain.to.Companies;
import com.htp.stock.exceptions.DaoException;

public interface CompaniesDAO extends GenericDAO<Companies, Integer> {

    Companies findByCompanyName(String companyName) throws DaoException;

}
