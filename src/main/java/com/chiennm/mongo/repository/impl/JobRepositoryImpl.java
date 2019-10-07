package com.chiennm.mongo.repository.impl;

import com.chiennm.mongo.entity.Job;
import com.chiennm.mongo.repository.GenericQuery;
import com.chiennm.mongo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobRepositoryImpl implements JobRepository {

    @Autowired
    private GenericQuery<Job> jobGenericQuery;

    @Override
    public Job save(Job job) {
        return jobGenericQuery.save(job);
    }

    @Override
    public Job findByKeyAndValue(String key, String value) {
        return jobGenericQuery.findByKeyAndValue(key, value, Job.class);
    }

    @Override
    public List<Job> findAllByKeyAndValue(String key, String value) {
        return jobGenericQuery.findAllByKeyAndValue(key, value, Job.class);
    }

    @Override
    public String delete(String id) {
        return jobGenericQuery.delete("_id", id, Job.class);
    }

    @Override
    public List<Job> findAll() {
        return jobGenericQuery.findAll(Job.class);
    }

    @Override
    public Job update(Job job) {
        Update update = new Update();
        update.set(Job.NAME, job.getName());
        update.set(Job.DESCRIPTION, job.getDescription());
        return jobGenericQuery.update(job.get_id().toString(), update, Job.class);
    }

    @Override
    public Job findById(String id) {
        return jobGenericQuery.findById(id, Job.class);
    }

}
