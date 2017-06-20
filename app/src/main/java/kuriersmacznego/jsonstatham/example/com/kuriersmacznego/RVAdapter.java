package kuriersmacznego.jsonstatham.example.com.kuriersmacznego;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Orders;

//https://code.tutsplus.com/tutorials/getting-started-with-recyclerview-and-cardview-on-android--cms-23465

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.OrderViewHolder> {

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        
        CardView cv;
        TextView restaurantAddress;
        TextView clientAddress;
        ImageView personPhoto;
        

        OrderViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            restaurantAddress = (TextView)itemView.findViewById(R.id.restaurant_address);
            clientAddress = (TextView)itemView.findViewById(R.id.client_address);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

    Orders newOrders;

    RVAdapter(Orders newOrders){
        this.newOrders = newOrders;
    }
    
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        OrderViewHolder ovh = new OrderViewHolder(v);
        return ovh;
    }

    @Override
    public void onBindViewHolder(OrderViewHolder personViewHolder, int i) {
        personViewHolder.restaurantAddress.setText(newOrders.getResults().get(i).getRestaurant().getName() +
                " " + newOrders.getResults().get(i).getRestaurant().getAddress().getCity() +
                " " + newOrders.getResults().get(i).getRestaurant().getAddress().getStreet() +
                " " + newOrders.getResults().get(i).getRestaurant().getAddress().getAddressNum() +
                "/" + newOrders.getResults().get(i).getRestaurant().getAddress().getDoorNum());
        personViewHolder.clientAddress.setText(newOrders.getResults().get(i).getClient().getFirstName() +
                " " + newOrders.getResults().get(i).getClient().getLastName() +
                " " + newOrders.getResults().get(i).getClient().getAddress().getCity() +
                " " + newOrders.getResults().get(i).getClient().getAddress().getStreet() +
                " " + newOrders.getResults().get(i).getClient().getAddress().getAddressNum() +
                "/" + newOrders.getResults().get(i).getClient().getAddress().getDoorNum());
        //personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return newOrders.getCount();
    }
}