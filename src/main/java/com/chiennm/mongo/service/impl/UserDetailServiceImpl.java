package com.chiennm.mongo.service.impl;

import com.chiennm.mongo.entity.User;
import com.chiennm.mongo.entity.UserDetail;
import com.chiennm.mongo.repository.UserRepository;
import com.chiennm.mongo.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetail findById(String userId, Long detailId) {
        User user = userRepository.findById(userId);
        if (Objects.isNull(user)) {
            System.out.println("UserId " + userId + " not found");
            return null;
        }
        return null;
    }

    @Override
    public List<UserDetail> findAllByUserId(String userId) {
        User user = userRepository.findById(userId);
        if (Objects.isNull(user)) {
            System.out.println("UserId " + userId + " not found");
            return null;
        }
        return user.getUserDetails();
    }

}
