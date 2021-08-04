package com.licious.DrugRecipe.Repositories;

import com.licious.DrugRecipe.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository {
    List<Ingredient> findById(int id);
    List<Ingredient> findByIngdName(String ingdName);
    Ingredient deleteById(int id);
    List<Ingredient> deleteByIngdName(String ingdName);
}
