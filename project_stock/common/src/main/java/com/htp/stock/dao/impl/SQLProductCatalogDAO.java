package com.htp.stock.dao.impl;

import com.htp.stock.dao.ProductCatalogDAO;
import com.htp.stock.dao.connection_pool.ConnectionPool;
import com.htp.stock.dao.connection_pool.ConnectionPoolException;
import com.htp.stock.domain.to.ProductCatalog;
import com.htp.stock.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLProductCatalogDAO implements ProductCatalogDAO {

    private static final String PRODUCT_ID = "product_id";
    private static final String PRODUCT_NAME = "product_name";
    private static final String PRODUCT_UNIT = "product_unit";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String SELECT_BY_PRODUCT_ID = "SELECT * FROM product_catalog WHERE product_id = ?";
    private static final String SELECT_BY_PRODUCT_NAME = "SELECT * FROM product_catalog WHERE product_name = ?";
    private static final String SELECT_BY_UNIT = "SELECT * FROM product_catalog WHERE product_unit = ?";
    private static final String SELECT_ALL = "SELECT * FROM product_catalog";

    private static final String CREATE_NEW_PRODUCT = "INSERT INTO product_catalog(product_name, product_unit) " +
            "VALUES (?,?)";

    public SQLProductCatalogDAO() {
    }

    public static ProductCatalogDAO getInstance() {
        return SQLProductCatalogDAO.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final ProductCatalogDAO instance = new SQLProductCatalogDAO();
    }

    @Override
    public List<ProductCatalog> findAll() throws DaoException {
        List<ProductCatalog> productCatalog = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                productCatalog.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return productCatalog;
    }

    @Override
    public ProductCatalog findById(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_PRODUCT_ID)) {
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
    public int create(ProductCatalog entity) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(CREATE_NEW_PRODUCT)) {
            statement.setString(1, entity.getProductName());
            statement.setString(2, entity.getProductUnit());
            statement.executeUpdate();
            ResultSet set = statement.executeQuery();

            return getEntry(set).getProductId().intValue();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Integer update(ProductCatalog entity) throws DaoException {
        return null;
    }

    @Override
    public ProductCatalog findByProductName(String productName) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_PRODUCT_NAME)) {
            statement.setString(1, productName);
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

    private ProductCatalog getEntry(ResultSet set) throws DaoException {
        try {
            ProductCatalog productCatalog = new ProductCatalog();
            productCatalog.setProductId(set.getLong(PRODUCT_ID));
            productCatalog.setProductName(set.getString(PRODUCT_NAME));
            productCatalog.setProductUnit(set.getString(PRODUCT_UNIT));
            return productCatalog;
        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }
}
