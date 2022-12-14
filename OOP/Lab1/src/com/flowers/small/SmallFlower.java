package com.flowers.small;

import com.flower_shop.Color;
import com.flowers.Flower;
import com.flowers.Name;

public abstract class SmallFlower extends Flower {

    public SmallFlower(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }

    protected void setHeight(Integer height){
        if (height >= 10 && height <= 35) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height is not valid");
        }
    }
}