package com.dabrixpert.d220118;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class D220118 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    JFrame ui = new JFrame("Timer");
    JPanel layout = new JPanel();
    JLabel timer = new JLabel("--:--:--");
    D220118() throws IOException {
        ui.setSize(600, 300);
        layout.setBackground(new Color(40, 40, 40));
        layout.setLayout(null);
        timer.setForeground(new Color(255, 255, 255));
        timer.setBounds(0, 0, 600, 80);
        timer.setFont(new Font("MS Gothic", Font.PLAIN, 40));
//        Process process = Runtime.getRuntime().exec("shutdown -s -t 300");
//        printResults(process);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Timer t = new Timer(0, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        timer.setText(String.valueOf(System.currentTimeMillis()));
                    }
                });
                t.start();
            }
        });
        thread.run();
        ui.add(layout);
        layout.add(timer);
        ui.setVisible(true);
        ui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void printResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
    public static void main(String[] args) throws IOException {
        new D220118();
    }
}