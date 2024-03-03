package org.geolocation.api.endpoints;

public enum EndpointGeolocation implements Endpoint {
    GEOLOCATION_JSON("/json/{query}");

    private final String val;

    EndpointGeolocation(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "EndpointGeolocation{" +
                "val='" + val + '\'' +
                '}';
    }
}
