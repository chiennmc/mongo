package com.chiennm.mongo.repository;

import java.util.List;

public interface BaseRepository<T> {

    T findById(String id);

    T save(T t);

    T findByKeyAndValue(String key, String value);

    List<T> findAllByKeyAndValue(String key, String value);

    String delete(String id);

    List<T> findAll();

    T update(T t);
}
