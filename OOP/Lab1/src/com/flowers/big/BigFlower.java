package com.flowers.big;

import com.flower_shop.Color;
import com.flowers.Flower;
import com.flowers.Name;

public abstract class BigFlower extends Flower
{
    public BigFlower(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }

    protected void setHeight(Integer height){
        if (height >= 80 && height <= 150) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height is not valid");
        }
    }
}