package geolocation;

import io.restassured.http.ContentType;
import org.geolocation.api.Request;
import org.geolocation.api.RequestModel;
import org.geolocation.api.RequestWithPathParam;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BaseTest {

    protected void contractTest(Request request,
                                RequestModel rm,
                                int statusCode,
                                ContentType type,
                                String pathToJsonSchema) {
        request.send(rm)
                .then()
                .statusCode(statusCode)
                .contentType(type)
                .body(matchesJsonSchemaInClasspath(pathToJsonSchema));
    }

    protected void contractTest(RequestWithPathParam request,
                                Object pathParam,
                                RequestModel rm,
                                int statusCode,
                                ContentType type,
                                String pathToJsonSchema) {
        request.send(pathParam, rm)
                .then()
                .statusCode(statusCode)
                .contentType(type)
                .body(matchesJsonSchemaInClasspath(pathToJsonSchema));
    }
}
