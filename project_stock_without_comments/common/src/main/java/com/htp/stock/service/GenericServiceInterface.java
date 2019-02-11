package com.htp.stock.service;



import java.util.List;

public interface GenericServiceInterface<T, V> {

     V create(T entity) throws ServiceException;

    List<T> loadAll() throws ServiceException;

    T loadById(V id) throws ServiceException;
}