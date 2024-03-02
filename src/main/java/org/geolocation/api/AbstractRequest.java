package org.geolocation.api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.authentication.NoAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.geolocation.api.endpoints.Endpoint;
import org.geolocation.config.ConfigContainer;
import org.geolocation.listeners.RequestFilter;

public abstract class AbstractRequest implements Request {

    private final Endpoint endpoint;
    private final String baseUrl;
    private final RequestSpecification requestSpecification;

    public AbstractRequest(Endpoint endpoint, String baseUrl, RequestSpecification requestSpecification) {
        RestAssured.urlEncodingEnabled = false;

        this.endpoint = endpoint;
        this.baseUrl = baseUrl;
        this.requestSpecification = requestSpecification;
    }

    public AbstractRequest(Endpoint endpoint, String baseUrl) {

        this(endpoint, baseUrl,
                new RequestSpecBuilder()
                        .addFilter(new RequestFilter())
                        .setAuth(new NoAuthScheme())
                        .setContentType(ContentType.JSON)
                        .setAccept(ContentType.JSON)
                        .build());
    }

    public AbstractRequest(Endpoint endpoint) {
        this(endpoint, ConfigContainer.getConfig().getIpApiUrl());
    }

    @Step(value = "Send request")
    public Response send(RequestModel rm) {
        return given()
                .body(rm)
                .post();
    }

    public RequestSpecification given() {
        return RestAssured.given()
                .spec(requestSpecification)
                .baseUri(baseUrl)
                .basePath(endpoint.getVal());
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }
}
