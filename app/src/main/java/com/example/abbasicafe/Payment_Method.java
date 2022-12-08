package com.example.abbasicafe;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.telephony.SmsManager;

public class Payment_Method extends Fragment {

    ToggleButton Toggle_Button;
    Button Confirm_Button;
    TextView IN, IQ, IP, TT;
    EditText Credit_Card, Jazz_Cash;

    String [] Item_N = new String[10];
    String [] Item_P = new String[10];
    String[] Item_Q = new String[10];
    int index, total;
    String input, msg;

    public Payment_Method() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_payment__method, container, false);

        Toggle_Button = view.findViewById(R.id.tb);
        Confirm_Button = view.findViewById(R.id.cb);
        IN = view.findViewById(R.id.in);
        IP = view.findViewById(R.id.ip);
        IQ = view.findViewById(R.id.iq);
        TT = view.findViewById(R.id.tt);
        Credit_Card = view.findViewById(R.id.cc);
        Jazz_Cash = view.findViewById(R.id.jc);

        getvalues();

        if(SplashScreen.Item_Names[0].equals("Default Name"))
        {
            Toast.makeText(getContext(), "Please Select an Item", Toast.LENGTH_SHORT).show();
        }
        else
        {
            setvalues();
        }

        Confirm_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Confirm();
            }
        });

        return view;
    }

    void Confirm()
    {
        if(Toggle_Button.isChecked())
        {
            Credit_Card();
        }
        else
        {
            Jazz_Cash();
        }
    }

    void Credit_Card()
    {
        input = Credit_Card.getText().toString();

        if(input.length() == 19)
        {
            Toast.makeText(getContext(), "Order Placed Successfully", Toast.LENGTH_SHORT).show();
            reset_values();
        }
        else
        {
            Toast.makeText(getContext(), "Invalid Credit Card Number", Toast.LENGTH_SHORT).show();
        }
    }

    void Jazz_Cash()
    {
        input = Jazz_Cash.getText().toString();

        if(input.length()==11)
        {
            Toast.makeText(getContext(), "No. "+input, Toast.LENGTH_SHORT).show();
            //SmsManager smsManager = SmsManager.getDefault();
            Toast.makeText(getContext(), "Msg: "+msg, Toast.LENGTH_SHORT).show();
            //smsManager.sendTextMessage(input, null, msg, null, null);
            Toast.makeText(getContext(), "Order Placed Successfully", Toast.LENGTH_SHORT).show();
            reset_values();
        }
        else
        {
            Toast.makeText(getContext(), "Invalid Jazz Cash Number", Toast.LENGTH_SHORT).show();
        }
    }

    void getvalues()
    {
        Item_N = SplashScreen.Item_Names;
        Item_P = SplashScreen.Item_Prices;
        Item_Q = SplashScreen.Item_Quantities;
        index = SplashScreen.index;
    }

    void setvalues()
    {
        IN.setText(Item_N[0]);
        IP.setText(Item_P[0]);
        IQ.setText("x"+Item_Q[0]);

        for(int i=1; i<index; i++)
        {
            IN.setText(IN.getText()+"\n"+Item_N[i]);
            IP.setText(IP.getText()+"\n"+Item_P[i]);
            IQ.setText(IQ.getText()+"\n"+"x"+Item_Q[i]);
            msg = msg+IN.getText()+" "+IP.getText()+" "+IQ.getText()+" "+"\n";
            total = total+(Integer.parseInt(Item_P[i])*Integer.parseInt(Item_Q[i]));
        }

        total = total+(Integer.parseInt(Item_P[0])*Integer.parseInt(Item_Q[0]));
        msg = msg+"\n "+"Total: Rs: "+total;
        TT.setText("Total = Rs: "+String.valueOf(total));
    }

    public void reset_values()
    {
        Cart_Menu.arrayList.removeAll(Cart_Menu.arrayList);
        SplashScreen.index = 0;
        SplashScreen.Item_Names[0] = "Default Name";
    }
}