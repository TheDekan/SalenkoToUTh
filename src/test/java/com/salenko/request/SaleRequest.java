package com.salenko.request;

import com.salenko.model.AuthInfo;
import com.salenko.model.TransactionInfo;
import com.salenko.model.account.AccountInfo;

import java.util.Map;
import java.util.Objects;

public abstract class SaleRequest {
    protected AuthInfo authInfo;
    protected AccountInfo accountInfo;
    protected TransactionInfo transactionInfo;

    public SaleRequest(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo) {
        this.authInfo = authInfo;
        this.accountInfo = accountInfo;
        this.transactionInfo = transactionInfo;
    }

    // Convert obj to K-V map
    public abstract Map toMap() throws IllegalAccessException;

    public String toGetParamsString() throws IllegalAccessException {
        StringBuilder paramsStr = new StringBuilder();
        Map<Object, Object> map = this.toMap();

        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            paramsStr.append(entry.getKey() + "=" + entry.getValue() + "&");
        }

        // remove last "&"
        if (paramsStr.length() > 0)
            paramsStr.setLength(paramsStr.length() - 1);

        return paramsStr.toString().replace(" ", "__");
    }
}
