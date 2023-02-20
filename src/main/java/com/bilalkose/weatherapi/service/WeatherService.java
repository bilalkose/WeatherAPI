package com.bilalkose.weatherapi.service;
import com.bilalkose.weatherapi.entity.WeatherForecast;

public interface WeatherService {
    WeatherForecast getDailyWeatherForecast(String address);

    WeatherForecast getWeeklyWeatherForecast(String address, String date);

    WeatherForecast getMonthlyWeatherForecast(String address, String date);

    WeatherForecast getWeatherForecastWithDatesRange(String address, String date1, String date2);

    WeatherForecast getWeatherForecastWithDate(String address, String date);
}
