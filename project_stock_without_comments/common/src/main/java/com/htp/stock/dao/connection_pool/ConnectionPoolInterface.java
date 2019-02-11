package com.htp.stock.dao.connection_pool;

import java.sql.Connection;

public interface ConnectionPoolInterface {

    void init() throws ConnectionPoolException;

    void dispose() throws ConnectionPoolException;


    Connection getConnection() throws ConnectionPoolException;


    void putConnection();
}
