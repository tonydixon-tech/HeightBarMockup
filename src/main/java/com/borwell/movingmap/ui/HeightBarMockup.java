package com.borwell.movingmap.ui;

import com.borwell.movingmap.domainobjects.config.AirshowOperationsConfig;

import javax.swing.*;
import java.awt.*;

public class HeightBarMockup {

    private Color maxRedColour;
    private Color maxYellowColour;
    private Color middleGreenColour;
    private Color minYellowColour;
    private Color minRedColour;

    private Dimension mDimMaxRedSplash;
    private Dimension mDimMaxYellowSplash;
    private Dimension mDimMiddleSplash;
    private Dimension mDimMinYellowSplash;
    private Dimension mDimMinRedSplash;

    private JPanel mHeightBar;
    private JLabel mHeightLabel;
    private JPanel mColourBar;

    public void resizeHeightBar() {
        AirshowOperationsConfig airshowOperationsConfig = new AirshowOperationsConfig();

        double minHeightTop = airshowOperationsConfig.getAirfieldMaxHeight();
        double maxHeightTop = minHeightTop + 1000;

        double maxAerobatics = airshowOperationsConfig.getAirfieldMaxAerobaticsHeight();
        double minAerobatics = airshowOperationsConfig.getAirfieldMinAerobaticsHeight();

        double maxHeightBottom = airshowOperationsConfig.getAirfieldMinHeight();
        double minHeightBottom = 0;

        double realPanelHeight = mColourBar.getHeight();
        double featToRealHeight = realPanelHeight / maxHeightTop;

        int maxRedPanelHeight = (int) ((maxHeightTop - minHeightTop) * featToRealHeight);
        maxRedPanel.setPreferredSize(new Dimension(-1, maxRedPanelHeight));

        int maxYellowPanelHeight = (int) ((minHeightTop - maxAerobatics) * featToRealHeight);
        maxYellowPanel.setPreferredSize(new Dimension(-1, maxYellowPanelHeight));

        int middleGreenHeight = (int) ((maxAerobatics - minAerobatics) * featToRealHeight);
        middleGreenPanel.setPreferredSize(new Dimension(-1, middleGreenHeight));

        int minYellowPanelHeight = (int) ((minAerobatics - maxHeightBottom) * featToRealHeight);
        minYellowPanel.setPreferredSize(new Dimension(-1, minYellowPanelHeight));

        int minRedPanelHeight = (int) ((maxHeightBottom - minHeightBottom) * featToRealHeight);
        minRedPanel.setPreferredSize(new Dimension(-1, minRedPanelHeight));

        recolourHeightBar();
        minRedPanel.revalidate();

        //mPanelHeight.setBackground(new Color(0,0,0, 0));

    }

    private void recolourHeightBar() {
    }

    public JPanel getmHeightBar() {
        return mHeightBar;
    }
}
