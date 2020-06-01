package com.example.lib.Timer;

import java.time.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {
    public static void main(String[] args) {
        TimePrinter listener = new TimePrinter();
        Timer timer = new Timer(1000, listener);
        timer.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
