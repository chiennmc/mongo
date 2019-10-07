package com.chiennm.mongo.controller;

import com.chiennm.mongo.entity.UserDetail;
import com.chiennm.mongo.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/details")
public class UserDetailController {

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping(path = "/{userId}")
    private List<UserDetail> findAllByUserId(@PathVariable String userId) {
        return userDetailService.findAllByUserId(userId);
    }

}
