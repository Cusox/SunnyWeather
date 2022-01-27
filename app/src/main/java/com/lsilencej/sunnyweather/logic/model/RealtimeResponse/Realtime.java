package com.lsilencej.sunnyweather.logic.model.RealtimeResponse;

import com.google.gson.annotations.SerializedName;

public class Realtime {

    private float temperature;
    private String skycon;
    @SerializedName("air_quality")
    private AirQuality airQuality;

    public Realtime(float temperature, String skycon, AirQuality airQuality) {
        this.temperature = temperature;
        this.skycon = skycon;
        this.airQuality = airQuality;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getSkycon() {
        return skycon;
    }

    public void setSkycon(String skycon) {
        this.skycon = skycon;
    }

    public AirQuality getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(AirQuality airQuality) {
        this.airQuality = airQuality;
    }
}
