package com.second;

import com.first.Task1;

import javax.swing.*;

import static com.second.Main.semapore;

public class Task2 extends Task1 implements Runnable {
    public Task2(Integer value, JSlider slider) {
        super(value, slider);
    }

    @Override
    public void run() {
        semapore = false;
        super.run();
        semapore = true;
    }
}
