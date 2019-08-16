package com.springboot.prometeus.tacos.data.jpa;

import com.springboot.prometeus.tacos.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}