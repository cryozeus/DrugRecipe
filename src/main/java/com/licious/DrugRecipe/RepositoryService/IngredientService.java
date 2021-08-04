package com.licious.DrugRecipe.RepositoryService;

import com.licious.DrugRecipe.Repositories.IngredientRepository;
import com.licious.DrugRecipe.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    //Get Ingredient(s)
    public Ingredient getIngredientById(int id) {
        return ingredientRepository.findOneById(id);
    }
    public Ingredient getIngredientByName(String name) {
        return ingredientRepository.findByName(name);
    }
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
    //Add Ingredient(s)
    public void addIngredient(Ingredient ingd) {
        ingredientRepository.save(ingd);
    }
    public Ingredient saveIngredient(Ingredient ingd) {
        return (Ingredient) ingredientRepository.save(ingd);
    }



}
