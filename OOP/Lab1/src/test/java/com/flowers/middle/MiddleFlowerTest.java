package com.flowers.middle;

import com.flower_shop.Color;
import com.flowers.middle.tulip.Cummins;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleFlowerTest {

        MiddleFlower middleFlower = new Cummins(Color.VIOLET, 50, "2022-09-26");

        @Test
        void setHeightNormal() {
            MiddleFlower middleFlower = new Cummins(Color.VIOLET, 50, "2022-09-26");
            assertEquals(50, middleFlower.getHeight());
        }

        @Test
        void setHeightException() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> middleFlower.setHeight(120));
            assertEquals("Height is not valid", exception.getMessage());
        }

}