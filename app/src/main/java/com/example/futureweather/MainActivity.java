package com.example.futureweather;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.futureweather.info.FutureWeather;
import com.example.futureweather.info.FutureWeatherParam;
import com.example.futureweather.info.Info;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private static final String TAG = "MainActivity";

        TextView city;
        TextView mainTemperature;
        TextView windSpeed;
        TextView Pressure;
        ImageView currentWeather;
        TextView firstTemperature;
        ImageView firstWeather;
        TextView secondTemperature;
        ImageView secondWeather;
        TextView thirdDate;
        TextView thirdTemperature;
        ImageView thirdWeather;
        TextView fourthDate;
        TextView fourthTemperature;
        ImageView fourthWeather;
        Info info;
        FutureWeather weatherCity;
        Button goToWikiBtn;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
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
            firstTemperature = findViewById(R.id.FirstTemp);
            secondTemperature = findViewById(R.id.SecondTemp);
            thirdTemperature = findViewById(R.id.ThirdTemp);
            fourthTemperature = findViewById(R.id.FourTemp);
            thirdDate = findViewById(R.id.DayThree);
            fourthDate = findViewById(R.id.DayFour);
            currentWeather = findViewById(R.id.currentWeather);
            firstWeather = findViewById(R.id.FirstWeather);
            secondWeather = findViewById(R.id.Secondweather);
            thirdWeather = findViewById(R.id.ThirdWeather);
            fourthWeather = findViewById(R.id.FourWeather);
            goToWikiBtn = findViewById(R.id.goToWiki);
            goToWikiBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToWiki(weatherCity.getCity());
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
                firstTemperature.setText(param.getFirstTempreture());
                secondTemperature.setText(param.getSecTempreture());
                thirdTemperature.setText(param.getThirTempreture());
                fourthTemperature.setText(param.getFourTempreture());
                thirdDate.setText(param.getThirdDate());
                fourthDate.setText(param.getFourthDate());
                if(param.getCurrentWeather().equals("солнце")){
                    currentWeather.setImageResource(R.drawable.ic_sun);
                }
                else
                {
                    currentWeather.setImageResource(R.drawable.ic_rain);
                }
                if(param.getFirstWeather().equals("солнце")){
                    firstWeather.setImageResource(R.drawable.ic_sun);
                }
                else
                {
                    firstWeather.setImageResource(R.drawable.ic_rain);
                }
                if(param.getSecondWeather().equals("солнце")){
                    secondWeather.setImageResource(R.drawable.ic_sun);
                }
                else
                {
                    secondWeather.setImageResource(R.drawable.ic_rain);
                }
                if(param.getThirdWeather().equals("солнце")){
                    thirdWeather.setImageResource(R.drawable.ic_sun);
                }
                else
                {
                    thirdWeather.setImageResource(R.drawable.ic_rain);
                }
                if(param.getCurrentWeather().equals("солнце")){
                    fourthWeather.setImageResource(R.drawable.ic_sun);
                }
                else
                {
                    fourthWeather.setImageResource(R.drawable.ic_rain);
                }
            }
        }

        public static Intent getIntent(Context context, String key, int id){
            Intent intent = new Intent(context, SwitchActivity.class);
            intent.putExtra(key, id);
            return intent;
        }

    }