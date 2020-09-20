package com.goldipl.pizza.web;

import com.goldipl.pizza.Ingredient;
import com.goldipl.pizza.Ingredient.Type;
import com.goldipl.pizza.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignPizzaController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("CALZ", "calzone", Type.DOUGH),
                new Ingredient("THCK", "cienkie ciasto", Type.DOUGH),
                new Ingredient("THIN", "grube ciasto", Type.DOUGH),
                new Ingredient("GOUD", "ser gouda", Type.CHEESE),
                new Ingredient("MASD", "ser masdamer", Type.CHEESE),
                new Ingredient("MOZZ", "ser mozzarella", Type.CHEESE),
                new Ingredient("MHAM", "szynka", Type.MEAT),
                new Ingredient("SALA", "salami", Type.MEAT),
                new Ingredient("CHIC", "kurczak", Type.MEAT),
                new Ingredient("TOMA", "pomidory", Type.VEGGIES),
                new Ingredient("CORN", "kukurydza", Type.VEGGIES),
                new Ingredient("OLIV", "oliwki", Type.VEGGIES),
                new Ingredient("TOMS", "sos pomidorowy", Type.SAUCE),
                new Ingredient("GARS", "sos czosnkowy", Type.SAUCE)
        );

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients,type));
    }
        model.addAttribute("design", new Pizza());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());

    }
}