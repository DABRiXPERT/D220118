package com.dabrixpert.d220118;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D220118 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    JFrame ui = new JFrame("Timer");
    JPanel layout = new JPanel();
    JLabel timer = new JLabel("--:--:--");
    D220118() throws IOException {
        ui.setSize(600, 300);
        layout.setBackground(new Color(40, 40, 40));
        timer.setForeground(new Color(255, 255, 255));
        timer.setSize(100, 100);
        Process process = Runtime.getRuntime().exec("shutdown -s -t 300");
        printResults(process);
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