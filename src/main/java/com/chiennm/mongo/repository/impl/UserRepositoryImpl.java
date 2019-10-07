package com.chiennm.mongo.repository.impl;

import com.chiennm.mongo.entity.User;
import com.chiennm.mongo.repository.GenericQuery;
import com.chiennm.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private GenericQuery<User> userGenericQuery;

    @Override
    public User findById(String id) {
        return userGenericQuery.findById(id, User.class);
    }

    @Override
    public User save(User user) {
        return userGenericQuery.save(user);
    }

    @Override
    public User update(User user) {
        Update update = new Update();
        update.set(User.NAME, user.getName());
        update.set(User.GENDER, user.getGender());
        return userGenericQuery.update(user.get_id().toString(), update, User.class);
    }

    @Override
    public List<User> findAll() {
        return userGenericQuery.findAll(User.class);
    }

    @Override
    public List<User> findAllByKeyAndValue(String key, String value) {
        return userGenericQuery.findAllByKeyAndValue(key, value, User.class);
    }

    @Override
    public String delete(String id) {
        userGenericQuery.delete("_id", id, User.class);
        return String.format("Delete %s success", id);
    }

    @Override
    public User findByKeyAndValue(String key, String value) {
        return userGenericQuery.findByKeyAndValue(key, value, User.class);
    }

//    void test() {
//        MongoClient mongoClient = new MongoClient();
//        MongoDatabase database = mongoClient.getDatabase("test");
//        MongoCollection<Document> collection = database.getCollection("restaurants");
//        collection.updateMany(null, null);
//    }
}
