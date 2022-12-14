package com.flowers.small.convallaria;

import com.flowers.small.SmallFlower;
import com.flower_shop.Color;
import com.flowers.Name;

public abstract class Convallaria extends SmallFlower {
    public Convallaria(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    public boolean CheckFreshness(){
        return getFreshness() < 12;
    }
}

