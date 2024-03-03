package geolocation.get;

import geolocation.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.geolocation.api.geolocation.get.GetIpGeolocationRequest;
import org.geolocation.api.geolocation.get.GetIpGeolocationResponseModel;
import org.geolocation.data.collectors.QueryDataCollector;
import org.geolocation.enums.Country;
import org.geolocation.helpers.AssertionHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.geolocation.constants.TestGroups.*;

public class GetIpGeolocationTests extends BaseTest {

    @Test(groups = {ALL, GEOLOCATION, CONTRACT, POSITIVE})
    public void getIpGeolocationContractTest() {
        Assert.assertTrue(QueryDataCollector.getInstance().getQueryList().size() != 0, "query empty list");
        contractTest(new GetIpGeolocationRequest(), QueryDataCollector.getInstance().getQueryList().get(0), null,
                HttpStatus.SC_OK, ContentType.JSON,
                "json.schemas/PositiveGetIpGeolocation.json");
    }

    @Test(groups = {ALL, GEOLOCATION, CONTRACT, NEGATIVE})
    public void getIpGeolocationFailTest() {
        Assert.assertTrue(QueryDataCollector.getInstance().getInvalidQueryList().size() != 0, "invalidQuery empty list");
        contractTest(new GetIpGeolocationRequest(), QueryDataCollector.getInstance().getInvalidQueryList().get(0), null,
                HttpStatus.SC_OK, ContentType.JSON,
                "json.schemas/FailGetIpGeolocation.json");
    }

    @Test(groups = {ALL, GEOLOCATION, POSITIVE},
            dataProvider = "ntpOrgValidQueries", dataProviderClass = GetIpGeolocationDataProvider.class)
    public void getUkraineIpGeolocationPositiveFlowTest(String query) {
        Response resp = new GetIpGeolocationRequest().send(query);
        AssertionHelper.assertStatusCodeAndStatusInBody(resp, "success");
        GetIpGeolocationResponseModel responseModel = resp.as(GetIpGeolocationResponseModel.class);

        assertCountryAndCountryCode(responseModel, Country.UKRAINE);
    }

    @Test(groups = {ALL, GEOLOCATION, NEGATIVE},
            dataProvider = "ntpOrgInvalidQueries", dataProviderClass = GetIpGeolocationDataProvider.class)
    public void getIpGeolocationNegativeFlowTest(String query) {
        Response resp = new GetIpGeolocationRequest().send(query);
        AssertionHelper.assertStatusCodeAndStatusInBody(resp, "fail");
    }

    private void assertCountryAndCountryCode(GetIpGeolocationResponseModel responseModel, Country country) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseModel.getCountry(), country.getName(), "country");
        softAssert.assertEquals(responseModel.getCountryCode(), country.getCode(), "country code");
        softAssert.assertAll();
    }
}
