package com.shopbas.domain;

import java.sql.Date;

public class Throttle {
    private String id;
    private String deviceId ;
    private String deviceType ;
    private LogonStatus LogonStatus;
    private Integer noOfFailedLogon ;
    private String ip ;

    private Date lastLogonDate ;
}
