package com.flowers.middle.rose;

import com.flower_shop.Color;
import com.flowers.Name;

public class Akito extends Rose {
    public Akito(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.ROSE_AKITO;
    }

    protected void setColor(Color color){
        if (color == Color.WHITE || color == Color.PINK) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 90;
    }
}