package com.chiennm.mongo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user_details")
public class UserDetail {

    @Id
    private ObjectId id;
    private String job;
    private String company;
    private String address;

}
