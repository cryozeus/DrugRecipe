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

    public List<Ingredient> getIngredientById(int id) {
        return ingredientRepository.findAllById(id);
    }


}
