package com.flowers.big.peony;

import com.flower_shop.Color;
import com.flowers.Name;

public class SarahBernhardt extends Peony {
    public SarahBernhardt(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.PEONY_SARAHBERNHARDT;
    }

    protected void setColor(Color color){
        if (color == Color.PINK) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 140;
    }
}
