package com.flowers.middle.chrysanthemum;

import com.flower_shop.Color;
import com.flowers.Name;
import com.flowers.middle.MiddleFlower;

public abstract class Chrysanthemum extends MiddleFlower {
    public Chrysanthemum(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    public boolean CheckFreshness(){
        return getFreshness() < 12;
    }
}