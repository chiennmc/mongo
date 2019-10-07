package com.chiennm.mongo.controller;

import com.chiennm.mongo.entity.Job;
import com.chiennm.mongo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    private List<Job> findAll() {
        return jobService.findAll();
    }

    @GetMapping(path = "/{id}")
    private Job findById(@PathVariable String id) {
        return jobService.findById(id);
    }

    @GetMapping(path = "/{key}/{value}")
    private Job findByKeyAndValue(@PathVariable String key, @PathVariable String value) {
        return jobService.findByKeyAndValue(key, value);
    }

    @GetMapping(path = "/list/{key}/{value}")
    private List<Job> findAllByKeyAndValue(@PathVariable String key, @PathVariable String value) {
        return jobService.findAllByKeyAndValue(key, value);
    }

    @PostMapping
    private Job save(@RequestBody Job job) {
        return jobService.save(job);
    }

    @DeleteMapping(path = "/{id}")
    private String delete(@PathVariable String id) {
        return jobService.delete(id);
    }

}
