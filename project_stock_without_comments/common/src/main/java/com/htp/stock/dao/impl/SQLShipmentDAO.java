package com.htp.stock.dao.impl;

import com.htp.stock.dao.ShipmentDAO;
import com.htp.stock.dao.connection_pool.ConnectionPool;
import com.htp.stock.dao.connection_pool.ConnectionPoolException;
import com.htp.stock.domain.to.Receipt;
import com.htp.stock.domain.to.Shipment;
import com.htp.stock.exceptions.DaoException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLShipmentDAO implements ShipmentDAO {

    private static final String SHIPMENT_ID = "shipment_id";
    private static final String SHIPMENT_DATE = "shipment_date";
    private static final String RECEPIENT_COMPANY_ID = "recepient_company_id";
    private static final String PRODUCT_CATALOG_ID = "product_catalog_id";
    private static final String SHIPMENT_QUANTITY = "shipment_quantity";
    private static final String SHIPMENT_PRICE = "shipment_price";
    private static final String INVOICE_NUMBER = "invoice_number";
    private static final String PROXY_NUMBER = "proxy_number";
    private static final String SHIPMENT_USER_ID = "shipment_user_id";
    private static final String RECEPIENT_EMPLOYEE_NAME = "recepient_employee_name";
    private static final String OPERATION_CODE_ID = "operation_code_id";

    private static final String OPERATION_CODE_PURPOSE = "purpose";
    private static final String RECEPIENT_COMPANY_NAME = "company_name";
    private static final String PRODUCT_CATALOG_NAME = "product_name";
    private static final String PRODUCT_CATALOG_UNIT = "product_unit";
    private static final String SHIPMENT_USER_SURNAME = "surname";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String SELECT_BY_SHIPMENT_ID = "SELECT * FROM shipment WHERE shipment_id = ?";
    private static final String SELECT_BY_SHIPMENT_DATE = "SELECT * FROM shipment WHERE shipment_date = ?";
    private static final String SELECT_BY_RECEPIENT_COMPANY_ID = "SELECT * FROM shipment WHERE recepient_company_id = ?";
    private static final String SELECT_BY_PRODUCT_CATALOG_ID = "SELECT * FROM shipment WHERE product_catalog_id = ?";
    private static final String SELECT_BY_SHIPMENT_QUANTITY = "SELECT * FROM shipment WHERE shipment_quantity = ?";
    private static final String SELECT_BY_SHIPMENT_PRICE = "SELECT * FROM shipment WHERE shipment_price = ?";
    private static final String SELECT_BY_INVOICE_NUMBER = "SELECT * FROM shipment WHERE invoice_number = ?";
    private static final String SELECT_BY_PROXY_NUMBER = "SELECT * FROM shipment WHERE proxy_number = ?";
    private static final String SELECT_BY_SHIPMENT_USER_ID = "SELECT * FROM shipment WHERE shipment_user_id = ?";
    private static final String SELECT_BY_RECEPIENT_EMPLOYEE_NAME = "SELECT * FROM shipment WHERE recepient_employee_name = ?";
    private static final String SELECT_BY_OPERATION_CODE_ID = "SELECT * FROM shipment WHERE operation_code_id = ?";
    private static final String SELECT_ALL = "select shipment.shipment_id, operation_codes.purpose, product_catalog.product_name, " +
            "product_catalog.product_unit, shipment.shipment_quantity, shipment.shipment_price, " +
            "shipment.shipment_date, user.surname, companies.company_name, shipment.invoice_number, " +
            "shipment.proxy_number, shipment.recepient_employee_name from shipment inner join operation_codes " +
            "on operation_codes.operation_code_id = shipment.operation_code_id inner join product_catalog " +
            "on product_catalog.product_id = shipment.product_catalog_id inner join user on user.user_id = " +
            "shipment.shipment_user_id inner join companies on companies.company_id = shipment.recipient_company_id " +
            "order by shipment.shipment_date desc ";
    private static final String SELECT_BY_PERIOD = "SELECT * FROM shipment WHERE shipment_date >= ? AND shipment_date <= ?";
    private static final String SELECT_BY_PRODUCT_NAME_AND_PERIOD =
            "SELECT shipment.shipment_id, shipment.shipment_date, " +
                    "companies.company_name, product_catalog.product_name, shipment.shipment_quantity, shipment.shipment_price, " +
                    "shipment.invoice_number, shipment.proxy_number, user.name, shipment.recepient_employee_name, " +
                    "operation_codes.purpose FROM shipment " +
                    "INNER JOIN companies ON shipment.recepient_company_id = companies.company_id " +
                    "INNER JOIN product_catalog ON product_catalog.product_id = shipment.product_catalog_id " +
                    "INNER JOIN user ON user.user_id = shipment.shipment_user_id " +
                    "INNER JOIN operation_codes ON operation_codes.operation_code_id = shipment.operation_code_id " +
                    "WHERE product_catalog.product_name = ? AND " +
                    "shipment.shipment_date >= ? AND shipment.shipment_date <= ?";
    private static final String SELECT_BY_COMPANY_NAME_AND_PERIOD = "SELECT shipment.shipment_id, shipment.shipment_date, " +
            "companies.company_name, product_catalog.product_name, shipment.shipment_quantity, shipment.shipment_price, " +
            "shipment.invoice_number, shipment.proxy_number, user.name, shipment.recepient_employee_name, " +
            "operation_codes.purpose FROM shipment INNER JOIN companies ON shipment.recepient_company_id = companies.company_id " +
            "INNER JOIN product_catalog ON product_catalog.product_id = shipment.product_catalog_id " +
            "INNER JOIN user ON user.user_id = shipment.shipment_user_id INNER JOIN operation_codes ON " +
            "operation_codes.operation_code_id = shipment.operation_code_id WHERE companies.company_name = ? AND " +
            "shipment.shipment_date >= ? AND shipment.shipment_date <= ?";

    private static final String SELECT_RESULT_FOR_NOW = "select t1.a1 as product_name, t1.a2 as product_unit, sum(t1.a3) as shipment_quantity, t1.a4 as shipment_price " +
            "FROM " +
            "(SELECT product_catalog.product_name as a1, product_catalog.product_unit as a2,  sum(receipt.receipt_quantity) as a3, receipt.receipt_price as a4 " +
            "FROM receipt " +
            "Inner JOIN product_catalog ON  product_catalog.product_id = receipt.product_catalog_id " +
            "GROUP BY product_catalog.product_id, receipt.receipt_price  " +
            "UNION " +
            "SELECT product_catalog.product_name, product_catalog.product_unit, -sum(shipment.shipment_quantity), shipment.shipment_price  " +
            "FROM shipment " +
            "Inner JOIN product_catalog ON  product_catalog.product_id = shipment.product_catalog_id " +
            "GROUP BY product_catalog.product_id) as t1 " +
            "GROUP BY t1.a1, t1.a2, t1.a4";

    private static final String SELECT_RESULT_BY_DATE = "select t1.a1, t1.a2, sum(t1.a3), t1.a4\n" +
            "FROM\n" +
            "(SELECT product_catalog.product_name as a1, product_catalog.product_unit as a2,  sum(receipt.receipt_quantity) as a3, receipt.receipt_price as a4\n" +
            "FROM receipt\n" +
            "Inner JOIN product_catalog ON  product_catalog.product_id = receipt.product_catalog_id \n" +
            "WHERE receipt.receipt_date <= ?" +
            "GROUP BY product_catalog.product_id, receipt.receipt_price \n" +
            "UNION\n" +
            "SELECT product_catalog.product_name, product_catalog.product_unit, -sum(shipment.shipment_quantity), shipment.shipment_price \n" +
            "FROM shipment\n" +
            "Inner JOIN product_catalog ON  product_catalog.product_id = shipment.product_catalog_id \n" +
            "WHERE shipment.shipment_date <= ?" +
            "GROUP BY product_catalog.product_id) as t1\n" +
            "GROUP BY t1.a1, t1.a2, t1.a4";


    private static final String CREATE_NEW_SHIPMENT = "INSERT INTO shipment (operation_code_id, shipment_date, " +
            "product_catalog_id, shipment_quantity, shipment_price, recepient_company_id, shipment_user_id, " +
            "invoice_number, proxy_number, recepient_employee_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public SQLShipmentDAO() {
    }

    public static ShipmentDAO getInstance() {
        return SQLShipmentDAO.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final ShipmentDAO instance = new SQLShipmentDAO();
    }

    @Override
    public List<Shipment> findAll() throws DaoException {
        List<Shipment> shipmentList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL)) {
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                shipmentList.add(getEntrySelectAll(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return shipmentList;
    }

    @Override
    public Shipment findById(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_SHIPMENT_ID)) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                return getEntry(set);
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public Long create(Shipment entity) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(CREATE_NEW_SHIPMENT)) {
            statement.setInt(1, entity.getOperationCodeId());
            statement.setString(2, entity.getShipmentDate());
            statement.setInt(3, entity.getProductCatalogId());
            statement.setDouble(4, entity.getShipmentQuantity());
            statement.setDouble(5, entity.getShipmentPrice());
            statement.setInt(6, entity.getRecepientCompanyId());
            statement.setLong(7, entity.getShipmentUserId());
            statement.setString(8, entity.getInvoiceNumber());
            statement.setLong(9, entity.getProxyNumber());
            statement.setString(10, entity.getRecepientEmployeeName());

            statement.executeUpdate();
            ResultSet set = statement.executeQuery();

            return getEntry(set).getShipmentId();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Integer update(Shipment entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Shipment> findByPeriod(Date dateBeginning, Date dateEnd) throws DaoException {
        List<Shipment> shipmentList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_PERIOD)) {
            statement.setDate(1, dateBeginning);
            statement.setDate(2, dateEnd);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                shipmentList.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return shipmentList;
    }

    @Override
    public List<Shipment> findByProductNameAndPeriod(String productName, Date dateBeginning, Date dateEnd) throws DaoException {
        List<Shipment> shipmentList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_PRODUCT_NAME_AND_PERIOD)) {
            statement.setString(1, productName);
            statement.setDate(2, dateBeginning);
            statement.setDate(3, dateEnd);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                shipmentList.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return shipmentList;
    }

    @Override
    public List<Shipment> findByCompanyNameAndPeriod(String companyName, Date dateBeginning, Date dateEnd) throws DaoException {
        List<Shipment> shipmentList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_COMPANY_NAME_AND_PERIOD)) {
            statement.setString(1, companyName);
            statement.setDate(2, dateBeginning);
            statement.setDate(3, dateEnd);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                shipmentList.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return shipmentList;
    }

    @Override
    public List<Shipment> findResult() throws DaoException {
        List<Shipment> shipmentList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_RESULT_FOR_NOW)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                shipmentList.add(getEntryFindResult(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return shipmentList;
    }

    @Override

    public List<Shipment> findResultDate(Date date) throws DaoException {
        List<Shipment> shipmentList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_RESULT_BY_DATE)) {
            statement.setDate(1, date);
            statement.setDate(2, date);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                shipmentList.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return shipmentList;
    }

    private Shipment getEntry(ResultSet set) throws DaoException {
        try {
            Shipment shipment = new Shipment();
            shipment.setShipmentId(set.getLong(SHIPMENT_ID));
            shipment.setShipmentDate(set.getString(SHIPMENT_DATE));
            shipment.setRecepientCompanyId(set.getInt(RECEPIENT_COMPANY_ID));
            shipment.setProductCatalogId(set.getInt(PRODUCT_CATALOG_ID));
            shipment.setShipmentQuantity(set.getDouble(SHIPMENT_QUANTITY));
            shipment.setShipmentPrice(set.getDouble(SHIPMENT_PRICE));
            shipment.setInvoiceNumber(set.getString(INVOICE_NUMBER));
            shipment.setProxyNumber(set.getInt(PROXY_NUMBER));
            shipment.setShipmentUserId(set.getLong(SHIPMENT_USER_ID));
            shipment.setRecepientEmployeeName(set.getString(RECEPIENT_EMPLOYEE_NAME));
            shipment.setOperationCodeId(set.getInt(OPERATION_CODE_ID));
            return shipment;
        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }

    private Shipment getEntrySelectAll(ResultSet set) throws DaoException {
        try {
            Shipment shipment = new Shipment();
            shipment.setShipmentId(set.getLong(SHIPMENT_ID));
            shipment.setOperationCodePurpose(set.getString(OPERATION_CODE_PURPOSE));
            shipment.setProductCatalogName(set.getString(PRODUCT_CATALOG_NAME));
            shipment.setProductCatalogUnit(set.getString(PRODUCT_CATALOG_UNIT));
            shipment.setShipmentQuantity(set.getDouble(SHIPMENT_QUANTITY));
            shipment.setShipmentPrice(set.getDouble(SHIPMENT_PRICE));
            shipment.setShipmentDate(set.getString(SHIPMENT_DATE));
            shipment.setShipmentUserSurname(set.getString(SHIPMENT_USER_SURNAME));
            shipment.setRecepientCompanyName(set.getString(RECEPIENT_COMPANY_NAME));
            shipment.setInvoiceNumber(set.getString(INVOICE_NUMBER));
            shipment.setProxyNumber(set.getInt(PROXY_NUMBER));
            shipment.setRecepientEmployeeName(set.getString(RECEPIENT_EMPLOYEE_NAME));

            return shipment;
        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }

    private Shipment getEntryFindResult(ResultSet set) throws DaoException {
        try {
            Shipment shipment = new Shipment();
            shipment.setProductCatalogName(set.getString(PRODUCT_CATALOG_NAME));
            shipment.setProductCatalogUnit(set.getString(PRODUCT_CATALOG_UNIT));
            shipment.setShipmentQuantity(set.getDouble(SHIPMENT_QUANTITY));
            shipment.setShipmentPrice(set.getDouble(SHIPMENT_PRICE));

            return shipment;
        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }
//    public void closePrepareStatement(PreparedStatement ps) {
//        if (ps != null) {
//            try {
//                ps.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
