package kuriersmacznego.jsonstatham.example.com.kuriersmacznego;

import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Orders;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.remote.*;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    TextView txtLokalizacja;
    Button btnWyslijWspolrzedne;
    Button btnPokazZamowienia;
    boolean zalogowano = false;

    private Orders orders;

    private APIService mAPIService;

    private static final String CLASS_TAG = "MainActivity";

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

        // Trigger do wysłania zapytania
        //mAPIService = ApiUtils.getAPIService();
    }

    private void wyswietlZamowienia() {
        Intent intentOrderListActivity = new Intent(getApplicationContext(), OrderListActivity.class);
        initializeOrders();

        // https://stackoverflow.com/questions/21761438/how-to-pass-gson-serialised-object-to-intent-in-android
        Gson gson = new Gson();
        intentOrderListActivity.putExtra("Orders", gson.toJson(orders));
        startActivity(intentOrderListActivity);
    }

    private void initializeOrders() {
        // ToDO: Tutaj wjedzie zapytanie JSONowe.

        // poki co pobieramy z pliku json
        String ordersString = getJSONString(getApplicationContext());
        Gson gson = new GsonBuilder().create();
        orders = gson.fromJson(ordersString, Orders.class);
    }

    private String getJSONString(Context context) {
        String str = "";
        try {
            AssetManager assetManager = context.getAssets();
            InputStream in = assetManager.open("example_orders.json");
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