package com.flowers.big.peony;

import com.flower_shop.Color;
import com.flowers.Name;

public class Kansas extends Peony {
    public Kansas(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.PEONY_KANSAS;
    }

    protected void setColor(Color color){
        if (color == Color.CRIMSON) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 150;
    }
}