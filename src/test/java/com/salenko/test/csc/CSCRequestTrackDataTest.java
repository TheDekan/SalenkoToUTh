package com.salenko.test.csc;

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
public class CSCRequestTrackDataTest {
    private String cscCode;
    private String expectedCscResponseCodeString;
    private SaleRequest saleRequest;

    public CSCRequestTrackDataTest(String cscCode, String expectedCscResponseCode) {
        this.cscCode = cscCode;
        this.expectedCscResponseCodeString = "cscResponseCode=" + expectedCscResponseCode;
        this.saleRequest = new SaleRequestWithAccountData(
                new AuthInfo("sale", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R", this.cscCode), new TransactionInfo(5000, "RE"),
                new AccountData("%25B4111111111111111%5ESMITH%2FJOHN%5E22041011000%201111A123456789012%3F"));
    }

    @Test(timeout = 5000)
    public void testCSCRequest() {
        try {
            String REQUEST_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?"
                    + this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);

            assertTrue("Expect " + expectedCscResponseCodeString, response.contains(expectedCscResponseCodeString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] { { "333", "P" }, { "444", "S" } });
    }
}
