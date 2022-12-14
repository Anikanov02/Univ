package com.flower_shop.accessories.packing;

import com.flower_shop.Color;
import com.flower_shop.accessories.AccessoryName;
import com.flower_shop.accessories.Accessory;

public class Paper extends PackingAccessory {
    public Paper(Color color) {
        super(color);
    }

    protected void setName(){
        this.name = AccessoryName.PAPER;
    }

    public void setPrice(){
        this.price = 15;
    }
}