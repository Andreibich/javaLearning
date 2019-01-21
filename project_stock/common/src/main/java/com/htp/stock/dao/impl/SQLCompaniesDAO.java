package com.htp.stock.dao.impl;

import com.htp.stock.dao.CompaniesDAO;
import com.htp.stock.dao.connection_pool.ConnectionPool;
import com.htp.stock.dao.connection_pool.ConnectionPoolException;
import com.htp.stock.domain.to.Companies;
import com.htp.stock.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLCompaniesDAO implements CompaniesDAO {

    private static final String COMPANY_ID = "company_id";
    private static final String COMPANY_NAME = "company_name";
    private static final String CITY = "city";
    private static final String ADDRESS = "address";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String SELECT_BY_COMPANY_ID = "SELECT * FROM companies WHERE company_id = ?";
    private static final String SELECT_BY_COMPANY_NAME = "SELECT * FROM companies WHERE company_name = ?";
    private static final String SELECT_BY_CITY = "SELECT * FROM companies WHERE city = ?";
    private static final String SELECT_BY_ADDRESS = "SELECT * FROM companies WHERE address = ?";
    private static final String SELECT_ALL = "SELECT * FROM companies ";

    private static final String CREATE_NEW_COMPANY = "INSERT INTO companies(company_name, city, address) " +
            "VALUES ('?', '?', '?')";



    public SQLCompaniesDAO() {
    }

    public static CompaniesDAO getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final CompaniesDAO instance = new SQLCompaniesDAO();
    }

    @Override
    public List<Companies> findAll() throws DaoException {
        List<Companies> companies = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                companies.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return companies;
    }

    @Override
    public Companies findById(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_COMPANY_ID)) {
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
    public int create(Companies entity) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(CREATE_NEW_COMPANY)) {
            statement.setString(1, entity.getCompanyName());
            statement.setString(2, entity.getCity());
            statement.setString(3, entity.getAddress());
            statement.executeUpdate();
            ResultSet set = statement.executeQuery();

            return getEntry(set).getCompanyId().intValue();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Integer update(Companies entity) throws DaoException {
        return null;
    }

    @Override
    public Companies findByCompanyName(String companyName) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_COMPANY_NAME)) {
            statement.setString(1, companyName);
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

    private Companies getEntry(ResultSet set) throws DaoException {
        try {
            Companies companies = new Companies();
            companies.setCompanyId(set.getLong(COMPANY_ID));
            companies.setCompanyName(set.getString(COMPANY_NAME));
            companies.setCity(set.getString(CITY));
            companies.setAddress(set.getString(ADDRESS));
            return companies;
        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }
}
