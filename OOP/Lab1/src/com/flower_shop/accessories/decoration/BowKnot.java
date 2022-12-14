package com.flower_shop.accessories.decoration;

import com.flower_shop.Color;
import com.flower_shop.accessories.AccessoryName;
import com.flower_shop.accessories.Accessory;

public class BowKnot extends DecorationAccessory {
    public BowKnot(Color color) {
        super(color);
    }

    protected void setName(){
        this.name = AccessoryName.BOW_KNOT;
    }

    public void setPrice(){
        this.price = 40;
    }
}
