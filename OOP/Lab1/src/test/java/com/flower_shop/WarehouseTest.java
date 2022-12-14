package com.flower_shop;

import com.flowers.Flower;
import com.flowers.big.lily.Asiatic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    Warehouse warehouse= new Warehouse();

    @Test
    void getCount() {
        warehouse.buyingFlowers(4, "2022-09-23");
        assertEquals(4, warehouse.getCount(new Asiatic(Color.WHITE, 90, "2022-09-23")));
    }

    @Test
    void getCountNotFound() {
        assertEquals(0, warehouse.getCount(new Asiatic(Color.WHITE, 90, "2022-09-23")));

    }

    @Test
    void removeFlower() {
        warehouse.buyingFlowers(4, "2022-09-23");
        Flower flower = new Asiatic(Color.WHITE, 90, "2022-09-23");
        warehouse.removeFlower(flower);
        assertEquals(3, warehouse.getCount(flower));
    }

    @Test
    void isAvaliable() {
        assertEquals(false, warehouse.isAvaliable(new Asiatic(Color.WHITE, 90, "2022-09-23")));
        warehouse.buyingFlowers(4, "2022-09-23");
        assertEquals(true, warehouse.isAvaliable(new Asiatic(Color.WHITE, 90, "2022-09-23")));
    }

}