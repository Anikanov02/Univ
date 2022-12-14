package com.flowers.big.hydrangea;

import com.flower_shop.Color;
import com.flowers.Name;

public class Macrophylla extends Hydrangea {
    public Macrophylla(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    protected void setName(){
        this.name = Name.HYDRANGEA_MACROPHYLLA;
    }

    protected void setColor(Color color){
        if (color == Color.BLUE || color == Color.PINK || color == Color.PURPLE) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    public void setPrice(){
        this.price = 400;
    }
}

