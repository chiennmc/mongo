package com.chiennm.mongo.service;

import com.chiennm.mongo.entity.UserDetail;

import java.util.List;

public interface UserDetailService {
    UserDetail findById(String userId, Long detailId);

    List<UserDetail> findAllByUserId(String userId);
}
