package com.flowers.small.myosotis;

import com.flower_shop.Color;
import com.flowers.Name;

public class BlueBall extends Myosotis {
    public BlueBall(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.MYOSOTIS_BLUEBALL;
    }

    protected void setColor(Color color){
        if (color == Color.BLUE) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 20;
    }
}
