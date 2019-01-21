package com.htp.stock.dao.factory;

import com.htp.stock.dao.CompaniesDAO;
import com.htp.stock.dao.OperationCodesDAO;
import com.htp.stock.dao.ProductCatalogDAO;
import com.htp.stock.dao.ReceiptDAO;
import com.htp.stock.dao.ShipmentDAO;
import com.htp.stock.dao.UserDAO;
import com.htp.stock.dao.impl.SQLCompaniesDAO;
import com.htp.stock.dao.impl.SQLOperationCodesDAO;
import com.htp.stock.dao.impl.SQLProductCatalogDAO;
import com.htp.stock.dao.impl.SQLReceiptDAO;
import com.htp.stock.dao.impl.SQLShipmentDAO;
import com.htp.stock.dao.impl.SQLUserDao;

public class SQLDaoFactory extends DaoFactory {

    private static final SQLDaoFactory instance = new SQLDaoFactory();

    private SQLDaoFactory() {
    }

    public static SQLDaoFactory getInstance() {
        return instance;
    }

    @Override
    public UserDAO getUserDao() {
        return SQLUserDao.getInstance();
    }

    @Override
    public CompaniesDAO getCompaniesDao() {
        return SQLCompaniesDAO.getInstance();
    }

    @Override
    public ProductCatalogDAO getProductCatalogDao() {
        return SQLProductCatalogDAO.getInstance();
    }

    @Override
    public ReceiptDAO getReceiptDao() {
        return SQLReceiptDAO.getInstance();
    }

    @Override
    public ShipmentDAO getShipmentDao() {
        return SQLShipmentDAO.getInstance();
    }

    @Override
    public OperationCodesDAO getOperationCodesDao() {
        return SQLOperationCodesDAO.getInstance();
    }
}
