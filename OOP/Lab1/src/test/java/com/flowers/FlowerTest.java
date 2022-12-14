package com.flowers;

import com.flower_shop.Color;
import com.flowers.middle.rose.Akito;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    Flower flower = new Akito(Color.WHITE, 100, "2022-09-26");

    @Test
    void getName() {
        assertEquals(Name.ROSE_AKITO, flower.getName());
    }

    @Test
    void getColor() {
        assertEquals(Color.WHITE, flower.getColor());
    }

    @Test
    void getPrice() {
        assertEquals(90, flower.getPrice());
    }

    @Test
    void getHeight() {
        assertEquals(100, flower.getHeight());
    }

    @Test
    void getDeliveryDate() {
        assertEquals("2022-09-26", flower.getDeliveryDate());
    }

    @Test
    void getFreshness() {
        assertEquals(0, flower.getFreshness());
    }

    @Test
    void setHeight() {
        flower.setHeight(50);
        assertEquals(50, flower.getHeight());
    }

    @Test
    void setPrice() {
        flower.setPrice(100);
        assertEquals(100, flower.getPrice());
    }

    @Test
    void setColor() {
        flower.setColor(Color.PINK);
        assertEquals(Color.PINK, flower.getColor());
    }

    @Test
    void setColorException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> flower.setColor(Color.RED));
        assertEquals("Color is not valid", exception.getMessage());
    }

    @Test
    void setHeightException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> flower.setHeight(120));
        assertEquals("Height is not valid", exception.getMessage());
    }

    @Test
    void setDateException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> flower.setDate("2022-09-10"));
        assertEquals("Flower is too old", exception.getMessage());
    }

}