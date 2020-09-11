package entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Area {

    private Integer id;
    private String latitude;
    private String longitude;
    private final String country = "中国";
    private String city;
    private String district;
    private String province;
    private String township;
    private String street;
    private String myArea;

    public Integer getId() {
        return id;
    }

    public Area setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public Area setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public Area setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Area setCity(String city) {
        this.city = city;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public Area setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public Area setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getTownship() {
        return township;
    }

    public Area setTownship(String township) {
        this.township = township;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Area setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getMyArea() {
        return myArea;
    }

    public Area setMyArea(String myArea) {
        this.myArea = myArea;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Area)) return false;

        Area area = (Area) o;

        return new EqualsBuilder()
                .append(getId(), area.getId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .toHashCode();
    }
}
