package com.springboot.prometeus.tacos.web;

import java.util.ArrayList;
import java.util.List;

import com.springboot.prometeus.tacos.data.IngredientRepository;
import com.springboot.prometeus.tacos.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public IngredientConverter(IngredientRepository ingredientRepo) {

        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String source) {

        List<Ingredient> ingredients = new ArrayList<>();

        ingredientRepo.findAll().forEach(ingredients::add);

        for (Ingredient ingredient : ingredients) {

            // You may use equal() method
            if (ingredient.getId().equals(source))

            {
                return ingredient;
            }
        }

        return null;
    }
}