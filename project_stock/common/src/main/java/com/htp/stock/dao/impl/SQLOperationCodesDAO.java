package com.htp.stock.dao.impl;

import com.htp.stock.dao.OperationCodesDAO;
import com.htp.stock.dao.connection_pool.ConnectionPool;
import com.htp.stock.dao.connection_pool.ConnectionPoolException;
import com.htp.stock.domain.to.OperationCodes;
import com.htp.stock.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLOperationCodesDAO implements OperationCodesDAO {

    private static final String OPERATION_CODE_ID = "operation_code_id";
    private static final String PURPOSE = "purpose";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String SELECT_BY_OPERATION_CODE_ID = "SELECT * FROM operation_codes WHERE operation_code_id = ?";
    private static final String SELECT_BY_PURPOSE = "SELECT * FROM operation_codes WHERE purpose = ?";
    private static final String SELECT_ALL = "SELECT * FROM operation_codes";

    private static final String CREATE_NEW_OPERATION_CODE = "INSERT INTO operation_codes(purpose) VALUES (?)";

    public SQLOperationCodesDAO() {
    }

    public static OperationCodesDAO getInstance() {
        return SQLOperationCodesDAO.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final OperationCodesDAO instance = new SQLOperationCodesDAO();
    }

    @Override
    public List<OperationCodes> findAll() throws DaoException {
        List<OperationCodes> operationCodes = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                operationCodes.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return operationCodes;
    }

    @Override
    public OperationCodes findById(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_OPERATION_CODE_ID)) {
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
    public Long create(OperationCodes entity) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(CREATE_NEW_OPERATION_CODE)) {
            statement.setString(1, entity.getPurpose());
            statement.executeUpdate();
            ResultSet set = statement.executeQuery();

            return getEntry(set).getOperationCodeId().longValue();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Integer update(OperationCodes entity) throws DaoException {
        return null;
    }

    @Override
    public OperationCodes findByPurpose(String purpose) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_PURPOSE)) {
            statement.setString(1, purpose);
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

    private OperationCodes getEntry(ResultSet set) throws DaoException {
        try {
            OperationCodes operationCodes = new OperationCodes();
            operationCodes.setOperationCodeId(set.getInt(OPERATION_CODE_ID));
            operationCodes.setPurpose(set.getString(PURPOSE));
            return operationCodes;
        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }
}
