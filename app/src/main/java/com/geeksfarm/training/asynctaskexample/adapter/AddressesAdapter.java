package com.geeksfarm.training.asynctaskexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geeksfarm.training.asynctaskexample.R;
import com.geeksfarm.training.asynctaskexample.model.Contact;

import java.util.ArrayList;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {
    Context context;
    ArrayList<Contact.Address> addresses;

    public AddressesAdapter(Context ctx, ArrayList<Contact.Address> data) {
        this.context = ctx;
        this.addresses = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_detail, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.addressName.setText(addresses.get(position).getAddress());
        holder.addressDetail.setText(addresses.get(position).getDetailAddress());
        holder.city.setText(addresses.get(position).getCity());
        holder.postalCode.setText(addresses.get(position).getPostalCode());
    }

    @Override
    public int getItemCount() {
        return addresses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView addressName, addressDetail, city, postalCode;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            addressName = itemView.findViewById(R.id.tv_address_name);
            addressDetail = itemView.findViewById(R.id.tv_address_detail);
            city = itemView.findViewById(R.id.tv_address_city);
            postalCode = itemView.findViewById(R.id.tv_address_postal);
        }
    }
}
