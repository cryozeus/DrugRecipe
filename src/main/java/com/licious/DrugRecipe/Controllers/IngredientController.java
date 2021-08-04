package com.licious.DrugRecipe.Controllers;

import com.licious.DrugRecipe.RepositoryService.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;


}
