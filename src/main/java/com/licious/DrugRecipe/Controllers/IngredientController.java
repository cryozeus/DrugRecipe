package com.licious.DrugRecipe.Controllers;

import com.licious.DrugRecipe.RepositoryService.IngredientService;
import com.licious.DrugRecipe.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    //ADD INGREDIENT
    @PostMapping("/ingd/save")
    private ResponseEntity<Ingredient> addIngredient(@RequestParam Ingredient ingdRes) {
        Ingredient ingd = ingredientService.saveIngredient(ingdRes);
        return new ResponseEntity<>(ingd, HttpStatus.ACCEPTED);
    }

    //GET INGREDIENT(S)
    @RequestMapping("/ingd/list")
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingdAll = ingredientService.getAllIngredients();
        return ingdAll;
    }

    @RequestMapping("/ingd")
    public Ingredient getIngredient(@RequestParam("ingdID") int ingdID) {
        Ingredient ingd = ingredientService.getIngredientById(ingdID);
        return ingd;
    }

    @GetMapping("ingd/name")
    public Ingredient getIngredientByName(@RequestParam("ingdName") String name) {
        Ingredient ingdByName = ingredientService.getIngredientByName(name);
        return ingdByName;
    }


}

