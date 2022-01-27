package com.lsilencej.sunnyweather.logic.model.DailyResponse;

public class Temperature {

    private float max;
    private float min;

    public Temperature(float max, float min) {
        this.max = max;
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }
}
