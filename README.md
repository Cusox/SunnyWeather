# SunnyWeather

### 描述

《第一行代码》SunnyWeather 实例

### 框架

Jetpack + MVVM

### 项目结构

```
SunnyWeather
│  AndroidManifest.xml
│  ic_launcher-playstore.png
│  read.txt
│  readme.txt
│  
├─java
│  └─com
│      └─lsilencej
│          └─sunnyweather
│              │  MainActivity.java
│              │  SunnyWeatherApplication.java
│              │  
│              ├─logic
│              │  │  Repository.java
│              │  │  
│              │  ├─dao
│              │  │      PlaceDao.java
│              │  │      
│              │  ├─model
│              │  │  │  Sky.java
│              │  │  │  
│              │  │  ├─DailyResponse
│              │  │  │      Daily.java
│              │  │  │      DailyResponse.java
│              │  │  │      LifeDescription.java
│              │  │  │      LifeIndex.java
│              │  │  │      Result.java
│              │  │  │      Skycon.java
│              │  │  │      Temperature.java
│              │  │  │      
│              │  │  ├─PlaceResponse
│              │  │  │      Location.java
│              │  │  │      Place.java
│              │  │  │      PlaceResponse.java
│              │  │  │      
│              │  │  ├─RealtimeResponse
│              │  │  │      AirQuality.java
│              │  │  │      AQI.java
│              │  │  │      Realtime.java
│              │  │  │      RealtimeResponse.java
│              │  │  │      Result.java
│              │  │  │      
│              │  │  └─Weather
│              │  │          Weather.java
│              │  │          
│              │  └─network
│              │          PlaceService.java
│              │          SearchException.java
│              │          ServiceCreator.java
│              │          SunnyWeatherNetwork.java
│              │          WeatherService.java
│              │          
│              └─ui
│                  ├─place
│                  │      PlaceAdapter.java
│                  │      PlaceFragment.java
│                  │      PlaceViewModel.java
│                  │      
│                  └─weather
│                          WeatherActivity.java
│                          WeatherViewModel.java
│                          
└─res
    ├─drawable
    │      bg_clear_day.jpg
    │      bg_clear_night.jpg
    │      bg_cloudy.jpg
    │      bg_fog.jpg
    │      bg_partly_cloudy_day.jpg
    │      bg_partly_cloudy_night.jpg
    │      bg_place.png
    │      bg_rain.jpg
    │      bg_snow.jpg
    │      bg_wind.jpg
    │      ic_carwashing.png
    │      ic_clear_day.png
    │      ic_clear_night.png
    │      ic_cloudy.png
    │      ic_coldrisk.png
    │      ic_dressing.png
    │      ic_fog.png
    │      ic_hail.png
    │      ic_heavy_haze.png
    │      ic_heavy_rain.png
    │      ic_heavy_snow.png
    │      ic_home.png
    │      ic_light_haze.png
    │      ic_light_rain.png
    │      ic_light_snow.png
    │      ic_moderate_haze.png
    │      ic_moderate_rain.png
    │      ic_moderate_snow.png
    │      ic_partly_cloud_day.png
    │      ic_partly_cloud_night.png
    │      ic_sleet.png
    │      ic_storm_rain.png
    │      ic_thunder_shower.png
    │      ic_ultraviolet.png
    │      search_bg.9.png
    │      
    ├─drawable-v24
    │      ic_launcher_foreground.xml
    │      
    ├─layout
    │      activity_main.xml
    │      activity_weather.xml
    │      forecast.xml
    │      forecast_item.xml
    │      fragment_place.xml
    │      life_index.xml
    │      now.xml
    │      place_item.xml
    │      
    ├─mipmap-anydpi-v26
    │      ic_launcher.xml
    │      ic_launcher_round.xml
    │      
    ├─mipmap-hdpi
    │      ic_launcher.png
    │      ic_launcher_foreground.png
    │      ic_launcher_round.png
    │      
    ├─mipmap-mdpi
    │      ic_launcher.png
    │      ic_launcher_foreground.png
    │      ic_launcher_round.png
    │      
    ├─mipmap-xhdpi
    │      ic_launcher.png
    │      ic_launcher_foreground.png
    │      ic_launcher_round.png
    │      
    ├─mipmap-xxhdpi
    │      ic_launcher.png
    │      ic_launcher_foreground.png
    │      ic_launcher_round.png
    │      
    ├─mipmap-xxxhdpi
    │      ic_launcher.png
    │      ic_launcher_foreground.png
    │      ic_launcher_round.png
    │      
    ├─values
    │      colors.xml
    │      ic_launcher_background.xml
    │      strings.xml
    │      themes.xml
    │      
    └─values-night
            themes.xml
```

