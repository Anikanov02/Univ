package com.second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicReference;
import static com.second.Main.semapore;

public class SecondTaskGUI extends JFrame {
    private final JSlider slider;
    private final JButton start1;
    private final JButton start2;
    private final JButton stop1;
    private final JButton stop2;

    public SecondTaskGUI() {
        super("Task 2");
        Container container = this.getContentPane();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 300, 200);
        container.setLayout(null);
        slider = new JSlider();
        slider.setBounds(10, 10, 280, 10);
        start1 = new JButton("Start 1");
        start1.setBounds(10, 50, 100, 50);
        start2 = new JButton("Start 2");
        start2.setBounds(180, 50, 100, 50);
        stop1 = new JButton("Stop 1");
        stop1.setBounds(10, 105, 100, 50);
        stop2 = new JButton("Stop 2");
        stop2.setBounds(180, 105, 100, 50);
        container.add(slider);
        container.add(start1);
        container.add(start2);
        container.add(stop1);
        container.add(stop2);

        Task2 task1 = new Task2(10, slider);
        Task2 task2 = new Task2(90, slider);

        AtomicReference<Thread> t1 = new AtomicReference<>(new Thread(task1));
        AtomicReference<Thread> t2 = new AtomicReference<>(new Thread(task2));

        start1.addActionListener(e -> {
            if (!semapore) {
                System.out.println("Locked!!!");
            } else {
                t1.get().start();
                stop2.setEnabled(false);
                t1.get().setPriority(Thread.MIN_PRIORITY);
            }
        });

        start2.addActionListener(e -> {
            if (!semapore) {
                System.out.println("Locked!!!");
            } else {
                t2.get().start();
                stop1.setEnabled(false);
                t2.get().setPriority(Thread.MAX_PRIORITY);
            }
        });

        stop1.addActionListener(e -> {
            task1.setRunning(false);
            stop2.setEnabled(true);
            t1.set(new Thread(task1));
        });

        stop2.addActionListener(e -> {
            task2.setRunning(false);
            stop1.setEnabled(true);
            t2.set(new Thread(task2));
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
