package com.flowers.middle.gerbera;

import com.flower_shop.Color;
import com.flowers.Name;

public class Tamara extends Gerbera {
    public Tamara(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.GERBERA_TAMARA;
    }

    protected void setColor(Color color){
        if (color == Color.BURGUNDY || color == Color.ORANGE || color == Color.YELLOW) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 45;
    }
}
