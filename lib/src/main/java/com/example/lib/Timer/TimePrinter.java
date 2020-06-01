package com.example.lib.Timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("At the tone,the time is " + Instant.ofEpochMilli(actionEvent.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}
