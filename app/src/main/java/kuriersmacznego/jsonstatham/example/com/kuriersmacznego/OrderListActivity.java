package kuriersmacznego.jsonstatham.example.com.kuriersmacznego;

import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Address_;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Dish;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Order;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Client;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Address;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Restaurant;

import android.app.Activity;
import android.content.RestrictionEntry;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends Activity {

    private List<Order> orders;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order_list);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeOrders();
        initializeAdapter();

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(orders);
        rv.setAdapter(adapter);
    }

    private void initializeOrders() {
        orders = new ArrayList<>();
        List<Dish> dishes = new ArrayList<>();
        dishes.add(initializeDish("url", "pierogi", 2));
        orders.add(initializeOrder(
                "tea.who.you.yeah.bunny",
                dishes,
                initializeClient("url", 1, "Jan", "Kowalski", "123456789", initializeAddress("url", 1,"Wrocław", "Sienkiewicza", "32", "23")),
                initializeRestaurant("url", initializeAddress_("url", 2,"Wrocław", "Bycza", "13", "2"), "PizzaStation")));

        orders.add(initializeOrder(
                "tea.who.you.yeah.bunny",
                dishes,
                initializeClient("url", 2, "Jan", "Kowalski", "123456789", initializeAddress("url", 1,"Wrocław", "Sienkiewicza", "32", "23")),
                initializeRestaurant("url", initializeAddress_("url", 2,"Wrocław", "Bycza", "13", "2"), "PizzaStation")));

        orders.add(initializeOrder(
                "tea.who.you.yeah.bunny",
                dishes,
                initializeClient("url", 2, "Jan", "Kowalski", "123456789", initializeAddress("url", 1,"Wrocław", "Sienkiewicza", "32", "23")),
                initializeRestaurant("url", initializeAddress_("url", 2,"Wrocław", "Bycza", "13", "2"), "PizzaStation")));
    }

    private Address initializeAddress(String url, Integer id, String city, String street, String addressNum, String doorNum) {
        Address address = new Address();
        address.setUrl(url);
        address.setId(id);
        address.setCity(city);
        address.setStreet(street);
        address.setAddressNum(addressNum);
        address.setDoorNum(doorNum);

        return address;
    }

    private Address_ initializeAddress_(String url, Integer id, String city, String street, String addressNum, String doorNum) {
        Address_ address = new Address_();
        address.setUrl(url);
        address.setId(id);
        address.setCity(city);
        address.setStreet(street);
        address.setAddressNum(addressNum);
        address.setDoorNum(doorNum);

        return address;
    }

    private Client initializeClient(String url, Integer id, String firstName, String lastName, String phoneNumber, Address address) {
        Client client = new Client();
        client.setUrl(url);
        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setPhoneNumber(phoneNumber);
        client.setAddress(address);

        return client;
    }

    private Order initializeOrder(String url, List<Dish> dishes, Client client, Restaurant restaurant) {
        Order order = new Order();
        order.setUrl(url);
        order.setDishes(dishes);
        order.setClient(client);
        order.setRestaurant(restaurant);

        return order;
    }

    private Dish initializeDish(String url, String name, Integer quantity) {
        Dish dish = new Dish();
        dish.setUrl(url);
        dish.setName(name);
        dish.setQuantity(quantity);

        return dish;
    }

    private Restaurant initializeRestaurant(String url, Address_ address, String name) {
        Restaurant restaurant = new Restaurant();
        restaurant.setUrl(url);
        restaurant.setAddress(address);
        restaurant.setName(name);

        return restaurant;
    }
}