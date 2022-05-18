package com.borwell.movingmap.ui;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame{

    private HeightBarMockup mHeightBar;

    public Display() throws HeadlessException {
        super("Canvas Test");
        mHeightBar = new HeightBarMockup();
        setContentPane(mHeightBar.getHeightBar());
        getContentPane().setBackground(Color.WHITE);
        setSize(150, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }



    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        drawRectangles(g);
    }

    private void drawRectangles(Graphics g) {
        mHeightBar.resizeHeightBar();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Display().setVisible(true);
            }
        });
    }
}