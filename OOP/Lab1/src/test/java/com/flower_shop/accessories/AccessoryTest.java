package com.flower_shop.accessories;

import com.flower_shop.Color;
import com.flower_shop.accessories.packing.Box;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessoryTest {

    Accessory accessory;

    @Test
    void setPrice() {
        accessory = new Box(Color.WHITE);
        accessory.setPrice(50);
        assertEquals(50, accessory.getPrice());
    }

    @Test
    void setColor() {
        accessory = new Box(Color.WHITE);
        accessory.setColor(Color.PINK);
        assertEquals(Color.PINK, accessory.getColor());
    }

    @Test
    void getColor() {
        accessory = new Box(Color.WHITE);
        assertEquals(Color.WHITE, accessory.getColor());
    }

    @Test
    void getName() {
        accessory = new Box(Color.WHITE);
        assertEquals(AccessoryName.BOX, accessory.getName());
    }

    @Test
    void getPrice() {
        accessory = new Box(Color.WHITE);
        assertEquals(200, accessory.getPrice());
    }
}