package com.salenko.test.csc;

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
public class CSCRequestTest {
    private String cscCode;
    private String expectedCscResponseCodeString;
    private SaleRequest saleRequest;

    public CSCRequestTest(String cscCode, String expectedCscResponseCode) {
        this.cscCode = cscCode;
        this.expectedCscResponseCodeString = "cscResponseCode=" + expectedCscResponseCode;
        this.saleRequest = new SaleRequest(
                new AuthInfo("sale", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R", this.cscCode), new TransactionInfo(5000, "RE"),
                new AccountNumber("John Smith", "4111111111111111", "0422"));
    }

    @Test(timeout = 5000)
    public void testCSCRequest() {
        try {
            String REQUEST_URL = this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);

            assertTrue("Expect " + expectedCscResponseCodeString, response.contains(expectedCscResponseCodeString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] { { "111", "M" }, { "222", "N" } });
    }
}
