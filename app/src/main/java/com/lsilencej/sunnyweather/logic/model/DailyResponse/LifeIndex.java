package com.lsilencej.sunnyweather.logic.model.DailyResponse;

import java.util.List;

public class LifeIndex {

    private List<LifeDescription> coldRisk;
    private List<LifeDescription> carWashing;
    private List<LifeDescription> ultraviolet;
    private List<LifeDescription> dressing;

    public LifeIndex(List<LifeDescription> coldRisk, List<LifeDescription> carWashing, List<LifeDescription> ultraviolet, List<LifeDescription> dressing) {
        this.coldRisk = coldRisk;
        this.carWashing = carWashing;
        this.ultraviolet = ultraviolet;
        this.dressing = dressing;
    }

    public List<LifeDescription> getColdRisk() {
        return coldRisk;
    }

    public void setColdRisk(List<LifeDescription> coldRisk) {
        this.coldRisk = coldRisk;
    }

    public List<LifeDescription> getCarWashing() {
        return carWashing;
    }

    public void setCarWashing(List<LifeDescription> carWashing) {
        this.carWashing = carWashing;
    }

    public List<LifeDescription> getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(List<LifeDescription> ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public List<LifeDescription> getDressing() {
        return dressing;
    }

    public void setDressing(List<LifeDescription> dressing) {
        this.dressing = dressing;
    }
}
