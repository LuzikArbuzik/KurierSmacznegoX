package kuriersmacznego.jsonstatham.example.com.kuriersmacznego;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;
import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Result;

public class OrderActivity extends AppCompatActivity {

    private Result result;
    private TextView restaurantInfoTextView;
    private TextView clientInfoTextView;
    private Button receivedButton;
    private Button deliveredButton;

    private double lon;
    private double lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        loadResult();
        restaurantInfoTextView = (TextView) findViewById(R.id.restaurantInfo);
        clientInfoTextView = (TextView) findViewById(R.id.clientInfo);
        restaurantInfoTextView.setText(result.getRestaurant().toString()+"\n"+result.getDishes().toString());
        clientInfoTextView.setText(result.getClient().toString());
    }

    private void loadResult() {
        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("Result");
        result = gson.fromJson(strObj, Result.class);
    }

    public void onClickReceived(View view){
        receivedButton = (Button) findViewById(R.id.received);
        receivedButton.setBackgroundColor(getResources().getColor(R.color.greenColorButton));
        //TODO Tutaj zrobić put do servera
    }

    public void onClickDelivered(View view){
        deliveredButton = (Button) findViewById(R.id.delivered);
        deliveredButton.setBackgroundColor(getResources().getColor(R.color.greenColorButton));
        //TODO Tutaj zrobić put do servera
    }

    public void onClickGoToMapRestaurant(View view){
        lat = result.getRestaurant().getAddress().getLat();
        lon = result.getRestaurant().getAddress().getLon();
        goToMapIntent(lat,lon);
    }

    public void onClickGoToMapClient(View view){
        lat = result.getClient().getAddress().getLat();
        lon = result.getClient().getAddress().getLon();
        goToMapIntent(lat,lon);
    }

    public void goToMapIntent(double lat, double lon){
        //TODO dać lat i lon zamiast danych niżej
        Uri gmmIntentUri = Uri.parse("http://maps.google.com/maps?daddr="+lat+","+lon);
        Intent mapInent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapInent.setPackage("com.google.android.apps.maps");
        if(mapInent.resolveActivity(getPackageManager())!= null){
            startActivity(mapInent);
        }
    }
}
