package org.geolocation.api;

import io.restassured.response.Response;

public interface RequestWithPathParam extends Request {

    Response send(Object pathParam, RequestModel rm);
}
