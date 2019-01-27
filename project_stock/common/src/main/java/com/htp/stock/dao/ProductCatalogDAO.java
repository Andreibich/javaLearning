package com.htp.stock.dao;

import com.htp.stock.domain.to.ProductCatalog;
import com.htp.stock.exceptions.DaoException;

public interface ProductCatalogDAO extends GenericDAO<ProductCatalog, Integer> {

    ProductCatalog findByProductName(String productName) throws DaoException;

}
