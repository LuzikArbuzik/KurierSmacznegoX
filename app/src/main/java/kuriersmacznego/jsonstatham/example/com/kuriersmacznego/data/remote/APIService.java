package kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.remote;

import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Order;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.courier.CourierLocation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    Call<Order> savePost(@Body CourierLocation cl);
}