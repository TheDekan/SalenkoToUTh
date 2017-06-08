package com.salenko.test.rc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.salenko.request.SaleRequest;
import com.salenko.request.SaleRequestWithAccountNumber;
import com.salenko.model.AuthInfo;
import com.salenko.model.TransactionInfo;
import com.salenko.model.account.AccountInfo;
import com.salenko.model.account.AccountNumber;
import com.salenko.utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ResponseCodeRequestTest {
    private int amount;
    private String expectedResponseCodeString;
    private SaleRequest saleRequest;

    public ResponseCodeRequestTest(int amount, String expectedResponseCode) {
        this.amount = amount;
        this.expectedResponseCodeString = "responseCode=" + expectedResponseCode;
        this.saleRequest = new SaleRequest(
                new AuthInfo("sale", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"), new AccountInfo("R"),
                new TransactionInfo(this.amount, "RE"), new AccountNumber("John Smith", "4111111111111111", "0422"));
    }

    @Test(timeout = 5000)
    public void testResponseCode() {
        try {
            String REQUEST_URL = this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);

            assertTrue("Expect " + expectedResponseCodeString, response.contains(expectedResponseCodeString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] { { 500, "A01" }, { 12000, "D03" }, });
    }
}
