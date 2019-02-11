package com.htp.stock.dao;

import com.htp.stock.domain.to.OperationCodes;
import com.htp.stock.exceptions.DaoException;

public interface OperationCodesDAO extends GenericDAO<OperationCodes, Integer>{

    OperationCodes findByPurpose(String purpose) throws DaoException;

}
