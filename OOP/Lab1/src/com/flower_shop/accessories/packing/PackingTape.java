package com.flower_shop.accessories.packing;

import com.flower_shop.Color;
import com.flower_shop.accessories.AccessoryName;
import com.flower_shop.accessories.Accessory;
import com.flower_shop.accessories.fastening.FasteningAccessory;

public class PackingTape extends PackingAccessory {
    public PackingTape(Color color) {
        super(color);
    }

    protected void setName(){
        this.name = AccessoryName.PACKING_TAPE;
    }

    public void setPrice(){
        this.price = 10;
    }
}