package com.chiennm.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "jobs")
public class Job {
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String JOB_ID = "jobId";

    @Indexed
    @Id
    private ObjectId _id;

    @Field(value = JOB_ID)
    private String jobId;

    @Field(value = NAME)
    private String name;

    @Field(value = DESCRIPTION)
    private String description;

//    @DBRef
//    private List<User> users;

}
