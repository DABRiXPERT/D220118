package com.dabrixpert.d220118;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D220118 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    JFrame ui = new JFrame("Timer");
    JPanel layout = new JPanel();
    JLabel timer = new JLabel("--:--:--");
    D220118() {
        ui.setSize(600, 300);
        layout.setBackground(new Color(40, 40, 40));
        timer.setForeground(new Color(255, 255, 255));
        timer.setSize(100, 100);

        ui.add(layout);
        layout.add(timer);
        ui.setVisible(true);
        ui.addWindowListener(new onWindowClosingListener());
    }
    public static void main(String[] args) {
        new D220118();
    }
}

class onWindowClosingListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
