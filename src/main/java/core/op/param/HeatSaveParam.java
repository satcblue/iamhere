package core.op.param;

import java.util.List;

public class HeatSaveParam implements AutoOpParam {
    private List<String> answers;
    private Integer seq;
    private Float temperature;
    private String userId;
    private String latitude;
    private String longitude;
    private String country;
    private String city;
    private String district;
    private String province;
    private String township;
    private String street;
    private String myArea;

    public List<String> getAnswers() {
        return answers;
    }

    public HeatSaveParam setAnswers(List<String> answers) {
        this.answers = answers;
        return this;
    }

    public Integer getSeq() {
        return seq;
    }

    public HeatSaveParam setSeq(Integer seq) {
        this.seq = seq;
        return this;
    }

    public Float getTemperature() {
        return temperature;
    }

    public HeatSaveParam setTemperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public HeatSaveParam setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public HeatSaveParam setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public HeatSaveParam setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public HeatSaveParam setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public HeatSaveParam setCity(String city) {
        this.city = city;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public HeatSaveParam setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public HeatSaveParam setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getTownship() {
        return township;
    }

    public HeatSaveParam setTownship(String township) {
        this.township = township;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public HeatSaveParam setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getMyArea() {
        return myArea;
    }

    public HeatSaveParam setMyArea(String myArea) {
        this.myArea = myArea;
        return this;
    }
}
