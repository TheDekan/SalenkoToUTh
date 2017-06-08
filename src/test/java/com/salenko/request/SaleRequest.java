package com.salenko.request;

import com.salenko.model.AuthInfo;
import com.salenko.model.TransactionInfo;
import com.salenko.model.account.AccountInfo;
import com.salenko.utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SaleRequest {
    protected String connectionUrl = "https://sandbox-secure.unitedthinkers.com/gates/xurl?";
    protected Map<Object, Object> map = new HashMap<Object, Object>();

    public SaleRequest(Object... args) throws IllegalAccessException {
        for (Object arg : args) {
            this.map.putAll(ObjToMapConverter.getKeyValueMap(arg));
        }

    }

    public String toGetParamsString() throws IllegalAccessException {
        StringBuilder paramsStr = new StringBuilder();

        for (Map.Entry<Object, Object> entry : this.map.entrySet()) {
            paramsStr.append(entry.getKey() + "=" + entry.getValue() + "&");
        }

        // remove last "&"
        if (paramsStr.length() > 0)
            paramsStr.setLength(paramsStr.length() - 1);

        return this.connectionUrl + paramsStr.toString().replace(" ", "__");
    }
}
