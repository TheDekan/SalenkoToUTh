package com.salenko.request;

import com.salenko.model.AuthInfo;
import com.salenko.model.TransactionInfo;
import com.salenko.model.account.AccountData;
import com.salenko.model.account.AccountInfo;
import com.salenko.utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

//Sale request with account data
public class SaleRequestWithAccountData extends SaleRequest {
    protected AccountData accountData;

    public SaleRequestWithAccountData(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo,
            AccountData accountData) {
        super(authInfo, accountInfo, transactionInfo);
        this.accountData = accountData;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountData));

        return map;
    }
}
