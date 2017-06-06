package com.salenko.model;

//https://unidoc.unitedthinkers.com/processing-api/realtime/operations#component_Sale_Request_field_group_Authentication_Information
public class AuthInfo {

    private String requestType;
    private String userName;
    private String password;
    private String accountId;

    public AuthInfo(String requestType, String userName, String password, String accountId) {
        this.requestType = requestType;
        this.userName = userName;
        this.password = password;
        this.accountId = accountId;
    }
    
    public String getRequestType() {
        return requestType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

}
