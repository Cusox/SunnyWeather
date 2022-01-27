package com.lsilencej.sunnyweather.logic.model.PlaceResponse;

import java.util.List;

public class PlaceResponse {

    private String status;
    private String error = null;
    private List<Place> places;

    public PlaceResponse(String status, String error, List<Place> places) {
        this.status = status;
        this.error = error;
        this.places = places;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

}
