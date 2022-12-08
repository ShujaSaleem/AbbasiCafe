package com.example.abbasicafe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Menu_Adapter extends RecyclerView.Adapter<Menu_Adapter.ViewHolder> {

    ArrayList<Menu_Data> arrayList;

    public Menu_Adapter(ArrayList<Menu_Data> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.image.setImageResource(arrayList.get(position).image);
        holder.header.setText(arrayList.get(position).header);
        holder.price.setText(arrayList.get(position).getPrice());
        holder.desc.setText(arrayList.get(position).desc);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SplashScreen.index < 10)
                {
                    Cart_Menu.getvalues(arrayList.get(position).header, arrayList.get(position).price);
                }
                else
                {
                    Toast.makeText(view.getContext(), "Cart is full", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView header, price, desc;
        Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            header = itemView.findViewById(R.id.text_1);
            price = itemView.findViewById(R.id.text_2);
            desc = itemView.findViewById(R.id.text_3);
            btn = itemView.findViewById(R.id.add_to_cart_button);
        }
    }
}
