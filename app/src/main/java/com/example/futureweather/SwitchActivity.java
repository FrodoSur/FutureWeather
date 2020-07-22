package com.example.futureweather;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.futureweather.info.FutureWeather;
import com.example.futureweather.info.FutureWeatherParam;
import com.example.futureweather.info.Info;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SwitchActivity extends AppCompatActivity {

    private static final String TAG = "SwitchActivity";
    private Info info;
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?lat=55.75&lon=37.62&appid=";
    private static final String WEATHER_API_KEY = "MY_API_KEY";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        Log.d(TAG, "onCreate");
        init();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                final URL uri = new URL(url.getText().toString());
                final Handler handler = new Handler(); // Запоминаем основной поток
                new Thread(new Runnable() {
                    public void run() {
                        HttpsURLConnection urlConnection = null;
                        try {
                            urlConnection = (HttpsURLConnection) uri.openConnection();
                            urlConnection.setRequestMethod("GET"); // установка метода получения данных -GET
                            urlConnection.setReadTimeout(10000); // установка таймаута - 10 000 миллисекунд
                            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); // читаем  данные в поток
                            final String result = getLines(in);
                            // Возвращаемся к основному потоку
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                }
                            });
                        } catch (Exception e) {
                            Log.e(TAG, "Fail connection", e);
                            e.printStackTrace();
                        } finally {
                            if (null != urlConnection) {
                                urlConnection.disconnect();
                            }
                        }
                    }
                }).start();
            } catch (
        MalformedURLException e) {
                Log.e(TAG, "Fail URI", e);
                e.printStackTrace();
            }
        }


};
public void init(){
        FutureWeatherParam param = new FutureWeatherParam("13 июля", "14 июля", "солнце", "солнце", "дождь", "солнце", "дождь", String.format("%f2", weatherRequest.getMain().getTemp()),"15*С","20*С","21*С","24*С",String.format("%d", weatherRequest.getWind().getSpeed()),String.format("%d", weatherRequest.getMain().getPressure()));
        FutureWeather weatherCity = new FutureWeather(1, "Москва");
        weatherCity.setWeatherParameters(param);
        info = Info.getInstance();
        info.setWeatherCity(weatherCity);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fagment = fm.findFragmentById(R.id.fragment);
        if(fagment == null){
            fagment = new citieschoose();
            fm.beginTransaction().add(R.id.fragment, fagment).commit();
        }
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