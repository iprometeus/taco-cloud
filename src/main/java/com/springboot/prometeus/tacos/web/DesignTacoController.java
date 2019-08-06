package com.springboot.prometeus.tacos.web;

import com.springboot.prometeus.tacos.data.IngredientRepository;
import com.springboot.prometeus.tacos.data.TacoRepository;
import com.springboot.prometeus.tacos.domain.Ingredient;
import com.springboot.prometeus.tacos.domain.Ingredient.Type;
import com.springboot.prometeus.tacos.domain.Order;
import com.springboot.prometeus.tacos.domain.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo,
            TacoRepository designRepo) {

        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {

        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {

        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {

        List<Ingredient> ingredients = new ArrayList<>();

        ingredientRepo.findAll().forEach(ingredients::add);

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                               filterByType(ingredients, type));
        }

        return "design";
    }

    @PostMapping
    public String processDesign(
            Taco taco, Errors errors,
            @ModelAttribute
                    Order order) {

        if (errors.hasErrors()) {
            return "design";
        }
        Taco saved = designRepo.save(taco);
        order.addDesign(saved);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {

        return ingredients.stream()
                          .filter(i -> type.equals(i.getType()))
                          .collect(Collectors.toList());
    }
}