package com.example.abbasicafe;

public class Menu_Data {

    int image;
    String header, desc, price;

    public Menu_Data(int image, String header, String price, String desc) {
        this.image = image;
        this.header = header;
        this.desc = desc;
        this.price = price;
    }

    public String getPrice() {
        return "Rs: "+price;
    }
}
