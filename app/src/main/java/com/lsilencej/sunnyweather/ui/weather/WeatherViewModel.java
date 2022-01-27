package com.lsilencej.sunnyweather.ui.weather;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.lsilencej.sunnyweather.logic.Repository;
import com.lsilencej.sunnyweather.logic.model.PlaceResponse.Location;
import com.lsilencej.sunnyweather.logic.model.Weather.Weather;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<Location> locationMutableLiveData = new MutableLiveData<>();
    private String locationLng = "";
    private String locationLat = "";
    private String placeName = "";

    private LiveData<Weather> weatherLiveData = Transformations.switchMap(locationMutableLiveData, new Function<Location, LiveData<Weather>>() {
        @Override
        public LiveData<Weather> apply(Location input) {
            return Repository.refreshWeather(input.getLng(), input.getLat());
        }
    });

    public void refreshWeather(String lng, String lat) {
        locationMutableLiveData.setValue(new Location(lng, lat));
    }

    public String getLocationLng() {
        return locationLng;
    }

    public void setLocationLng(String locationLng) {
        this.locationLng = locationLng;
    }

    public String getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(String locationLat) {
        this.locationLat = locationLat;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public LiveData<Weather> getWeatherLiveData() {
        return weatherLiveData;
    }
}
