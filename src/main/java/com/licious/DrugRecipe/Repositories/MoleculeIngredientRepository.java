package com.licious.DrugRecipe.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoleculeIngredientRepository extends JpaRepository {
    @Query(value = "SELECT ingredient_id FROM molecule_ingredients WHERE molecule_id=1?", nativeQuery = true)
    List<Integer> findAllMoleculeIngdByMolId(int molID);
}
