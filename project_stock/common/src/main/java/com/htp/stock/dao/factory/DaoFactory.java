package com.htp.stock.dao.factory;

import com.htp.stock.dao.CompaniesDAO;
import com.htp.stock.dao.OperationCodesDAO;
import com.htp.stock.dao.ProductCatalogDAO;
import com.htp.stock.dao.ReceiptDAO;
import com.htp.stock.dao.ShipmentDAO;
import com.htp.stock.dao.UserDAO;

public abstract class DaoFactory {
    public static DaoFactory getDaoFactory() {
        return SQLDaoFactory.getInstance();
    }

    public abstract UserDAO getUserDao();

    public abstract CompaniesDAO getCompaniesDao();

    public abstract ProductCatalogDAO getProductCatalogDao();

    public abstract ReceiptDAO getReceiptDao();

    public abstract ShipmentDAO getShipmentDao();

    public abstract OperationCodesDAO getOperationCodesDao();
}
