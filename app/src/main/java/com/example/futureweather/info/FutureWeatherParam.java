package com.example.futureweather.info;

public class FutureWeatherParam {
    private String thirdDate;
    private String fourthDate;
    private String currentWeather;
    private String firstWeather;
    private String secondWeather;
    private String ThirdWeather;
    private String FourthWeather;
    private String Temperature;
    private String FirstTempreture;
    private String SecTempreture;
    private String ThirTempreture;
    private String FourTempreture;
    private String windPower;
    private String pressure;

    public FutureWeatherParam(String thirdDate, String fourthDate, String currentWeather, String firstWeather, String secondWeather, String thirdWeather, String fourthWeather, String temperature, String firstTempreture, String secTempreture, String thirTempreture, String fourTempreture, String windPower, String pressure) {
        this.setThirdDate(thirdDate);
        this.fourthDate = fourthDate;
        this.currentWeather = currentWeather;
        this.firstWeather = firstWeather;
        this.secondWeather = secondWeather;
        ThirdWeather = thirdWeather;
        FourthWeather = fourthWeather;
        Temperature = temperature;
        FirstTempreture = firstTempreture;
        SecTempreture = secTempreture;
        ThirTempreture = thirTempreture;
        FourTempreture = fourTempreture;
        this.windPower = windPower;
        this.pressure = pressure;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }


    public String getFirstTempreture() {
        return FirstTempreture;
    }

    public void setFirstTempreture(String firstTempreture) {
        FirstTempreture = firstTempreture;
    }

    public String getSecTempreture() {
        return SecTempreture;
    }


    public void setSecTempreture(String secTempreture) {
        SecTempreture = secTempreture;
    }

    public String getThirTempreture() {
        return ThirTempreture;
    }

    public void setThirTempreture(String thirTempreture) {
        ThirTempreture = thirTempreture;
    }

    public String getFourTempreture() {
        return FourTempreture;
    }

    public void setFourTempreture(String fourTempreture) {
        FourTempreture = fourTempreture;
    }

    public String getThirdDate() {
        return thirdDate;
    }

    public void setThirdDate(String thirdDate) {
        this.thirdDate = thirdDate;
    }

    public String getFourthDate() {
        return fourthDate;
    }

    public void setFourthDate(String fourthDate) {
        this.fourthDate = fourthDate;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public String getFirstWeather() {
        return firstWeather;
    }

    public void setFirstWeather(String firstWeather) {
        this.firstWeather = firstWeather;
    }

    public String getSecondWeather() {
        return secondWeather;
    }

    public void setSecondWeather(String secondWeather) {
        this.secondWeather = secondWeather;
    }

    public String getThirdWeather() {
        return ThirdWeather;
    }

    public void setThirdWeather(String thirdWeather) {
        ThirdWeather = thirdWeather;
    }

    public String getFourthWeather() {
        return FourthWeather;
    }

    public void setFourthWeather(String fourthWeather) {
        FourthWeather = fourthWeather;
    }
}

