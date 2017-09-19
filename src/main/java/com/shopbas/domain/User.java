package com.shopbas.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    
    private String id;
    private String userName;
    private String password;
    private UserStatus status;
    private String applicationId;
}
