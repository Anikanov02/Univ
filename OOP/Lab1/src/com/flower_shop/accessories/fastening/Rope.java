package com.flower_shop.accessories.fastening;

import com.flower_shop.Color;
import com.flower_shop.accessories.AccessoryName;
import com.flower_shop.accessories.Accessory;

public class Rope extends FasteningAccessory {
    public Rope(Color color) {
        super(color);
    }

    protected void setName(){
        this.name = AccessoryName.ROPE;
    }

    public void setPrice(){
        this.price = 5;
    }
}
