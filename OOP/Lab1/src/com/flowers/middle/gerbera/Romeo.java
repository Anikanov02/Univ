package com.flowers.middle.gerbera;

import com.flower_shop.Color;
import com.flowers.Name;

public class Romeo extends Gerbera {
    public Romeo(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.GERBERA_ROMEO;
    }

    protected void setColor(Color color){
        if (color == Color.RED || color == Color.ORANGE || color == Color.PINK) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 50;
    }
}
