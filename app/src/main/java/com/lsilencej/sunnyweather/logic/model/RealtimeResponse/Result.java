package com.lsilencej.sunnyweather.logic.model.RealtimeResponse;

public class Result {

    private Realtime realtime;

    public Result(Realtime realtime) {
        this.realtime = realtime;
    }

    public Realtime getRealtime() {
        return realtime;
    }

    public void setRealtime(Realtime realtime) {
        this.realtime = realtime;
    }
}
