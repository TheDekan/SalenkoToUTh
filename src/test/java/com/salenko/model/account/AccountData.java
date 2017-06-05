package com.salenko.model.account;

//part of AccountInfo, used for sale requests with account data
public class AccountData {

    private String accountData;

    public AccountData(String accountData) {
        this.accountData = accountData;
    }

    public String getAccountData() {
        return accountData;
    }

    public void setAccountData(String accountData) {
        this.accountData = accountData;
    }

}
