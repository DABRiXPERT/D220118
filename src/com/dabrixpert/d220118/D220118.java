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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class D220118 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    JFrame ui = new JFrame("Timer");
    JPanel layout = new JPanel();
    JLabel timer = new JLabel("--:--:--");
    String[] time;
    int h, m, s, ms;
    D220118() throws IOException, ParseException {
        ui.setSize(600, 300);
        layout.setBackground(new Color(40, 40, 40));
        layout.setLayout(null);
        timer.setForeground(new Color(255, 255, 255));
        timer.setBounds(0, 0, 600, 90);
        timer.setFont(new Font("MS Gothic", Font.PLAIN, 90));

        System.out.println("ver: 220119C");
        time = br.readLine().split(":");
        h = Integer.parseInt(time[0]); m = Integer.parseInt(time[1]); s = Integer.parseInt(time[2]); ms = Integer.parseInt(time[3]);

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                ms -= 1;
                if (ms < 0) {
                    s--;
                    ms=999;
                }
                if (s < 0) {
                    m--;
                    s=59;
                }
                if (m < 0) {
                    h--;
                    m = 59;
                }
                if (h < 0) {
                    try {
                        Process process = Runtime.getRuntime().exec("shutdown -s -t 0");
                        printResults(process);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                }
                timer.setText(String.format("%02d:%02d:%02d:%03d", h, m, s, ms));
            }
        }, 0, 1);

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

    public static void main(String[] args) throws IOException, ParseException {
        new D220118();
    }
}