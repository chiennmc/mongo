package com.chiennm.mongo;

import com.chiennm.mongo.entity.Gender;
import com.chiennm.mongo.entity.User;
import com.chiennm.mongo.entity.UserDetail;
import com.chiennm.mongo.service.UserService;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest extends MongoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void insert() {
        for (int j = 1; j < 10; j++) {
            User user = new User();
            user.setUserId((long) j);
            user.setName("Anh");
            user.setAge(21);
            user.setEmail("anhnk@vnext.com.vn");
            user.setGender(Gender.FEMALE);

            List<UserDetail> userDetails = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                UserDetail userDetail = new UserDetail();
//                userDetail.setId((long) i);
                userDetail.setId(new ObjectId());
                userDetail.setJob("Tester " + i);
                userDetail.setCompany("VNEXT " + i);
                userDetail.setAddress("219 Trung Kinh");
                userDetails.add(userDetail);
            }
            user.setUserDetails(userDetails);
            userService.save(user);
        }
    }

    @Test
    public void findById() {
        User user = userService.findById("5d946f0acb5cd43b78cb09d8");
        System.out.println(user);
        System.out.println(user.getUserDetails());
    }

    @Test
    public void updateUser() {
        User user = new User();
//        user.set_id(new ObjectId("000000000000000000000002"));
        user.setName("Minh");
        user.setGender(Gender.MALE);

        userService.update(user);
        this.findById();
    }

    @Test
    public void findAllUser() {
        System.out.println(userService.findAll());
    }

}
