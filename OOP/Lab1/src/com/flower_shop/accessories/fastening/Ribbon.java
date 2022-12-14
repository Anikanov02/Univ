package com.flower_shop.accessories.fastening;

import com.flower_shop.Color;
import com.flower_shop.accessories.AccessoryName;
import com.flower_shop.accessories.Accessory;

public class Ribbon extends FasteningAccessory {
    public Ribbon(Color color) {
        super(color);
    }

    protected void setName(){
        this.name = AccessoryName.RIBBON;
    }

    public void setPrice(){
        this.price = 15;
    }
}
