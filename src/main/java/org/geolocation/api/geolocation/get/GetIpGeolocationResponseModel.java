package org.geolocation.api.geolocation.get;

public class GetIpGeolocationResponseModel {

    private String status;
    private String country;
    private String countryCode;
    private String region;
    private String regionName;
    private String city;
    private String zip;
    private Float lat;
    private Float lon;
    private String timezone;
    private String isp;
    private String org;
    private String as;
    private String query;

    public String getStatus() {
        return status;
    }

    public GetIpGeolocationResponseModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public GetIpGeolocationResponseModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public GetIpGeolocationResponseModel setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public GetIpGeolocationResponseModel setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getRegionName() {
        return regionName;
    }

    public GetIpGeolocationResponseModel setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public GetIpGeolocationResponseModel setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public GetIpGeolocationResponseModel setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public Float getLat() {
        return lat;
    }

    public GetIpGeolocationResponseModel setLat(Float lat) {
        this.lat = lat;
        return this;
    }

    public Float getLon() {
        return lon;
    }

    public GetIpGeolocationResponseModel setLon(Float lon) {
        this.lon = lon;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public GetIpGeolocationResponseModel setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public String getIsp() {
        return isp;
    }

    public GetIpGeolocationResponseModel setIsp(String isp) {
        this.isp = isp;
        return this;
    }

    public String getOrg() {
        return org;
    }

    public GetIpGeolocationResponseModel setOrg(String org) {
        this.org = org;
        return this;
    }

    public String getAs() {
        return as;
    }

    public GetIpGeolocationResponseModel setAs(String as) {
        this.as = as;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public GetIpGeolocationResponseModel setQuery(String query) {
        this.query = query;
        return this;
    }

    @Override
    public String toString() {
        return "GetIpGeolocationResponseModel{" +
                "status='" + status + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", region='" + region + '\'' +
                ", regionName='" + regionName + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", timezone='" + timezone + '\'' +
                ", isp='" + isp + '\'' +
                ", org='" + org + '\'' +
                ", as='" + as + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}