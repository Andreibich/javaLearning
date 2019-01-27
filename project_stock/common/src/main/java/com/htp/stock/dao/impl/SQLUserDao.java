package com.htp.stock.dao.impl;

import com.htp.stock.dao.UserDAO;
import com.htp.stock.dao.connection_pool.ConnectionPool;
import com.htp.stock.dao.connection_pool.ConnectionPoolException;
import com.htp.stock.domain.to.User;
import com.htp.stock.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDao implements UserDAO {

    private static final String USER_ID = "user_id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String EMAIL = "email";
    private static final String CREATION_DATE = "creation_date";
    private static final String TYPE = "type";
    private static final String LAST_ID = "lastId";

    private static final ConnectionPool pool = ConnectionPool.getInstance();


    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId";
    private static final String SELECT_BY_ID = "SELECT * FROM user WHERE user_id = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM user WHERE name = ?";
    private static final String SELECT_BY_SURNAME = "SELECT * FROM user WHERE surname = ?";
    private static final String SELECT_BY_LOGIN = "SELECT * FROM user WHERE login = ?";
    private static final String SELECT_BY_PASSWORD = "SELECT * FROM user WHERE password = ?";
    private static final String SELECT_BY_PHONE_NUMBER = "SELECT * FROM user WHERE phone_number = ?";
    private static final String SELECT_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
    private static final String SELECT_BY_CREATION_DATE = "SELECT * FROM user WHERE creation_date = ?";
    private static final String SELECT_BY_TYPE = "SELECT * FROM user WHERE type = ?";
    private static final String SELECT_BY_LOGIN_PASSWORD = "SELECT * FROM user WHERE login = ? AND password = ?";
    private static final String SELECT_ALL = "SELECT * FROM user";

    private static final String CREATE_NEW_USER = "INSERT INTO user (name, surname, login, password, phone_number, " +
            "email, creation_date, type) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String DELETE_USER = "DELETE FROM user WHERE user_id = ?";

    private static final String UPDATE_USER = "UPDATE user SET type = ? where user_id = ? ";

    private SQLUserDao() {
    }

    //    Demand Holder Idiom
    public static UserDAO getInstance() {
        return SingletonHolder.instance;
    }


    private static class SingletonHolder {
        private static final UserDAO instance = new SQLUserDao();
    }


    public User getUserNode(String login, String password) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_LOGIN_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                return getEntry(set);
            } else {
                throw new SQLException ("SQL Exception");
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }

    }

    public boolean checkUser(String login, String password) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_LOGIN_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();
            return set.next();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    public List<User> findAll() throws DaoException {
        List<User> userList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                userList.add(getEntry(set));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return userList;
    }

    public User findById(Long id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id.intValue());
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

    public boolean delete(Long id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(DELETE_USER)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }
//    name, surname, login, password, phone_number, " +
//            "email, creation_date, type

    public int create(User entity) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(CREATE_NEW_USER);
             PreparedStatement statementThird = connect.prepareStatement(LAST_INSERT_ID)) {
            statement.setString(1, entity.getUserName());
            statement.setString(2, entity.getSurname());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            statement.setDate(6, entity.getCreationDate());
            statement.setString(7, entity.getType());
            statement.executeUpdate();

            ResultSet set = statementThird.executeQuery();

            set.next();
            return set.getInt(LAST_ID);

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    public Long update(User entity) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(UPDATE_USER)) {
            statement.setLong(1, entity.getUserId());
            statement.setString(2, entity.getType());

            statement.executeUpdate();
            ResultSet set = statement.executeQuery();

            return getEntry(set).getUserId();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }


    private User getEntry(ResultSet set) throws DaoException {
        try {
            User user = new User();
            user.setUserId(set.getLong(USER_ID));
            user.setUserName(set.getString(NAME));
            user.setSurname(set.getString(SURNAME));
            user.setLogin(set.getString(LOGIN));
            user.setPassword(set.getString(PASSWORD));
            user.setPhoneNumber(set.getString(PHONE_NUMBER));
            user.setEmail(set.getString(EMAIL));
            user.setType(set.getString(TYPE));
            user.setCreationDate(set.getDate(CREATION_DATE));
            return user;
        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }

}
