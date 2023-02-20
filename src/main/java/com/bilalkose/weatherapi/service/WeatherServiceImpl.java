package com.bilalkose.weatherapi.service;

import com.bilalkose.weatherapi.entity.WeatherForecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;

    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherForecast getDailyWeatherForecast(String address) {
        String apiString = String.format("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s/today?key=%s", address, "V5RRNGTR6S6Q88ZNX5PDM5HN8");
        WeatherForecast weatherForecast = restTemplate.getForObject(apiString, WeatherForecast.class);
        return weatherForecast;
    }

    @Override
    public WeatherForecast getWeeklyWeatherForecast(String address, String date) {
        String apiString = String.format("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s/%s/next7days?key=%s", address, date, "V5RRNGTR6S6Q88ZNX5PDM5HN8");
        WeatherForecast weatherForecast = restTemplate.getForObject(apiString, WeatherForecast.class);
        return weatherForecast;
    }

    @Override
    public WeatherForecast getMonthlyWeatherForecast(String address, String date) {
        LocalDate lt = LocalDate.now();
        String apiString = String.format("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s/%s/next30days?key=%s", address, date, "V5RRNGTR6S6Q88ZNX5PDM5HN8");
        WeatherForecast weatherForecast = restTemplate.getForObject(apiString, WeatherForecast.class);
        return weatherForecast;
    }

    @Override
    public WeatherForecast getWeatherForecastWithDatesRange(String address, String date1, String date2) {
        String apiString = String.format("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s/%s/%s/?key=%s", address, date1, date2, "V5RRNGTR6S6Q88ZNX5PDM5HN8");
        WeatherForecast weatherForecast = restTemplate.getForObject(apiString, WeatherForecast.class);
        return weatherForecast;
    }

    @Override
    public WeatherForecast getWeatherForecastWithDate(String address, String date) {
        String apiString = String.format("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s/%s/?key=%s", address, date, "V5RRNGTR6S6Q88ZNX5PDM5HN8");
        WeatherForecast weatherForecast = restTemplate.getForObject(apiString, WeatherForecast.class);
        return weatherForecast;
    }
}
