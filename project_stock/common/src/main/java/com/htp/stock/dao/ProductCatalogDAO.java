package com.htp.stock.dao;

import com.htp.stock.domain.to.ProductCatalog;
import com.htp.stock.exceptions.DaoException;

public interface ProductCatalogDAO extends GenericDAO<ProductCatalog, Integer> {

    ProductCatalog findByProductName(String productName) throws DaoException;
//
//    ProductCatalog findByProductNameAndUnit(String name, String unit) throws DaoException;
//
//    @Override
//    int create(String name, String unit) throws DaoException;
//
//    ProductCatalog findByProductNameAndUnit(String name, String unit) throws DaoException;
}
