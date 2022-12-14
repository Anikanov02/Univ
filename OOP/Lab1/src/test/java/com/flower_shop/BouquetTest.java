package com.flower_shop;

import com.flower_shop.accessories.decoration.BowKnot;
import com.flowers.big.lily.Asiatic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BouquetTest {

    Warehouse warehouse = new Warehouse();
    Florist florist = new Florist();
    Bouquet bouquet = new Bouquet();

    @Test
    void getFlowers() {
        warehouse.buyingFlowers(10, "2022-09-23");
        bouquet = florist.makeBouquet(warehouse, Bouquets.AUTUMN_DREAMS);
        assertEquals(11, bouquet.getFlowers().size());
    }

    @Test
    void getPrice() {
        warehouse.buyingFlowers(10, "2022-09-23");
        bouquet = florist.makeBouquet(warehouse, Bouquets.AUTUMN_DREAMS);
        assertEquals(1780, bouquet.getPrice());
    }

    @Test
    void addFlower() {
        warehouse.buyingFlowers(10, "2022-09-23");
        bouquet = florist.makeBouquet(warehouse, Bouquets.AUTUMN_DREAMS);
        bouquet.addFlower(new Asiatic(Color.WHITE, 90, "2022-09-23"));
        assertEquals(12, bouquet.getFlowers().size());
    }

    @Test
    void addAccessory() {
        warehouse.buyingFlowers(10, "2022-09-23");
        bouquet = florist.makeBouquet(warehouse, Bouquets.AUTUMN_DREAMS);
        bouquet.addAccessory(new BowKnot(Color.WHITE));
        assertEquals(1820, bouquet.getPrice());
    }

    @Test
    void getFlowersByLength() {
        warehouse.buyingFlowers(10, "2022-09-23");
        bouquet = florist.makeBouquet(warehouse, Bouquets.AUTUMN_DREAMS);
        assertEquals(3, bouquet.getFlowersByLength(90, 120).size());
    }
}