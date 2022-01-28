package com.lsilencej.sunnyweather.ui.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.lsilencej.sunnyweather.R;
import com.lsilencej.sunnyweather.logic.model.DailyResponse.Daily;
import com.lsilencej.sunnyweather.logic.model.DailyResponse.LifeIndex;
import com.lsilencej.sunnyweather.logic.model.DailyResponse.Skycon;
import com.lsilencej.sunnyweather.logic.model.DailyResponse.Temperature;
import com.lsilencej.sunnyweather.logic.model.RealtimeResponse.Realtime;
import com.lsilencej.sunnyweather.logic.model.Sky;
import com.lsilencej.sunnyweather.logic.model.Weather.Weather;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class WeatherActivity extends AppCompatActivity {

    WeatherViewModel weatherViewModel;
    TextView placeName;
    TextView currentTemp;
    TextView currentSky;
    TextView currentAQI;
    RelativeLayout nowLayout;
    LinearLayout forecastLayout;
    TextView coldRisk;
    TextView dressing;
    TextView ultraviolet;
    TextView carWashing;
    ScrollView weatherLayout;
    SwipeRefreshLayout swipeRefresh;
    DrawerLayout drawerLayout;

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public WeatherViewModel getViewModel() {
        return weatherViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_weather);
        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        placeName = (TextView) findViewById(R.id.placeName);
        currentTemp = (TextView) findViewById(R.id.currentTemp);
        currentSky = (TextView) findViewById(R.id.currentSky);
        currentAQI = (TextView) findViewById(R.id.currentAQI);
        nowLayout = (RelativeLayout) findViewById(R.id.nowLayout);
        forecastLayout = (LinearLayout) findViewById(R.id.forecastLayout);
        coldRisk = (TextView) findViewById(R.id.coldRiskText);
        dressing = (TextView) findViewById(R.id.dressingText);
        ultraviolet = (TextView) findViewById(R.id.ultravioletText);
        carWashing = (TextView) findViewById(R.id.carWashingText);
        weatherLayout = (ScrollView) findViewById(R.id.weatherLayout);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        if (weatherViewModel.getLocationLng().isEmpty()) {
            weatherViewModel.setLocationLng(getIntent().getStringExtra("location_lng"));
        }
        if (weatherViewModel.getLocationLat().isEmpty()) {
            weatherViewModel.setLocationLat(getIntent().getStringExtra("location_lat"));
        }
        if (weatherViewModel.getPlaceName().isEmpty()) {
            weatherViewModel.setPlaceName(getIntent().getStringExtra("place_name"));
        }
        weatherViewModel.getWeatherLiveData().observe(this, new Observer<Weather>() {
            @Override
            public void onChanged(Weather weather) {
                if (weather.getStatus().equals("ok")) {
                    showWeatherInfo(weather);
                } else {
                    Toast.makeText(WeatherActivity.this, "无法成功获取天气信息", Toast.LENGTH_SHORT).show();
                    Log.e("WeatherActivity", weather.getError());
                }
                swipeRefresh.setRefreshing(false);
            }
        });
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        refreshWeather();
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshWeather();
            }
        });
        Button nav = (Button) findViewById(R.id.nav);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(drawerView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void showWeatherInfo(Weather weather) {
        placeName.setText(weatherViewModel.getPlaceName());
        Realtime realtime = weather.getRealtime();
        Daily daily = weather.getDaily();
        // now.xml
        currentTemp.setText(realtime.getTemperature() + " ℃");
        currentSky.setText(Sky.getSky(realtime.getSkycon()).getInfo());
        currentAQI.setText("空气指数 " + realtime.getAirQuality().getAqi().getChn());
        nowLayout.setBackgroundResource(Sky.getSky(realtime.getSkycon()).getBg());
        // forecast.xml
        forecastLayout.removeAllViews();
        int days = daily.getSkycon().size();
        for (int i = 0; i < days; i++) {
            Skycon skycon = daily.getSkycon().get(i);
            Temperature temperature = daily.getTemperature().get(i);
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false);
            TextView dateInfo = (TextView) view.findViewById(R.id.dateInfo);
            ImageView skyIcon = (ImageView) view.findViewById(R.id.skyIcon);
            TextView skyInfo = (TextView) view.findViewById(R.id.skyInfo);
            TextView temperatureInfo = (TextView) view.findViewById(R.id.temperatureInfo);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            dateInfo.setText(simpleDateFormat.format(skycon.getDate()));
            Sky sky = Sky.getSky(skycon.getValue());
            skyIcon.setImageResource(sky.getIcon());
            skyInfo.setText(sky.getInfo());
            temperatureInfo.setText(temperature.getMin() + "~" + temperature.getMax() + " ℃");
            forecastLayout.addView(view);
        }
        // life_index.xml
        LifeIndex lifeIndex = daily.getLifeIndix();
        coldRisk.setText(lifeIndex.getColdRisk().get(0).getDesc());
        dressing.setText(lifeIndex.getDressing().get(0).getDesc());
        ultraviolet.setText(lifeIndex.getUltraviolet().get(0).getDesc());
        carWashing.setText(lifeIndex.getCarWashing().get(0).getDesc());
        weatherLayout.setVisibility(View.VISIBLE);
    }

    public void refreshWeather() {
        weatherViewModel.refreshWeather(weatherViewModel.getLocationLng(), weatherViewModel.getLocationLat());
        swipeRefresh.setRefreshing(true);
    }
}