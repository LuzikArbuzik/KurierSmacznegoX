package kuriersmacznego.jsonstatham.example.com.kuriersmacznego;

import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Orders;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;


public class OrderListActivity extends Activity {

    Orders orders;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order_list);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        loadOrders();
        initializeAdapter();

    }

    private void loadOrders() {
        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("Orders");
        orders = gson.fromJson(strObj, Orders.class);
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(orders);
        rv.setAdapter(adapter);
    }
}