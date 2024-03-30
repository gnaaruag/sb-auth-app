package com.userauthsb.authapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auth")
@Data
@AllArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String username;
    private String email;
    private String password;

    public User() {
    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
