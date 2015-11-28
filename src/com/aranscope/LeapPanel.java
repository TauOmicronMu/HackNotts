package com.aranscope;

import com.leapmotion.leap.*;

import javax.swing.*;
import java.awt.*;

public class LeapPanel extends JPanel {
    FingerList fingers;

    public LeapPanel(){
        super();
        Controller controller = new Controller();



        Listener l = new Listener(){
            @Override
            public void onConnect(Controller controller) {
                System.out.println("Connected");
                controller.enableGesture(Gesture.Type.TYPE_SWIPE);
            }

            @Override
            public void onFrame(Controller controller) {
                com.leapmotion.leap.Frame frame = controller.frame();

                System.out.println("Frame id: " + frame.id()
                        + ", timestamp: " + frame.timestamp()
                        + ", hands: " + frame.hands().count()
                        + ", fingers: " + frame.fingers().count()
                        + ", tools: " + frame.tools().count()
                        + ", gestures " + frame.gestures().count());

                fingers = frame.fingers();
            }
        };

        controller.addListener(l);
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(Finger finger: fingers){
            g2.fillOval((int)finger.jointPosition(Finger.Joint.JOINT_DIP).getX(), (int)finger.jointPosition(Finger.Joint.JOINT_DIP).getY(), 10, 10);
        }

    }
}
