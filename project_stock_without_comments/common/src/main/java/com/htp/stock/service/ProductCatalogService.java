package com.htp.stock.service;

//import com.google.protobuf.ServiceException;
import com.htp.stock.domain.to.ProductCatalog;

public interface ProductCatalogService extends GenericServiceInterface<ProductCatalog, Long> {

    ProductCatalog findByProductName(String productName) throws ServiceException;
}
