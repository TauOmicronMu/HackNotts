package com.aranscope;

import javax.swing.*;

public class Main {
    static LeapPanel leapPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Leap");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new LeapPanel());
        frame.setVisible(true);
        frame.pack();
    }
}
