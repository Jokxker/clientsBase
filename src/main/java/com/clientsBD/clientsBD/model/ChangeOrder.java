package com.clientsBD.clientsBD.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChangeOrder {
    private String brandCar;
    private String modelCar;
    private String dateChange;
    private String sumPrice;

    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        this.cars.add(car);
    }
}
