package com.lsilencej.sunnyweather.logic.model.DailyResponse;

public class Result {

    private Daily daily;

    public Result(Daily daily) {
        this.daily = daily;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }
}
