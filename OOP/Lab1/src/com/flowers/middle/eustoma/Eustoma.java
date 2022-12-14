package com.flowers.middle.eustoma;

import com.flower_shop.Color;
import com.flowers.Name;
import com.flowers.middle.MiddleFlower;


public abstract class Eustoma extends MiddleFlower {
    public Eustoma(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    public boolean CheckFreshness(){
        return getFreshness() < 12;
    }
}