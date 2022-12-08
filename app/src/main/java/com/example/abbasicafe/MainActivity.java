package com.example.abbasicafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_1, btn_2, btn_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.FRAMELAYOUT, new Menu()).commit();

        btn_1 = findViewById(R.id.BUTTON_1);
        btn_2 = findViewById(R.id.BUTTON_2);
        btn_3 = findViewById(R.id.BUTTON_3);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.FRAMELAYOUT, new Menu()).commit();
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.FRAMELAYOUT, new Cart_Menu()).commit();
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.FRAMELAYOUT, new Payment_Method()).commit();
            }
        });
    }
}