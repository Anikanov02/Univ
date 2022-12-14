package com.flower_shop.accessories.packing;

import com.flower_shop.Color;
import com.flower_shop.accessories.AccessoryName;
import com.flower_shop.accessories.Accessory;

public class Box extends PackingAccessory {
    public Box(Color color) {
        super(color);
    }

    protected void setName(){
        this.name = AccessoryName.BOX;
    }

    public void setPrice(){
        this.price = 200;
    }
}
