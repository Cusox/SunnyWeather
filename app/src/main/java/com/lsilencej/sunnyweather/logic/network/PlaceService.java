package com.lsilencej.sunnyweather.logic.network;

import com.lsilencej.sunnyweather.SunnyWeatherApplication;
import com.lsilencej.sunnyweather.logic.model.PlaceResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceService {

    @GET("v2/place?token=" + SunnyWeatherApplication.TOKEN + "&lang=zh_CN")
    public Call<PlaceResponse> searchPlaces(@Query("query") String query);

}
