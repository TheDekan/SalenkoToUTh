package com.salenko.request;

import com.salenko.model.AuthInfo;
import com.salenko.model.TransactionInfo;
import com.salenko.model.account.AccountInfo;
import com.salenko.model.account.AccountNumber;
import com.salenko.utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

//Sale request with account number
public class SaleRequestWithAccountNumber extends SaleRequest {
    protected AccountNumber accountNumber;

    public SaleRequestWithAccountNumber(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo,
            AccountNumber accountNumber) {
        super(authInfo, accountInfo, transactionInfo);
        this.accountNumber = accountNumber;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountNumber));

        return map;
    }
}
