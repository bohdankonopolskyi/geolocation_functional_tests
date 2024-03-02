package org.geolocation.api.geolocation.get;

import io.restassured.response.Response;
import org.geolocation.api.AbstractRequest;
import org.geolocation.api.RequestModel;
import org.geolocation.api.RequestWithPathParam;
import org.geolocation.api.endpoints.EndpointGeolocation;

public class GetIpGeolocationRequest extends AbstractRequest implements RequestWithPathParam {

    public GetIpGeolocationRequest() {
        super(EndpointGeolocation.GEOLOCATION_JSON);
    }

    public Response send(Object pathParam) {
        return send(pathParam, null);
    }

    @Override
    public Response send(Object pathParam, RequestModel rm) {
        return given()
                .pathParam("query", pathParam)
                .get();
    }
}
