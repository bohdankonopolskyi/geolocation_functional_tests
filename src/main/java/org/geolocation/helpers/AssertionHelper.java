package org.geolocation.helpers;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static org.geolocation.helpers.NullObjectHelper.isNotNullAndNotBlank;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionHelper {

    public static void assertStatusCodeAndContentType(Response r) {
        assertStatusCodeAndContentType(r, HttpStatus.SC_OK, "application/json; charset=utf-8");
    }

    public static void assertStatusCodeAndContentType(Response r, int code, String type) {
        assertEquals(r.statusCode(), code, "status code");
        assertEquals(r.contentType(), type, "content type");
    }

    public static void assertStatusCodeAndStatusInBody(Response response, String status) {
        assertStatusCodeAndContentType(response);
        assertTrue(isNotNullAndNotBlank(response.jsonPath().get("status")), "status field is not present");
        assertEquals(response.jsonPath().getString("status"), status, "status");
    }
}
