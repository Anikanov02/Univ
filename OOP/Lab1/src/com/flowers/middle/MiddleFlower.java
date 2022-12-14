package com.flowers.middle;

import com.flower_shop.Color;
import com.flowers.Flower;
import com.flowers.Name;

public abstract class MiddleFlower extends Flower {

    public MiddleFlower(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }

    protected void setHeight(Integer height){
        if (height >= 25 && height <= 100) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height is not valid");
        }
    }
}
