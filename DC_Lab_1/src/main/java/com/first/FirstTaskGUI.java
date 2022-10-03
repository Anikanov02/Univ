package com.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FirstTaskGUI extends JFrame {
    private final JSlider slider;
    private final JButton button;
    private final JSlider priority1;
    private final JSlider priority2;

    public FirstTaskGUI() throws InterruptedException {
        super("Task 1");
        this.setBounds(100, 100, 300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 2, 2));
        slider = new JSlider();
        button = new JButton("Start");
        priority1 = new JSlider(1, 1, 10, 5);
        priority2 = new JSlider(1, 1, 10, 5);
        container.add(slider);
        container.add(button);
        container.add(priority1);
        container.add(priority2);

        Task1 task1 = new Task1(10, slider);
        Task1 task2 = new Task1(90, slider);
        Thread th1 = new Thread(task1, "Tthread1");
        Thread th2 = new Thread(task2, "Tthread2");

        button.addActionListener(e -> {
            button.setEnabled(false);
            th1.start();
            th2.start();
        });

        priority1.addChangeListener(e -> {
            th1.setPriority(priority1.getValue());
            System.out.println("priority of " + th1.getName() + " is set to " + th1.getPriority());
        });

        priority2.addChangeListener(e -> {
            th2.setPriority(priority2.getValue());
            System.out.println("priority of " + th2.getName() + " is set to " + th2.getPriority());
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                task1.setRunning(false);
                task2.setRunning(false);
            }
        });
    }
}
