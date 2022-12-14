package com.flowers.big.hydrangea;

import com.flower_shop.Color;
import com.flowers.Name;
import com.flowers.big.BigFlower;

public abstract class Hydrangea extends BigFlower {
    public Hydrangea(Color color, Integer height, String delivery_date) {
        super(color, height, delivery_date);
    }
    public boolean CheckFreshness(){
        return getFreshness() < 10;
    }
}
