package com.chiennm.mongo.service;

import java.util.List;

public interface BaseService<T> {
    T save(T t);

    T update(T t);

    T findById(String id);

    String delete(String id);

    List<T> findAll();

    T findByKeyAndValue(String key, String value);

    List<T> findAllByKeyAndValue(String key, String value);
}
