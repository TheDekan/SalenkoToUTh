package com.salenko.test.rc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.salenko.request.SaleRequest;
import com.salenko.request.SaleRequestWithAccountData;
import com.salenko.model.AuthInfo;
import com.salenko.model.TransactionInfo;
import com.salenko.model.account.AccountData;
import com.salenko.model.account.AccountInfo;
import com.salenko.utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ResponseCodeRequestTrackDataTest {
    private int amount;
    private String expectedResponseCodeString;
    private SaleRequest saleRequest;

    public ResponseCodeRequestTrackDataTest(int amount, String expectedResponseCode) {
        this.amount = amount;
        this.expectedResponseCodeString = "responseCode=" + expectedResponseCode;
        this.saleRequest = new SaleRequest(
                new AuthInfo("sale", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"), new AccountInfo("R"),
                new TransactionInfo(this.amount, "RE"),
                new AccountData("%25B4111111111111111%5ESMITH%2FJOHN%5E22041011000%201111A123456789012%3F"));
    }

    @Test(timeout = 5000)
    public void testCreateTestDataSuite() {
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
        return Arrays.asList(new Object[][] { { 7000, "D05" }, { 13000, "E02" }, });
    }
}
