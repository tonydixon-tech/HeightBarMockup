package com.borwell.movingmap.domainobjects.config;

public class AirshowOperationsConfig {

    private Double mAirfieldHeight = 200.0;

    private Double mAirfieldMaxHeight = 8000.0;

    private Double mAirfieldMaxAerobaticsHeight = 2500.0;

    private Double mAirfieldMinAerobaticsHeight = 1500.0;


    private Double mAirfieldMinHeight = 500.0;

    public Double getAirfieldHeight() {
        return mAirfieldHeight;
    }

    public Double getAirfieldMaxHeight() {
        return mAirfieldMaxHeight;
    }

    public Double getAirfieldMaxAerobaticsHeight() {
        return mAirfieldMaxAerobaticsHeight;
    }

    public Double getAirfieldMinAerobaticsHeight() {
        return mAirfieldMinAerobaticsHeight;
    }

    public Double getAirfieldMinHeight() {
        return mAirfieldMinHeight;
    }
}
