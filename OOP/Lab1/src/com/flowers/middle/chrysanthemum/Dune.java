package com.flowers.middle.chrysanthemum;

import com.flower_shop.Color;
import com.flowers.Name;

public class Dune extends Chrysanthemum {
    public Dune(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.CHRYSANTHEMUM_DUNE;
    }

    protected void setColor(Color color){
        if (color == Color.YELLOW || color == Color.ORANGE) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 100;
    }
}