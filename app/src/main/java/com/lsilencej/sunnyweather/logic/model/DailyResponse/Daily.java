package com.lsilencej.sunnyweather.logic.model.DailyResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily {

    private List<Temperature> temperature;
    private List<Skycon> skycon;
    @SerializedName("life_index")
    private LifeIndex lifeIndix;

    public Daily(List<Temperature> temperature, List<Skycon> skycon, LifeIndex lifeIndix) {
        this.temperature = temperature;
        this.skycon = skycon;
        this.lifeIndix = lifeIndix;
    }

    public List<Temperature> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<Temperature> temperature) {
        this.temperature = temperature;
    }

    public List<Skycon> getSkycon() {
        return skycon;
    }

    public void setSkycon(List<Skycon> skycon) {
        this.skycon = skycon;
    }

    public LifeIndex getLifeIndix() {
        return lifeIndix;
    }

    public void setLifeIndix(LifeIndex lifeIndix) {
        this.lifeIndix = lifeIndix;
    }
}
