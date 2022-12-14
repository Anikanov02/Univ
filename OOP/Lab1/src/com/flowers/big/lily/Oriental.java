package com.flowers.big.lily;

import com.flower_shop.Color;
import com.flowers.Name;

public class Oriental extends Lily {
    public Oriental(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.LILY_ORIENTAL;
    }

    protected void setColor(Color color){
        if (color == Color.PINK || color == Color.ORANGE || color == Color.WHITE) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 90;
    }
}
