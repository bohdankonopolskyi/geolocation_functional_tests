package org.geolocation.config;

public class Config {

    private final String ipApiUrl;

    private Config(Builder builder) {
        this.ipApiUrl = builder.ipApiUrl;
    }

    public String getIpApiUrl() {
        return ipApiUrl;
    }

    @Override
    public String toString() {
        return "Config{" +
                "ipApiUrl='" + ipApiUrl + '\'' +
                '}';
    }

    public static class Builder {

        private String ipApiUrl;

        public Builder buildIpApiUrl(String ipApiUrl) {
            this.ipApiUrl = ipApiUrl;
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }
}
