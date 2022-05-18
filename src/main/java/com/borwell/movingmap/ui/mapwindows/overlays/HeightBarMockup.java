package com.borwell.movingmap.ui.mapwindows.overlays;

import com.borwell.movingmap.domainobjects.config.AirshowOperationsConfig;
import com.borwell.movingmap.ui.lookandfeel.ColourPallete;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class HeightBarMockup {

    private static final int EDGE_BUFFER = 10;
    private Color maxRedColour;
    private Color maxYellowColour;
    private Color middleGreenColour;
    private Color minYellowColour;
    private Color minRedColour;

    private Dimension mDimMaxRedSplash;
    private Dimension mDimMaxYellowSplash;
    private Dimension mDimMiddleGreenSplash;
    private Dimension mDimMinYellowSplash;
    private Dimension mDimMinRedSplash;

    private JPanel mHeightBar;
    private JLabel mHeightLabel;

    public void resizeHeightBar() {
        AirshowOperationsConfig airshowOperationsConfig = new AirshowOperationsConfig();

        double minHeightTop = airshowOperationsConfig.getAirfieldMaxHeight();
        double maxHeightTop = minHeightTop + 1000;

        double maxAerobatics = airshowOperationsConfig.getAirfieldMaxAerobaticsHeight();
        double minAerobatics = airshowOperationsConfig.getAirfieldMinAerobaticsHeight();

        double maxHeightBottom = airshowOperationsConfig.getAirfieldMinHeight();
        double minHeightBottom = 0;

        double realPanelHeight = mHeightBar.getHeight() - mHeightLabel.getHeight();
        double featToRealHeight = realPanelHeight / maxHeightTop;

        // Set the colour fill dimensions
        int maxRedPanelHeight = (int) ((maxHeightTop - minHeightTop) * featToRealHeight);
        this.mDimMaxRedSplash = new Dimension(mHeightBar.getWidth() - EDGE_BUFFER, maxRedPanelHeight);

        int maxYellowPanelHeight = (int) ((minHeightTop - maxAerobatics) * featToRealHeight);
        this.mDimMaxYellowSplash = new Dimension(mHeightBar.getWidth() - EDGE_BUFFER, maxYellowPanelHeight);

        int middleGreenHeight = (int) ((maxAerobatics - minAerobatics) * featToRealHeight);
        this.mDimMiddleGreenSplash = new Dimension(mHeightBar.getWidth() - EDGE_BUFFER, middleGreenHeight);

        int minYellowPanelHeight = (int) ((minAerobatics - maxHeightBottom) * featToRealHeight);
        this.mDimMinYellowSplash = new Dimension(mHeightBar.getWidth() - EDGE_BUFFER, minYellowPanelHeight);

        int minRedPanelHeight = (int) ((maxHeightBottom - minHeightBottom) * featToRealHeight);
        this.mDimMinRedSplash = new Dimension(mHeightBar.getWidth() - EDGE_BUFFER, minRedPanelHeight);

        recolourHeightBar();
    }

    private void recolourHeightBar() {
        Graphics2D g = (Graphics2D) mHeightBar.getGraphics();

        int verticalPosn = mHeightLabel.getHeight() + 1;

        ColorUIResource maxAirfieldHeightColour = ColourPallete.maxAirfieldHeight;
        maxRedColour = new Color(maxAirfieldHeightColour.getRed(), maxAirfieldHeightColour.getGreen(), maxAirfieldHeightColour.getBlue());
        minRedColour = new Color(maxAirfieldHeightColour.getRed(), maxAirfieldHeightColour.getGreen(), maxAirfieldHeightColour.getBlue());

        ColorUIResource maxAerobaticsAirfieldHeightColour = ColourPallete.maxAerobaticsAirfieldHeight;
        maxYellowColour = new Color(maxAerobaticsAirfieldHeightColour.getRed(), maxAerobaticsAirfieldHeightColour.getGreen(), maxAerobaticsAirfieldHeightColour.getBlue());
        minYellowColour = new Color(maxAerobaticsAirfieldHeightColour.getRed(), maxAerobaticsAirfieldHeightColour.getGreen(), maxAerobaticsAirfieldHeightColour.getBlue());

        ColorUIResource minAerobaticsAirfieldHeightColour = ColourPallete.minAerobaticsAirfieldHeight;
        middleGreenColour = new Color(minAerobaticsAirfieldHeightColour.getRed(), minAerobaticsAirfieldHeightColour.getGreen(), minAerobaticsAirfieldHeightColour.getBlue());

        g.setColor(maxRedColour);
        g.fillRect(EDGE_BUFFER, verticalPosn, this.mDimMaxRedSplash.width - EDGE_BUFFER, this.mDimMaxRedSplash.height);
        verticalPosn += this.mDimMaxRedSplash.height;

        g.setColor(maxYellowColour);
        g.fillRect(EDGE_BUFFER, verticalPosn, this.mDimMaxYellowSplash.width - EDGE_BUFFER, this.mDimMaxYellowSplash.height);
        verticalPosn += this.mDimMaxYellowSplash.height;

        g.setColor(middleGreenColour);
        g.fillRect(EDGE_BUFFER, verticalPosn, this.mDimMiddleGreenSplash.width - EDGE_BUFFER, this.mDimMiddleGreenSplash.height);
        verticalPosn += this.mDimMiddleGreenSplash.height;

        g.setColor(minYellowColour);
        g.fillRect(EDGE_BUFFER, verticalPosn, this.mDimMinYellowSplash.width - EDGE_BUFFER, this.mDimMinYellowSplash.height);
        verticalPosn += this.mDimMinYellowSplash.height;

        g.setColor(minRedColour);
        g.fillRect(EDGE_BUFFER, verticalPosn, this.mDimMinRedSplash.width - EDGE_BUFFER, this.mDimMinRedSplash.height);
    }


    public JPanel getHeightBar() {
        return mHeightBar;
    }
}
