package com.htp.stock.service.impl;

import com.htp.stock.dao.ProductCatalogDAO;
import com.htp.stock.dao.factory.DaoFactory;
import com.htp.stock.domain.to.ProductCatalog;
import com.htp.stock.exceptions.DaoException;
import com.htp.stock.exceptions.NoSuchEntityException;
import com.htp.stock.service.ProductCatalogService;
import com.htp.stock.service.ServiceException;
import com.htp.stock.service.validator.ProductCatalogValidator;
import com.htp.stock.service.validator.ValidationException;
import com.htp.stock.service.validator.ValidatorInterface;

import java.util.List;

public class ProductCatalogServiceImpl implements ProductCatalogService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private static final ValidatorInterface<ProductCatalog> VALIDATE = ProductCatalogValidator.getInstance();

    private ProductCatalogServiceImpl() {
    }

    public static ProductCatalogServiceImpl getInstance() {
        return ProductCatalogServiceImpl.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final ProductCatalogServiceImpl instance = new ProductCatalogServiceImpl();
    }

    @Override
    public Long create(ProductCatalog productCatalog) throws ServiceException {
        try {
            ProductCatalogDAO productCatalogDao = factory.getProductCatalogDao();
            if (VALIDATE.isValid(productCatalog)) {
                Integer companyLastID = productCatalogDao.create(productCatalog);
                return companyLastID.longValue();
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException | ValidationException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public List<ProductCatalog> loadAll() throws ServiceException {
        try {
            ProductCatalogDAO productCatalogDao = factory.getProductCatalogDao();
            List<ProductCatalog> productCatalogList = productCatalogDao.findAll();
            if (productCatalogList != null) {
                return productCatalogList;
            } else {
                throw new NoSuchEntityException(" NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public ProductCatalog findByProductName(String productName) throws ServiceException {
        try {
            ProductCatalogDAO productCatalogDao = factory.getProductCatalogDao();
            ProductCatalog productCatalog = productCatalogDao.findByProductName(productName);
            if (productCatalog != null) {
                return productCatalog;
            } else {
                throw new NoSuchEntityException(" NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }

    @Override
    public ProductCatalog loadById(Long id) throws ServiceException {
        try {
            ProductCatalogDAO productCatalogDao = factory.getProductCatalogDao();
            ProductCatalog productCatalog = productCatalogDao.findById(id.intValue());
            if (productCatalog != null) {
                return productCatalog;
            } else {
                throw new NoSuchEntityException(" NoSuchEntityException");
            }
        } catch (DaoException e) {
            throw new ServiceException("ServiceException");
        }
    }
}
