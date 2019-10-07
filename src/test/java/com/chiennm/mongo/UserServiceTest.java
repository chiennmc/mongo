package com.chiennm.mongo;

import com.chiennm.mongo.entity.Gender;
import com.chiennm.mongo.entity.Job;
import com.chiennm.mongo.entity.User;
import com.chiennm.mongo.service.JobService;
import com.chiennm.mongo.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest extends MongoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @Test
    public void insert() {
        for (int j = 1; j < 10; j++) {
            User user = new User();
            user.setUserId((long) j);
            user.setName("Anh");
            user.setAge(21);
            user.setEmail("anhnk@vnext.com.vn");
            user.setGender(Gender.FEMALE);

            List<Job> jobs = new ArrayList<>();
            Job job1 = jobService.findById("5d95a7d9cb5cd42ec0ee336c");
            Job job2 = jobService.findById("5d95a7d9cb5cd42ec0ee336d");

            jobs.add(job1);
            jobs.add(job2);
            user.setJobs(jobs);
            userService.save(user);
        }
    }

    @Test
    public void findById() {
        User user = userService.findById("5d9b13fc87485134f9778474");
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
