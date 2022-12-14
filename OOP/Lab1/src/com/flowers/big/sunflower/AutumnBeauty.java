package com.flowers.big.sunflower;

import com.flower_shop.Color;
import com.flowers.Name;

public class AutumnBeauty extends Sunflower {
    public AutumnBeauty(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.SUNFLOWER_AUTUMNBEAUTY;
    }

    protected void setColor(Color color){
        if (color == Color.ORANGE || color == Color.YELLOW) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 80;
    }
}
