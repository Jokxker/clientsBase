package com.clientsBD.clientsBD.controller;

import com.clientsBD.clientsBD.model.Car;
import com.clientsBD.clientsBD.model.ChangeOrder;
import com.clientsBD.clientsBD.model.Ingredient;
import com.clientsBD.clientsBD.model.Ingredient.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("clientOrder")
public class DesignClientController {
    @ModelAttribute
    public void addFiltersToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("TOY", "Oil", Type.OIL),
                new Ingredient("FORD", "Oil", Type.OIL)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "changeOrder")
    public ChangeOrder order() {
        return new ChangeOrder();
    }

    @ModelAttribute(name = "Car")
    public Car car() {
        return new Car();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
