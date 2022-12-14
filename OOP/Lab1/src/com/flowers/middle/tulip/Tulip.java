package com.flowers.middle.tulip;

import com.flowers.middle.MiddleFlower;
import com.flower_shop.Color;
import com.flowers.Name;

public abstract class Tulip  extends MiddleFlower {
    public Tulip(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    public boolean CheckFreshness(){
        return getFreshness() < 12;
    }
}
