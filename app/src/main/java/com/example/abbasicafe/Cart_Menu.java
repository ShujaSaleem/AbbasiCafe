package com.example.abbasicafe;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Cart_Menu extends Fragment {

    public static ArrayList<Cart_Data> arrayList = new ArrayList<>();
    RecyclerView recyclerView;
    public static String name, price;
    public static String [] Name = new String[10];
    public static String [] Price = new String[10];
    public static String [] Quantity = new String[10];
    public static int Index;
    public static boolean flag = false, full = false, Exists = false;

    public Cart_Menu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_cart__menu, container, false);
        recyclerView = view.findViewById(R.id.RV2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Index = SplashScreen.index;
        Name = SplashScreen.Item_Names;
        Price = SplashScreen.Item_Prices;
        Quantity = SplashScreen.Item_Quantities;

        if(Index == 0)
        {
            if(Name[Index].equals("Default Name"))
            {
                Toast.makeText(getContext(), "Cart is Empty", Toast.LENGTH_SHORT).show();
            }
            else
            {
                arrayList.add(new Cart_Data(Name[Index], Price[Index], Quantity[Index]));
            }
        }
        else
        {
            arrayList.removeAll(arrayList);
            if(Index > 9)
            {
                Index = 9;
            }

            for(int i=0; i<Index; i++)
            {
                arrayList.add(new Cart_Data(Name[i], Price[i], Quantity[i]));
            }
        }

        Cart_Adapter adapter = new Cart_Adapter(arrayList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public static void add_to_cart()
    {
        for(int i=0; i<Index; i++)
        {
            if(Name[i].equals(name))
            {
                flag = false;
                Exists = true;
            }
        }

        if(Exists == false)
        {
            for(int i=0; i<=Index; i++)
            {
                arrayList.add(new Cart_Data(Name[i], Price[i], Quantity[i]));
            }
            SplashScreen.setvalues();
        }
    }

    public static void getvalues(String N, String P)
    {
        name = N;
        price = P;
        flag = true;
        Index = SplashScreen.index;
        Name = SplashScreen.Item_Names;
        Price = SplashScreen.Item_Prices;
        Quantity = SplashScreen.Item_Quantities;
        Name[Index] = name;
        Price[Index] = price;
        Exists = false;

        if(Index == 0)
        {
            arrayList.add(new Cart_Data(Name[Index], Price[Index], Quantity[Index]));
            SplashScreen.setvalues();
        }
        else
        {
            if(Index < 10)
            {
                add_to_cart();
            }
        }
    }
}