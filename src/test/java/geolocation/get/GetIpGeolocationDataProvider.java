package geolocation.get;

import geolocation.BaseDataProvider;
import org.geolocation.data.collectors.QueryDataCollector;
import org.testng.annotations.DataProvider;

public class GetIpGeolocationDataProvider extends BaseDataProvider {

    @DataProvider(name = "ntpOrgValidQueries")
    public static Object[][] ntpOrgValidQueries() {
        return getCollectionForDataProvider(QueryDataCollector.getInstance().getQueryList());
    }

    @DataProvider(name = "ntpOrgInvalidQueries")
    public static Object[][] ntpOrgInvalidQueries() {
        return getCollectionForDataProvider(QueryDataCollector.getInstance().getInvalidQueryList());
    }
}
