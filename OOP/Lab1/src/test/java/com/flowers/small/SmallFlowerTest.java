package com.flowers.small;

import com.flower_shop.Color;
import com.flowers.small.convallaria.LilyOfTheValley;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallFlowerTest {

        SmallFlower smallFlower = new LilyOfTheValley(Color.WHITE, 20, "2022-09-26");

        @Test
        void setHeightNormal() {
            SmallFlower smallFlower = new LilyOfTheValley(Color.WHITE, 20, "2022-09-26");
            assertEquals(20, smallFlower.getHeight());
        }

        @Test
        void setHeightException() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> smallFlower.setHeight(50));
            assertEquals("Height is not valid", exception.getMessage());
        }

}