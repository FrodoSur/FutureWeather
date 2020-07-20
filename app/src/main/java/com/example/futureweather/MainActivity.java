package com.example.futureweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

<<<<<<< Updated upstream
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
=======
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
>>>>>>> Stashed changes
