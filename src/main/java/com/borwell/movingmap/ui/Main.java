package com.borwell.movingmap.ui;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hight Bar Mockup");
        frame.setContentPane(new HeightBarMockup().getmHeightBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(200, 700));
        frame.pack();
        frame.setVisible(true);
    }
}