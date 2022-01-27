package com.lsilencej.sunnyweather.logic.model.Weather;

import com.lsilencej.sunnyweather.logic.model.DailyResponse.Daily;
import com.lsilencej.sunnyweather.logic.model.RealtimeResponse.Realtime;

public class Weather {

    private Realtime realtime;
    private Daily daily;
    private String status = "ok";
    private String error;

    public Weather(Realtime realtime, Daily daily) {
        this.realtime = realtime;
        this.daily = daily;
    }

    public Weather(String status, String error, Realtime realtime, Daily daily) {
        this.status = status;
        this.error = error;
        this.realtime = realtime;
        this.daily = daily;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Realtime getRealtime() {
        return realtime;
    }

    public void setRealtime(Realtime realtime) {
        this.realtime = realtime;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }
}
