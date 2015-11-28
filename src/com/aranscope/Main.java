package com.aranscope;
import com.leapmotion.leap.*;

import javax.swing.*;
import java.io.IOException;

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
