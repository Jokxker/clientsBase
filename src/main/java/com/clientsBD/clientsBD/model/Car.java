package com.clientsBD.clientsBD.model;

import lombok.Data;

import java.util.List;

@Data
public class Car {

    private String name;
    private List<Ingredient> ingredients;
}
