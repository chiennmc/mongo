package com.chiennm.mongo.service.impl;

import com.chiennm.mongo.entity.Job;
import com.chiennm.mongo.repository.JobRepository;
import com.chiennm.mongo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job update(Job job) {
        return jobRepository.update(job);
    }

    @Override
    public Job findById(String id) {
        return jobRepository.findById(id);
    }

    @Override
    public String delete(String id) {
        return jobRepository.delete(id);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findByKeyAndValue(String key, String value) {
        return jobRepository.findByKeyAndValue(key, value);
    }

    @Override
    public List<Job> findAllByKeyAndValue(String key, String value) {
        return jobRepository.findAllByKeyAndValue(key, value);
    }

}
