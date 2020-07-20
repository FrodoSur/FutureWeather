package com.example.futureweather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futureweather.info.FutureWeather;
import com.example.futureweather.info.FutureWeatherParam;
import com.example.futureweather.info.Info;

import java.util.ArrayList;
import java.util.List;

public class weatherListAdapter extends RecyclerView.Adapter {
    class DayViewHolder extends RecyclerView.ViewHolder{
        TextView Date;
        TextView Temperature;
        ImageView Weather;
        public DayViewHolder(@NonNull View itemView) {
            super(itemView);
            Date = itemView.findViewById(R.id.dateName);
            Temperature = itemView.findViewById(R.id.tempName);
            Weather = itemView.findViewById(R.id.weatherName);
        }
        void bind(String date, String temperature, String weather){
            Date.setText(date);
            Temperature.setText(temperature);
            if(weather.equals("солнце")){
                Weather.setImageResource(R.drawable.ic_sun);
            }
            else
            {
                Weather.setImageResource(R.drawable.ic_rain);
            }

        }
    }
    private FutureWeatherParam param = Info.getInstance().getWeatherCity().getWeatherParameters();
    private List<String> weatherList = new ArrayList<String>() {
        {
            add(param.getFirstWeather());
            add(param.getSecondWeather());
            add(param.getThirdWeather());
            add(param.getFourthWeather());
        }
    };
    private List<String> tempretureList = new ArrayList<String>() {
        {
            add(param.getFirstTempreture());
            add(param.getSecTempreture());
            add(param.getThirTempreture());
            add(param.getFourTempreture());
        }
    };
    private List<String> dateList = new ArrayList<String>() {
        {
            add("Cегодня");
            add("Завтра");
            add(param.getThirdDate());
            add(param.getFourthDate());
        }
    };
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DayViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((DayViewHolder)holder).bind(dateList.get(position),tempretureList.get(position),weatherList.get(position));
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }
}
