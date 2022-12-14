package com.flowers.middle.eustoma;

import com.flower_shop.Color;
import com.flowers.Name;

public class Mariachi extends Eustoma {
    public Mariachi(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.EUSTOMA_MARIACHI;
    }

    protected void setColor(Color color){
        if (color == Color.WHITE || color == Color.YELLOW || color == Color.VIOLET) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 55;
    }
}
