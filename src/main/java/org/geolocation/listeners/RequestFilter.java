package org.geolocation.listeners;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.geolocation.helpers.NullObjectHelper.isNotNullAndNotBlank;

public class RequestFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Response filter(FilterableRequestSpecification fRequestSpec,
                           FilterableResponseSpecification fResponseSpec,
                           FilterContext filterContext) {

        Response response = filterContext.next(fRequestSpec, fResponseSpec);
        log.info("\n---Request---\nMethod: {}\nURI: {}\nHeaders: {} \nRequestParams: {}\nBody: {}",
                fRequestSpec.getMethod(), fRequestSpec.getURI(), fRequestSpec.getHeaders(),
                fRequestSpec.getRequestParams(), isNotNullAndNotBlank(fRequestSpec.getBody()) ? fRequestSpec.getBody().toString() : "");

        log.info("\n---Response---\nStatusCode: {}\nStatusLine: {}\nTime: {}\nHeaders: {}\nBody: {}",
                response.getStatusCode(), response.getStatusLine(), response.getTime(), response.getHeaders(),
                isNotNullAndNotBlank(response.getBody()) ?
                        (response.getBody().asByteArray().length > 10000000) ?
                                "response body is too long (more than 10mb)" : response.getBody().asString() : "");
        return response;
    }
}
