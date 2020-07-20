package com.example.futureweather.info;
public class Info {

        private static Info instance;

        private FutureWeather City;

        public static Info getInstance(){
            if(instance == null) {
                instance = new Info();
            }
            return instance;
        }

        public FutureWeather getWeatherCity() {
            return City;
        }

        public void setWeatherCity(FutureWeather City) {
            this.City = City;
        }
}
