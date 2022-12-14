package com.flowers.big.hydrangea;

import com.flower_shop.Color;
import com.flowers.Name;

public class Paniculata extends Hydrangea {
    public Paniculata(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }

    protected void setName(){
        this.name = Name.HYDRANGEA_PANICULATA;
    }

    protected void setColor(Color color){
        if (color == Color.WHITE || color == Color.PINK) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 430;
    }
}