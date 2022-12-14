package com.flowers.big.sunflower;

import com.flower_shop.Color;
import com.flowers.Name;

public class Chianti extends Sunflower {
    public Chianti(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.SUNFLOWER_CHIANTI;
    }

    protected void setColor(Color color){
        if (color == Color.BURGUNDY) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 75;
    }
}
