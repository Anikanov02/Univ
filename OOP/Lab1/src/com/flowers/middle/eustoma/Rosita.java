package com.flowers.middle.eustoma;

import com.flower_shop.Color;
import com.flowers.Name;

public class Rosita extends Eustoma {
    public Rosita(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.EUSTOMA_ROSITA;
    }

    protected void setColor(Color color){
        if (color == Color.WHITE || color == Color.PINK || color == Color.VIOLET || color == Color.GREEN) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 65;
    }
}
