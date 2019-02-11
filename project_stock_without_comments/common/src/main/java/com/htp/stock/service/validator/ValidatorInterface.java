package com.htp.stock.service.validator;

public interface ValidatorInterface<T> {

    boolean isValid(T entity);
}
