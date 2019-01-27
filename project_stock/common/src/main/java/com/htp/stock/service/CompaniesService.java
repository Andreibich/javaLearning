package com.htp.stock.service;

//import com.google.protobuf.ServiceException;
import com.htp.stock.domain.to.Companies;

public interface CompaniesService extends GenericServiceInterface<Companies, Long> {

    Companies loadByCompanyName(String companyName) throws ServiceException;
}
