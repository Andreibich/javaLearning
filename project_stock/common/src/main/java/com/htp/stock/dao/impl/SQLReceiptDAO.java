package com.htp.stock.dao.impl;

import com.htp.stock.dao.ReceiptDAO;
import com.htp.stock.dao.connection_pool.ConnectionPool;
import com.htp.stock.dao.connection_pool.ConnectionPoolException;
import com.htp.stock.domain.to.Receipt;
import com.htp.stock.exceptions.DaoException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLReceiptDAO implements ReceiptDAO {

    private static final String RECEIPT_ID = "receipt_id";
    private static final String SUPPLIER_ID = "supplier_id";
    private static final String RECEIPT_DATE = "receipt_date";
    private static final String RECEIPT_PRICE = "receipt_price";
    private static final String RECEIPT_QUANTITY = "receipt_quantity";
    private static final String PRODUCT_CATALOG_ID = "product_catalog_id";
    private static final String RECEIPT_USER_ID = "receipt_user_id";
    private static final String INVOICE_NUMBER = "invoice_number";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String SELECT_BY_RECEIPT_ID = "SELECT * FROM receipt WHERE receipt_id = ?";
    private static final String SELECT_BY_SUPPLIER_ID = "SELECT * FROM receipt WHERE supplier_id = ?";
    private static final String SELECT_BY_RECEIPT_DATE = "SELECT * FROM receipt WHERE receipt_date = ?";
    private static final String SELECT_BY_RECEIPT_PRICE = "SELECT * FROM receipt WHERE receipt_price = ?";
    private static final String SELECT_BY_RECEIPT_QUANTITY = "SELECT * FROM receipt WHERE receipt_quantity = ?";
    private static final String SELECT_BY_PRODUCT_CATALOG_ID = "SELECT * FROM receipt WHERE product_catalog_id = ?";
    private static final String SELECT_BY_RECEIPT_USER_ID = "SELECT * FROM receipt WHERE receipt_user_id = ?";
    private static final String SELECT_BY_INVOICE_NUMBER = "SELECT * FROM receipt WHERE invoice_number = ?";
    private static final String SELECT_ALL = "SELECT * FROM receipt";
    private static final String SELECT_BY_PERIOD = "SELECT * FROM receipt WHERE shipment_date >= ? AND shipment_date <= ?";
    private static final String SELECT_BY_PRODUCT_NAME_AND_PERIOD = "SELECT receipt.receipt_id, receipt.receipt_date, " +
            "product_catalog.product_name, receipt.receipt_price, receipt.receipt_quantity, companies.company_name, " +
            "receipt.invoice_number, user.name   FROM receipt INNER JOIN product_catalog ON product_catalog.product_id = " +
            "receipt.product_catalog_id INNER JOIN companies ON companies.company_id = receipt.supplier_id INNER JOIN " +
            "user ON receipt.receipt_user_id = user.user_id WHERE product_catalog.product_name = ? AND " +
            "receipt.receipt_date >= ? AND receipt.receipt_date <= ?";

    private static final String SELECT_BY_COMPANY_NAME_AND_PERIOD = "SELECT receipt.receipt_id, receipt.receipt_date, " +
            "product_catalog.product_name, receipt.receipt_price, receipt.receipt_quantity, companies.company_name, " +
            "receipt.invoice_number, user.name   FROM receipt INNER JOIN product_catalog ON product_catalog.product_id = " +
            "receipt.product_catalog_id INNER JOIN companies ON companies.company_id = receipt.supplier_id INNER JOIN " +
            "user ON receipt.receipt_user_id = user.user_id WHERE companies.company_name = ? AND " +
            "receipt.receipt_date >= ? AND receipt.receipt_date <= ?";

    private static final String CREATE_NEW_RECEIPT = "INSERT INTO receipt (receipt_date, product_catalog_id, receipt_quantity, receipt_price, " +
            "supplier_id, receipt_user_id, invoice_number) VALUES (?,?,?,?,?,?,?)";

    public SQLReceiptDAO() {
    }

    public static ReceiptDAO getInstance() {
        return SQLReceiptDAO.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final ReceiptDAO instance = new SQLReceiptDAO();
    }


    @Override
    public List<Receipt> findAll() throws DaoException {
        List<Receipt> receiptList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                receiptList.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return receiptList;
    }

    @Override
    public Receipt findById(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_RECEIPT_ID)) {
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
    public Long create(Receipt entity) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(CREATE_NEW_RECEIPT)) {
            statement.setDate(1, entity.getReceiptDate());
            statement.setInt(2, entity.getProductCatalogId());
            statement.setDouble(3, entity.getReceiptQuantity());
            statement.setDouble(4, entity.getReceiptPrice());
            statement.setInt(5, entity.getSupplierId());
            statement.setLong(6, entity.getReceiptUserId());
            statement.setString(7, entity.getInvoiceNumber());

            statement.executeUpdate();
            ResultSet set = statement.executeQuery();

            return getEntry(set).getReceiptId();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Integer update(Receipt entity) throws DaoException {
        return null;
    }

    @Override
    public List<Receipt> findByPeriod(Date dateBeginning, Date dateEnd) throws DaoException {
        List<Receipt> receiptList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_PERIOD)) {
            statement.setDate(1, dateBeginning);
            statement.setDate(2, dateEnd);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                receiptList.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return receiptList;
    }

    @Override
    public List<Receipt> findByProductNameAndPeriod(String productName, Date dateBeginning, Date dateEnd) throws DaoException {
        List<Receipt> receiptList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_PRODUCT_NAME_AND_PERIOD)) {
            statement.setString(1, productName);
            statement.setDate(2, dateBeginning);
            statement.setDate(3, dateEnd);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                receiptList.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return receiptList;
    }

    @Override
    public List<Receipt> findByCompanyNameAndPeriod(String companyName, Date dateBeginning, Date dateEnd) throws DaoException {
        List<Receipt> receiptList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_COMPANY_NAME_AND_PERIOD)) {
            statement.setString(1, companyName);
            statement.setDate(2, dateBeginning);
            statement.setDate(3, dateEnd);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                receiptList.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return receiptList;
    }

    private Receipt getEntry(ResultSet set) throws DaoException {
        try {
            Receipt receipt = new Receipt();
            receipt.setReceiptId(set.getLong(RECEIPT_ID));
            receipt.setReceiptDate(set.getDate(RECEIPT_DATE));
            receipt.setSupplierId(set.getInt(SUPPLIER_ID));
            receipt.setProductCatalogId(set.getInt(PRODUCT_CATALOG_ID));
            receipt.setReceiptQuantity(set.getDouble(RECEIPT_QUANTITY));
            receipt.setReceiptPrice(set.getDouble(RECEIPT_PRICE));
            receipt.setInvoiceNumber(set.getString(INVOICE_NUMBER));
            receipt.setReceiptUserId(set.getLong(RECEIPT_USER_ID));
            return receipt;
        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }
}
