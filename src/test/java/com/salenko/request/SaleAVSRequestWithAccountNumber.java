package com.salenko.request;

import com.salenko.model.AuthInfo;
import com.salenko.model.BillingAddressInfo;
import com.salenko.model.TransactionInfo;
import com.salenko.model.account.AccountInfo;
import com.salenko.model.account.AccountNumber;
import com.salenko.utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

//Sale request for account verification with account number
public class SaleAVSRequestWithAccountNumber extends SaleRequestWithAccountNumber {
    private BillingAddressInfo billingAddressInfo;

    public SaleAVSRequestWithAccountNumber(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo,
            AccountNumber accountNumber, BillingAddressInfo billingAddressInfo) {
        super(authInfo, accountInfo, transactionInfo, accountNumber);
        this.billingAddressInfo = billingAddressInfo;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountNumber));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.billingAddressInfo));

        return map;
    }
}
