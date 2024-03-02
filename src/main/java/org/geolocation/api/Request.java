package org.geolocation.api;

import io.restassured.response.Response;
import org.geolocation.api.endpoints.Endpoint;

public interface Request {

    Response send(RequestModel rm);

    Endpoint getEndpoint();
}
