package com.lsilencej.sunnyweather.logic.network;

import com.lsilencej.sunnyweather.SunnyWeatherApplication;
import com.lsilencej.sunnyweather.logic.model.DailyResponse.DailyResponse;
import com.lsilencej.sunnyweather.logic.model.RealtimeResponse.RealtimeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherService {

    @GET("v2.5/" + SunnyWeatherApplication.TOKEN + "/{lng},{lat}/realtime.json")
    public Call<RealtimeResponse> getRealtimeWeather(@Path("lng") String lng, @Path("lat") String lat);

    @GET("v2.5/" + SunnyWeatherApplication.TOKEN + "/{lng},{lat}/daily.json")
    public Call<DailyResponse> getDailyWeather(@Path("lng") String lng, @Path("lat") String lat);

}
