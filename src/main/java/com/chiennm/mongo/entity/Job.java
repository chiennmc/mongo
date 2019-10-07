package com.chiennm.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

@Getter
@Setter
@Document(collection = "jobs")
public class Job {
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";

    @Indexed
    @Id
    private ObjectId _id;

    @Field(value = NAME)
    private String name;

    @Field(value = DESCRIPTION)
    private String description;

    @DBRef
    private List<User> users;

}
