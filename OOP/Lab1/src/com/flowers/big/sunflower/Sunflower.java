package com.flowers.big.sunflower;

import com.flower_shop.Color;
import com.flowers.Name;
import com.flowers.big.BigFlower;

public abstract class Sunflower extends BigFlower {
    public Sunflower(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    public boolean CheckFreshness(){
        return getFreshness() < 12;
    }
}