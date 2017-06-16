package kuriersmacznego.jsonstatham.example.com.kuriersmacznego;

import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.remote.*;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    TextView txtLokalizacja;
    Button btnWyslijWspolrzedne;
    Button btnPokazZamowienia;
    boolean zalogowano = false;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private APIService mAPIService;

    private static final String CLASS_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLokalizacja = (TextView)findViewById(R.id.txtLokalizacja);
        btnWyslijWspolrzedne = (Button)findViewById(R.id.btnWyslijWspolrzedne);
        btnPokazZamowienia = (Button)findViewById(R.id.btnPokazZamowienia);
        btnPokazZamowienia.setVisibility(View.INVISIBLE);

        btnWyslijWspolrzedne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zalogojDoSerwera();
            }
        });
        btnPokazZamowienia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wyswietlZamowienia();
            }
        });

        sharedPreferences = getSharedPreferences("sharedData", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private void zalogojDoSerwera() {
        zalogowano = true;
        btnPokazZamowienia.setVisibility(View.VISIBLE);

        // Trigger do wysłania zapytania
        //mAPIService = ApiUtils.getAPIService();
    }

    private void wyswietlZamowienia() {
        Intent intentOrderListActivity = new Intent(getApplicationContext(), OrderListActivity.class);
        startActivity(intentOrderListActivity);
    }
}
