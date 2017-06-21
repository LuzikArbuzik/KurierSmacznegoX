package kuriersmacznego.jsonstatham.example.com.kuriersmacznego;

import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.courier.CourierLocation;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Orders;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Result;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.remote.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView txtLokalizacja;
    Button btnWyslijWspolrzedne;
    Button btnPokazZamowienia;
    boolean zalogowano = false;
    private Orders orders;
    private CourierLocation courierLocation;
    APIService apiService;
    RetrofitClient retrofitClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLokalizacja = (TextView) findViewById(R.id.txtLokalizacja);
        btnWyslijWspolrzedne = (Button) findViewById(R.id.btnWyslijWspolrzedne);
        btnPokazZamowienia = (Button) findViewById(R.id.btnPokazZamowienia);
        btnPokazZamowienia.setVisibility(View.INVISIBLE);

        btnWyslijWspolrzedne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zalogujDoSerwera();
            }
        });
        btnPokazZamowienia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wyswietlZamowienia();
            }
        });
    }

    private void zalogujDoSerwera() {
        zalogowano = true;
        btnPokazZamowienia.setVisibility(View.VISIBLE);
    }

    private void wyswietlZamowienia() {
        initializeLocation();
    }

    private void initializeLocation() {
        String locationString = getJSONString(getApplicationContext());
        Gson gson = new GsonBuilder().create();
        courierLocation = gson.fromJson(locationString, CourierLocation.class);
        makeRetrofit();


    }

    private void makeRetrofit() {
        apiService = retrofitClient.getClient(RetrofitClient.MULE_LOCATION_URL);
        final Call<Orders> orderCall = apiService.sendLocation(courierLocation);
        orderCall.enqueue(new Callback<Orders>() {
            @Override
            public void onResponse(Call<Orders> call, Response<Orders> response) {
                orders = response.body();
                List<Result> listOfResults = orders.getResults();
                if(listOfResults==null){
                    Toast.makeText(getApplicationContext(),"Lista zleceń jest pusta",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Połączono",Toast.LENGTH_LONG).show();
                    startIntentOrderListActivity();
                }
            }
            @Override
            public void onFailure(Call<Orders> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Nie udało się połączyć z serwerem",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void startIntentOrderListActivity() {
        Intent intentOrderListActivity = new Intent(getApplicationContext(), OrderListActivity.class);
        Gson gson = new Gson();
        intentOrderListActivity.putExtra("Orders", gson.toJson(orders));
        startActivity(intentOrderListActivity);
    }

    private String getJSONString(Context context) {
        String str = "";
        try {
            AssetManager assetManager = context.getAssets();
            InputStream in = assetManager.open("location.json");
            InputStreamReader isr = new InputStreamReader(in);
            char[] inputBuffer = new char[100];

            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return str;
    }
}