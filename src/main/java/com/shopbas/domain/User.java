package com.shopbas.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class User {

    private String id;
    private String userName;
    private String password;
    private UserStatus status;
    private String applicationId;
}
