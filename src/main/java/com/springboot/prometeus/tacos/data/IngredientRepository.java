package com.springboot.prometeus.tacos.data;

import com.springboot.prometeus.tacos.domain.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}