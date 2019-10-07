package com.chiennm.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Document(collection = "users")
public class User {
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String EMAIL = "email";
    public static final String GENDER = "gender";

    @Id
    private ObjectId _id;

    @Indexed
    private Long userId;

    @Field(value = NAME)
    private String name;

    @Field(value = AGE)
    private int age;

    @Field(value = EMAIL)
    private String email;

    @Field(value = GENDER)
    private Gender gender;

    private Company company;

    @DBRef
    private List<UserDetail> userDetails;

    @DBRef
    private List<Job> jobs;

}
