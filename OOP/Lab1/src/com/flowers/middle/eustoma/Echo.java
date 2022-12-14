package com.flowers.middle.eustoma;

import com.flower_shop.Color;
import com.flowers.Name;

public class Echo extends Eustoma {
    public Echo(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.EUSTOMA_ECHO;
    }

    protected void setColor(Color color){
        if (color == Color.WHITE || color == Color.PINK || color == Color.VIOLET) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 60;
    }
}
