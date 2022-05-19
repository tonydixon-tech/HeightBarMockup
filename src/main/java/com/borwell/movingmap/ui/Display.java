package com.borwell.movingmap.ui;

import com.borwell.movingmap.ui.mapwindows.overlays.HeightBarOverlay;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame implements Runnable{
    private static final int WIDTH = 160;
    private static final int HEIGHT = 700;

    private Thread mThread;
    private static final String HEIGHT_DEMO = "Height Bar Demo";

    private HeightBarOverlay mHeightBar;

    public Display() throws HeadlessException {
        super("Canvas Test");
        mHeightBar = new HeightBarOverlay();
        setContentPane(mHeightBar.getHeightBar());
        getContentPane().setBackground(Color.WHITE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        mHeightBar.resizeHeightBar();
        start();
    }

    public void start () {
        System.out.println("Starting " +  HEIGHT_DEMO );
        if (mThread == null) {
            mThread = new Thread (this, HEIGHT_DEMO);
            mThread.start ();
        }
    }

    @Override
    public void run() {
        try {
            for (int ft = 500; ft < 8000; ft++){
                int feet = ft;
                Thread.sleep(5);
                mHeightBar.setAircraftHeight(feet);
            }
        } catch (InterruptedException ex){
            System.out.println("Thread " +  HEIGHT_DEMO + " interrupted.");
        }
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