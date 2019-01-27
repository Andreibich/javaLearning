package com.htp.stock.service;

//import com.google.protobuf.ServiceException;
import com.htp.stock.domain.to.OperationCodes;

public interface OperationCodesInterface extends GenericServiceInterface<OperationCodes, Long> {

    OperationCodes findByPurpose(String purpose) throws ServiceException;
}
