package com.flower_shop;

import com.flowers.Flower;
import com.flowers.big.lily.Asiatic;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class FloristTest {

    Florist florist = new Florist();
    Warehouse warehouse = new Warehouse();

    @Test
    void makeBouquet() {
        warehouse.buyingFlowers(10, "2022-09-23");
        ArrayList<Flower> flowers = new ArrayList<>();
        Flower f1 = new Asiatic(Color.WHITE, 90, "2022-09-23");
        Flower f2 = new Asiatic(Color.WHITE, 90, "2022-09-23");
        Flower f3 = new Asiatic(Color.WHITE, 90, "2022-09-23");
        flowers.add(f1);
        flowers.add(f2);
        flowers.add(f3);
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(f1);
        bouquet.addFlower(f2);
        bouquet.addFlower(f3);
        assertEquals(bouquet.getFlowers(), florist.makeBouquet(warehouse, flowers).getFlowers());
    }
}