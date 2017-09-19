package com.shopbas.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
@Document
public class Throttle {
    private String id;
    private String deviceId ;
    private String deviceType ;
    private LogonStatus LogonStatus;
    private Integer noOfFailedLogon ;
    private String ip ;

    private Date lastLogonDate ;
}
