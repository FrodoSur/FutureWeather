package com.example.futureweather;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.futureweather.info.FutureWeather;
import com.example.futureweather.info.FutureWeatherParam;
import com.example.futureweather.info.Info;

public class SwitchActivity extends AppCompatActivity {

    private static final String TAG = "SwitchActivity";
    private TextView CityButton;
    private Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        Log.d(TAG, "onCreate");
        init();
        CityButton = findViewById(R.id.FirstCity);
        CityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.getIntent(SwitchActivity.this, "id", info.getWeatherCity().getId()));
            }
        });
    }

    public void init(){
        FutureWeatherParam param = new FutureWeatherParam("13 июля", "14 июля", "солнце", "солнце", "дождь", "солнце", "дождь", "18*С","15*С","20*С","21*С","24*С","3.2 м/с ЮЗ","743 мм рт. ст.");
        FutureWeather weatherCity = new FutureWeather(1, "Москва");
        weatherCity.setWeatherParameters(param);
        info = Info.getInstance();
        info.setWeatherCity(weatherCity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }


}
