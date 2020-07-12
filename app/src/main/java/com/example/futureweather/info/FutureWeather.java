package com.example.futureweather.info;


public class FutureWeather {

    private int id;
    private String city;
    private FutureWeatherParam weatherParameters;
    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public FutureWeather(int id, String city){
        this.id = id;
        this.city = city;
    }
    public FutureWeatherParam getWeatherParameters() {
        return weatherParameters;
    }
    public void setWeatherParameters(FutureWeatherParam weatherParameters) {
        this.weatherParameters = weatherParameters;
    }
}