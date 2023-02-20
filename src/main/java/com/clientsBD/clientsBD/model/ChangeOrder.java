package com.clientsBD.clientsBD.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChangeOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCW;

    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        this.cars.add(car);
    }
}
