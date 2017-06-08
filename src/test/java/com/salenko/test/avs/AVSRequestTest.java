package com.salenko.test.avs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.salenko.request.SaleAVSRequestWithAccountNumber;
import com.salenko.request.SaleRequest;
import com.salenko.model.AuthInfo;
import com.salenko.model.BillingAddressInfo;
import com.salenko.model.TransactionInfo;
import com.salenko.model.account.AccountInfo;
import com.salenko.model.account.AccountNumber;
import com.salenko.utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AVSRequestTest {
    private String zipCode;
    private String expectedAvsResponseCodeString;
    private SaleRequest saleRequest;

    public AVSRequestTest(String zipCode, String expectedAvsResponseCode) {
        this.zipCode = zipCode;
        this.expectedAvsResponseCodeString = "avsResponseCode=" + expectedAvsResponseCode;
        this.saleRequest = new SaleRequest(
                new AuthInfo("account-verification", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R"),
                new TransactionInfo(5000, "RE"),
                new AccountNumber("John Smith", "4111111111111111", "0422"),
                new BillingAddressInfo(this.zipCode)
        );
    }

    @Test(timeout = 5000)
    public void testCreateTestDataSuite() {
        try {
            String REQUEST_URL = this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);

            assertTrue("Expect " + expectedAvsResponseCodeString, response.contains(expectedAvsResponseCodeString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{ {"11111", "00"}, { "22222", "46" } });
    }
}
