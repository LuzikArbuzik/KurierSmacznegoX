package kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("address_num")
    @Expose
    private String addressNum;
    @SerializedName("door_num")
    @Expose
    private String doorNum;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(String addressNum) {
        this.addressNum = addressNum;
    }

    public String getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(String doorNum) {
        this.doorNum = doorNum;
    }

    @Override
    public String toString() {
        return "Adres: " + street + addressNum + '/' + doorNum;
    }
}
