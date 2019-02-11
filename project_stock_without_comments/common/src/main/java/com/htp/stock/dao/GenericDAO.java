package com.htp.stock.dao;

import com.htp.stock.exceptions.DaoException;

import java.util.List;

public interface GenericDAO <T, K> {

	List<T> findAll() throws DaoException;

	T findById(K id) throws DaoException;

	boolean delete(K id) throws DaoException;

	Long create(T entity) throws DaoException;

	K update(T entity) throws DaoException;


}
