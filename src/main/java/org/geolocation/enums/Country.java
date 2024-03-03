package org.geolocation.enums;

public enum Country {

    UKRAINE("Ukraine", "UA"),
    CANADA("Canada", "CA");

    private final String name;
    private final String code;

    Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
