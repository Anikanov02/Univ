package com.first;

import javax.swing.*;

public class Task1 implements Runnable {
    private final Integer value;
    private final JSlider slider;
    protected boolean running;

    public Task1(Integer value, JSlider slider) {
        this.value = value;
        this.slider = slider;
        running = false;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            synchronized (slider) {
                slider.setValue(value);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
