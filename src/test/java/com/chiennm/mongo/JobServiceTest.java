package com.chiennm.mongo;

import com.chiennm.mongo.entity.Job;
import com.chiennm.mongo.service.JobService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JobServiceTest extends MongoApplicationTests {

    @Autowired
    private JobService jobService;

    @Test
    public void insert() {
        for (int i = 0; i < 10; i++) {
            Job job = new Job();
            job.setName("CNTT " + i);
            job.setDescription("Description " + i);
            jobService.save(job);
        }
    }

    @Test
    public void findById(){
        Job job = jobService.findById("5d95a7d9cb5cd42ec0ee336c");
        System.out.println(job);
    }

}
