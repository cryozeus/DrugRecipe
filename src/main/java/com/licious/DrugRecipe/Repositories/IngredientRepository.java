package com.licious.DrugRecipe.Repositories;

import com.licious.DrugRecipe.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository {
    Ingredient findOneById(int id);
    Ingredient findOneByName(String ingdName);



}
