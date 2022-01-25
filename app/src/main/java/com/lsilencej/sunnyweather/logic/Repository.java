package com.lsilencej.sunnyweather.logic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lsilencej.sunnyweather.logic.model.PlaceResponse;
import com.lsilencej.sunnyweather.logic.network.SunnyWeatherNetwork;

import java.io.IOException;

public class Repository {

    public static LiveData<PlaceResponse> searchPlaces(final String query) {
        final MutableLiveData<PlaceResponse> placeResponseMutableLiveData = new MutableLiveData<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PlaceResponse placeResponse = SunnyWeatherNetwork.searchPlace(query);
                    placeResponseMutableLiveData.postValue(placeResponse);
                } catch (IOException e) {
                    PlaceResponse placeResponse = new PlaceResponse("failed", "网络出错", null);
                    placeResponseMutableLiveData.postValue(placeResponse);
                }
            }
        }).start();
        return placeResponseMutableLiveData;
    }

}
