package com.example.abbasicafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.ViewHolder> {

    ArrayList<Cart_Data> arrayList;
    int Q, P, I,i,v;

    public Cart_Adapter(ArrayList<Cart_Data> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).itemname);
        holder.price.setText(arrayList.get(position).itemprice);
        holder.quantity.setText(arrayList.get(position).quantity);
        holder.total.setText(String.valueOf(Integer.parseInt(arrayList.get(position).itemprice)*Integer.parseInt(arrayList.get(position).quantity)));

        P = Integer.parseInt(arrayList.get(position).itemprice);

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SplashScreen.index > 9)
                {
                    SplashScreen.index = 9;
                }
                if(SplashScreen.index > 1)
                {
                    for(i=0; i<SplashScreen.index; i++)
                    {
                        if(i == position)
                        {
                            for(v=i; v<SplashScreen.index; v++)
                            {
                                SplashScreen.Item_Names[v] = SplashScreen.Item_Names[v+1];
                                SplashScreen.Item_Prices[v] = SplashScreen.Item_Prices[v+1];
                                SplashScreen.Item_Quantities[v] = SplashScreen.Item_Quantities[v+1];
                            }
                            i=v;
                        }
                    }
                    SplashScreen.index--;
                }
                else
                {
                    Cart_Menu.arrayList.removeAll(Cart_Menu.arrayList);
                    SplashScreen.Item_Names[0]= "Default Name";
                    SplashScreen.index=0;
                }

            }
        });

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Q = Integer.parseInt(holder.quantity.getText().toString());
                if(Q < 10)
                {
                    Q++;
                }
                holder.quantity.setText(String.valueOf(Q));
                holder.total.setText(String.valueOf(Q*P));
                SplashScreen.Item_Quantities[position] = String.valueOf(Q);
            }
        });

        holder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Q = Integer.parseInt(holder.quantity.getText().toString());
                if(Q > 1)
                {
                    Q--;
                }
                holder.quantity.setText(String.valueOf(Q));
                holder.total.setText(String.valueOf(Q*P));
                SplashScreen.Item_Quantities[position] = String.valueOf(Q);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button add, sub, remove;
        TextView name, price, quantity, total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.itemname);
            price = itemView.findViewById(R.id.itemprice);
            quantity = itemView.findViewById(R.id.quantity_text);
            total = itemView.findViewById(R.id.totalprice);
            add = itemView.findViewById(R.id.add_quantity);
            sub = itemView.findViewById(R.id.sub_quantity);
            remove = itemView.findViewById(R.id.remove_from_cart);
        }
    }
}
