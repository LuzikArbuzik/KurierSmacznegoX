package kuriersmacznego.jsonstatham.example.com.kuriersmacznego;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.orders.Order;

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

    List<Order> orders;

    RVAdapter(List<Order> orders){

        this.orders = orders;
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
        personViewHolder.restaurantAddress.setText(orders.get(i).getRestaurant().getName() +
                " " + orders.get(i).getRestaurant().getAddress().getCity() +
                " " + orders.get(i).getRestaurant().getAddress().getStreet() +
                " " + orders.get(i).getRestaurant().getAddress().getAddressNum() +
                "/" + orders.get(i).getRestaurant().getAddress().getDoorNum());
        personViewHolder.clientAddress.setText(orders.get(i).getClient().getFirstName() +
                " " + orders.get(i).getClient().getLastName() +
                " " + orders.get(i).getClient().getAddress().getCity() +
                " " + orders.get(i).getClient().getAddress().getStreet() +
                " " + orders.get(i).getClient().getAddress().getAddressNum() +
                "/" + orders.get(i).getClient().getAddress().getDoorNum());
        //personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}