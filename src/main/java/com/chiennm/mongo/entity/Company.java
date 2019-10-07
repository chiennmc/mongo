package com.chiennm.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "companies")
public class Company {

    @Id
    private ObjectId _id;
    private String name;
    private String address;

    @DBRef
    private List<User> users;

}
