package com.flowers.big.sunflower;

import com.flower_shop.Color;
import com.flowers.Name;

public class TeddyBear extends Sunflower {
    public TeddyBear(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.SUNFLOWER_TEDDYBEAR;
    }

    protected void setColor(Color color){
    if (color == Color.YELLOW) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 55;
    }
}
