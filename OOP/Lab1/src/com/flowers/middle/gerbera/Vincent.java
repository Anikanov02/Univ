package com.flowers.middle.gerbera;

import com.flower_shop.Color;
import com.flowers.Name;

public class Vincent extends Gerbera {
    public Vincent(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.GERBERA_VINCENT;
    }

    protected void setColor(Color color){
        if (color == Color.YELLOW || color == Color.PINK || color == Color.RED) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 55;
    }
}