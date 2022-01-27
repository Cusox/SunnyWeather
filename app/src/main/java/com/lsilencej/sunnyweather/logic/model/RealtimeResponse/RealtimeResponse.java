package com.lsilencej.sunnyweather.logic.model.RealtimeResponse;

public class RealtimeResponse {

    private String status;
    private Result result;
    private String error;

    public RealtimeResponse(String status, Result result) {
        this.status = status;
        this.result = result;
    }

    public RealtimeResponse(String status, String error, Result result) {
        this.status = status;
        this.result = result;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
