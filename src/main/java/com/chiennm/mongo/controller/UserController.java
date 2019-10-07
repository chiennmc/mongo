package com.chiennm.mongo.controller;

import com.chiennm.mongo.entity.User;
import com.chiennm.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/{id}")
    private User findByid(@PathVariable String id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/{key}/{value}")
    private User findByKeyAndValue(@PathVariable String key, @PathVariable String value) {
        return userService.findByKeyAndValue(key, value);
    }

    @GetMapping(path = "/list/{key}/{value}")
    private List<User> findAllByKeyAndValue(@PathVariable String key, @PathVariable String value) {
        return userService.findAllByKeyAndValue(key, value);
    }

    @PostMapping
    private User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    private User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable String id) {
        return userService.delete(id);
    }

}
