package com.chiennm.mongo.repository;

import com.chiennm.mongo.entity.User;
import com.chiennm.mongo.entity.UserDetail;

import java.util.Collection;

public interface UserDetailRepository{
    UserDetail findById(User user, Long id);

    UserDetail save(User user, Collection userDetails);
}
