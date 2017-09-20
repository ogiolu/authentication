package com.shopbas.vo;

import lombok.Getter;
import lombok.Setter;

public class AccountCredentials {
  @Getter
  @Setter
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}