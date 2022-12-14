package com.flowers.big.peony;

import com.flowers.big.BigFlower;
import com.flower_shop.Color;
import com.flowers.Name;

public abstract class Peony extends BigFlower {
    public Peony(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    public boolean CheckFreshness(){
        return getFreshness() < 12;
    }
}