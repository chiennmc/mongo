package com.chiennm.mongo.repository.impl;

import com.chiennm.mongo.entity.User;
import com.chiennm.mongo.entity.UserDetail;
import com.chiennm.mongo.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserDetailRepositoryImpl implements UserDetailRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserDetail findById(User user, Long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, UserDetail.class);
    }

    @Override
    public UserDetail save(User user, Collection userDetails) {
        return null;
    }

}
