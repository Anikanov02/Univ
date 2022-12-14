package com.flowers.small.myosotis;

import com.flowers.small.SmallFlower;
import com.flower_shop.Color;
import com.flowers.Name;

public abstract class Myosotis extends SmallFlower {
    public Myosotis(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    public boolean CheckFreshness(){
        return getFreshness() < 12;
    }
}

