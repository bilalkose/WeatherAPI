package com.bilalkose.weatherapi.controller;

import com.bilalkose.weatherapi.entity.WeatherForecast;
import com.bilalkose.weatherapi.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@RequestMapping("/weather")
@Validated
@RestController
public class WeatherController {
private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/daily/{address}")
    public ResponseEntity<WeatherForecast> getDailyWeatherForecast(@PathVariable @NotEmpty String address){
        return ResponseEntity.ok(weatherService.getDailyWeatherForecast(address));
    }

    @GetMapping("/weekly/{address}/{date}")
    public ResponseEntity<WeatherForecast> getWeeklyWeatherForecast(@PathVariable String address, @PathVariable String date){
        return ResponseEntity.ok(weatherService.getWeeklyWeatherForecast(address, date));
    }

    @GetMapping("/monthly/{address}/{date}")
    public ResponseEntity<WeatherForecast> getMonthlyWeatherForecast(@PathVariable String address, @PathVariable String date){
        return ResponseEntity.ok(weatherService.getMonthlyWeatherForecast(address, date));
    }

    @GetMapping("/weather/{address}/{date1}/{date2}")
    public ResponseEntity<WeatherForecast> getWeatherForecastWithDatesRange(@PathVariable String address, @PathVariable String date1, @PathVariable String date2){
        return ResponseEntity.ok(weatherService.getWeatherForecastWithDatesRange(address,date1,date2));
    }

    @GetMapping("/{address}/{date}")
    public ResponseEntity<WeatherForecast> getWeatherForecastWithDate(@PathVariable String address, @PathVariable String date){
        return ResponseEntity.ok(weatherService.getWeatherForecastWithDate(address,date));
    }


}
