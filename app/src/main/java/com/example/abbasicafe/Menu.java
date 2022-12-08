package com.example.abbasicafe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Menu extends Fragment {

    ArrayList<Menu_Data> arrayList = new ArrayList<>();
    RecyclerView recyclerView;

    public Menu()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        arrayList.add(new Menu_Data(R.drawable.brownpan, "Brown Pan Cake", "150" ,"Pan cake with chocolate texture"));
        arrayList.add(new Menu_Data(R.drawable.browny, "Brownie", "70" ,"Deep chocolate dipped cake piece"));
        arrayList.add(new Menu_Data(R.drawable.cherrypan, "Cherry Pan Cake", "220" ,"Pan cake with caramel and berries"));
        arrayList.add(new Menu_Data(R.drawable.cherrypie, "Cherry Pie", "120" ,"Red Cherry Pie with Detailed texture"));
        arrayList.add(new Menu_Data(R.drawable.choclatechipscake, "Chocolate Chips Cake", "180" ,"Plane cake with chocolate bits"));
        arrayList.add(new Menu_Data(R.drawable.choclateicecreamshake, "Chocolate Icecream Shake", "180" ,"Chocolate Flavoured Icecream and Fresh Milk"));
        arrayList.add(new Menu_Data(R.drawable.choclateshake, "Chocolate Shake", "150" ,"Chocolate and Fresh Milk"));
        arrayList.add(new Menu_Data(R.drawable.chocobread, "Chocolate Bread", "120" ,"Bread rich with chocolate inside"));
        arrayList.add(new Menu_Data(R.drawable.chocopastery, "Chocolate Pastery", "100" ,"Chocolate textured cake piece"));
        arrayList.add(new Menu_Data(R.drawable.cofee, "Cofee", "80" ,"Simple Coffee"));
        arrayList.add(new Menu_Data(R.drawable.creampety, "Creampety", "70" ,"Vanilla cream stuffed bread"));
        arrayList.add(new Menu_Data(R.drawable.creamrols, "Cream Rolls", "220" ,"Strawberry flavoured Cream stuffed rolls"));
        arrayList.add(new Menu_Data(R.drawable.donuts, "Donuts", "70" ,"Fresh Dough with creamy topping"));
        arrayList.add(new Menu_Data(R.drawable.mufin, "Muffins", "50" ,"Soft creamy cake"));
        arrayList.add(new Menu_Data(R.drawable.strawberryicecreamshake, "Strawberry Icecream Shake", "180" ,"Strawberry Flavoured Icecream and Fresh Milk"));
        arrayList.add(new Menu_Data(R.drawable.strawberryshake, "StrawBerry Shake", "130" ,"Strawberry with Fresh Milk"));
        arrayList.add(new Menu_Data(R.drawable.sweetsandwich, "Sweet Sandwich", "220" ,"Fresh bread with sweet berries"));
        arrayList.add(new Menu_Data(R.drawable.tea, "Tea", "50" ,"Simple Tea"));
        arrayList.add(new Menu_Data(R.drawable.vanilacupcake, "Vanilla Cupcake", "70" ,"Vanilla Creamy cup cake"));
        arrayList.add(new Menu_Data(R.drawable.waffels, "Waffels", "150" ,"Fresh Baked Cake with berries"));

        Menu_Adapter adapter = new Menu_Adapter(arrayList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}