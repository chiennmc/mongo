package com.chiennm.mongo.service.impl;

import com.chiennm.mongo.entity.User;
import com.chiennm.mongo.repository.UserRepository;
import com.chiennm.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public List<User> findAllByKeyAndValue(String key, String value) {
        return userRepository.findAllByKeyAndValue(key, value);
    }

    @Override
    public String delete(String id) {
        return userRepository.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByKeyAndValue(String key, String value) {
        return userRepository.findByKeyAndValue(key, value);
    }

}
