package kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.remote;

import java.util.List;

import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.courier.CourierLocation;

import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Order;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Orders;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("location/")
    Call<Orders> sendLocation(@Body CourierLocation cl);
    // Call<List<Order>> sendLocation(@Body CourierLocation cl);

    @GET("testLocation/")
    Call<Orders> getOrders();

}

