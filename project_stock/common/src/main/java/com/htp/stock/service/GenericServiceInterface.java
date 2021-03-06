package com.htp.stock.service;



import java.util.List;

/**
        * Basic Service interface with template parameters.
        * @param <T> generic type of objects passed to methods and can be returned
        * @param <V> generic type of objects which will serve as a view object.
        * Provides create and viewAll operations with {@link T} and {@link V} objects.
        */
public interface GenericServiceInterface<T, V> {
    /**
     * Method adding object in database and creates the appropriate entry there
     *
     * @param entity object necessary to adding in database
     * @return {@link T} object, that method can create
     * @throws ServiceException
     */
     V create(T entity) throws ServiceException;

    /**
     * Method provides viewing all information and package this information in view object
     *
     * @return {@link T} object necessary for view all objects
     * @throws ServiceException
     */
    List<T> loadAll() throws ServiceException;

    T loadById(V id) throws ServiceException;
}