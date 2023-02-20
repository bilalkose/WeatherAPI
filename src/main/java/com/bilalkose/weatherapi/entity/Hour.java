package com.bilalkose.weatherapi.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hour {
    private String datetime;
    private float temp;
    private float feelslike;
    private float humidity;
    private String conditions;
}
