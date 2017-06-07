package kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("address")
    @Expose
    private Address_ address;
    @SerializedName("name")
    @Expose
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Address_ getAddress() {
        return address;
    }

    public void setAddress(Address_ address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}