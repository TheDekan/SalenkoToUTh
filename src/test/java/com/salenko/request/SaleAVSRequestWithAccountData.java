package com.salenko.request;

import com.salenko.model.AuthInfo;
import com.salenko.model.BillingAddressInfo;
import com.salenko.model.TransactionInfo;
import com.salenko.model.account.AccountData;
import com.salenko.model.account.AccountInfo;
import com.salenko.utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

//Sale request for account verification with account data
public class SaleAVSRequestWithAccountData extends SaleRequestWithAccountData {
    private BillingAddressInfo billingAddressInfo;

    public SaleAVSRequestWithAccountData(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo,
            AccountData accountData, BillingAddressInfo billingAddressInfo) {
        super(authInfo, accountInfo, transactionInfo, accountData);
        this.billingAddressInfo = billingAddressInfo;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountData));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.billingAddressInfo));

        return map;
    }
}
