package com.example.abbasicafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    public static String [] Item_Names = new String[10];
    public static String [] Item_Prices = new String[10];
    public static String[] Item_Quantities = {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
    public static int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        index = 0;
        Item_Names[0] = "Default Name";
        Item_Prices[0] = "Default Price";

        Intent intent = new Intent(this, MainActivity.class);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    public  static  void setvalues()
    {
        Item_Names = Cart_Menu.Name;
        Item_Prices = Cart_Menu.Price;
        index++;
    }
}