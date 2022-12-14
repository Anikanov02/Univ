package com.flowers.middle.chrysanthemum;

import com.flower_shop.Color;
import com.flowers.Name;

public class Gazele extends Chrysanthemum {
    public Gazele(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.CHRYSANTHEMUM_GAZELE;
    }

    protected void setColor(Color color){
        if (color == Color.WHITE || color == Color.YELLOW || color == Color.VIOLET) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 90;
    }
}