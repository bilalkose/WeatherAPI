package com.bilalkose.weatherapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Day {
    private String datetime;
    private float tempmax;
    private float tempmin;
    private float temp;
    private float feelslikemax;
    private float feelslikemin;
    private float feelslike;
    private float humidity;
    private String conditions;
    private String description;
    private List<Hour> hours;
}
