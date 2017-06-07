package kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("dishes")
    @Expose
    private List<Dish> dishes = null;
    @SerializedName("client")
    @Expose
    private Client client;
    @SerializedName("restaurant")
    @Expose
    private Restaurant restaurant;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
