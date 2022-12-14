package com.flowers.middle.tulip;

import com.flower_shop.Color;
import com.flowers.Name;

public class Albatros extends Tulip {
    public Albatros(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.TULIP_ALBATROS;
    }

    protected void setColor(Color color){
        if (color == Color.WHITE) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 30;
    }
}
