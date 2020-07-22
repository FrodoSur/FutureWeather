package com.example.futureweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.futureweather.info.FutureWeather;
import com.example.futureweather.info.FutureWeatherParam;
import com.example.futureweather.info.Info;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


        private static final String TAG = "MainActivity";

        TextView city;
        TextView mainTemperature;
        TextView windSpeed;
        TextView Pressure;
        ImageView currentWeather;
        Info info;
        FutureWeather weatherCity;
        Button goToWikiBtn;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            RecyclerView weatherList = findViewById(R.id.WeatherList);
            weatherList.setAdapter(new weatherListAdapter());
            weatherList.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            weatherList.setLayoutManager(layoutManager);
            DividerItemDecoration itemDecoration = new DividerItemDecoration(this,LinearLayoutManager.VERTICAL);
            weatherList.addItemDecoration(itemDecoration);
            init();

            Log.d(TAG, "onCreate");
            int id = getIntent().getIntExtra("id", -1);
            updateScreen(id);

        }

        private void init(){
            info = Info.getInstance();
            weatherCity = info.getWeatherCity();
            city = findViewById(R.id.city);
            mainTemperature = findViewById(R.id.currentTempreture);
            currentWeather = findViewById(R.id.currentWeather);
            goToWikiBtn = findViewById(R.id.goToWiki);
            goToWikiBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(v, "Перейти на Wiki", Snackbar.LENGTH_LONG).setAction("Подтвердить", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                goToWiki(weatherCity.getCity());
                            }
                        }).show();
                    }
            });
        }

        private void goToWiki(String city){
            Uri address = Uri.parse("https://ru.wikipedia.org/wiki/" + city);
            Intent linkIntent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(linkIntent);
        }

        private void updateScreen(int id){
            if(weatherCity.getId() == id){
                FutureWeatherParam param = weatherCity.getWeatherParameters();
                city.setText(weatherCity.getCity());
                mainTemperature.setText(param.getTemperature());
                windSpeed.setText(param.getWindPower());
                Pressure.setText(param.getPressure());

                if(param.getCurrentWeather().equals("солнце")){
                    currentWeather.setImageResource(R.drawable.ic_sun);
                }
                else
                {
                    currentWeather.setImageResource(R.drawable.ic_rain);
                }

            }
        }

        public static Intent getIntent(Context context, String key, int id){
            Intent intent = new Intent(context, citieschoose.class);
            intent.putExtra(key, id);
            return intent;
        }

    }