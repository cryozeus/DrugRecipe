package com.licious.DrugRecipe.Repositories;

import com.licious.DrugRecipe.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository {
    List<Ingredient> findAllById(int id);
    List<Ingredient> findByIngdName(String ingdName);
    Ingredient deleteById(int id);
    List<Ingredient> deleteByIngdName(String ingdName);


}
