package com.lsilencej.sunnyweather.logic.model.RealtimeResponse;

public class AirQuality {

    private AQI aqi;

    public AQI getAqi() {
        return aqi;
    }

    public void setAqi(AQI aqi) {
        this.aqi = aqi;
    }

    public AirQuality(AQI aqi) {
        this.aqi = aqi;
    }
}
