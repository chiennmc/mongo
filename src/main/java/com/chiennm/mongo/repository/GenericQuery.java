package com.chiennm.mongo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class GenericQuery<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Query query(String key, String value) {
        Query query = new Query();
        return query.addCriteria(Criteria.where(key).is(value));
    }

    public T findById(String id, Class<T> clazz) {
        return this.findByKeyAndValue("_id", id, clazz);
    }

    public T findByKeyAndValue(String key, String value, Class<T> clazz) {
        return mongoTemplate.findOne(query(key, value), clazz);
    }

    public List<T> findAllByKeyAndValue(String key, String value, Class<T> clazz) {
        return mongoTemplate.find(query(key, value), clazz);
    }

    public List<T> findAll(Class<T> clazz) {
        return mongoTemplate.findAll(clazz);
    }

    public String delete(String key, String value, Class<T> clazz) {
        T t = this.findByKeyAndValue(key, value, clazz);
        if (Objects.isNull(t)) {
            return String.format("Not found object have: key: {%s} and value: {%s}", key, value);
        }

        mongoTemplate.remove(t);
        return "Delete success";
    }

    public T save(T t) {
        return mongoTemplate.save(t);
    }

    public T update(String id, Update update, Class<T> clazz) {
        return mongoTemplate.findAndModify(query("_id", id), update, clazz);
    }

}