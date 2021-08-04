package com.licious.DrugRecipe.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompositionIngredientRepository extends JpaRepository {

    @Query(value="SELECT DISTINCT composition_id FROM composition_ingredients WHERE ingredient_id=?1 AND strength=2? AND unit=3?", nativeQuery = true)
    List<Integer> findAllByIngdStrengthUnit(int ingdID, float strength, String unit);

    @Query(value = "SELECT * FROM composition_ingredients INNER JOIN ingredients ON ingredient_id=ingredients.id WHERE composition_id=1?", nativeQuery = true)
    List<Integer> findAllIngdByCompId(int compID);

    @Query(name = "SELECT DISTINCT composition_ingredients.composition_id FROM compositions"
            +" INNER JOIN composition_ingredients ON compositions.id=composition_ingredients.composition_id"
            +" INNER JOIN molecule_ingredients ON composition_ingredients.ingredient_id=molecule_ingredients.ingredient_id"
            +" INNER JOIN molecules ON molecule_ingredients.molecule_id=molecules.id"
            +" WHERE(molecule_ingredients.ingredient_id=?1 and strength=?2 and unit=?3 and molecules.rx_required=?4);")
    List<Integer> findAllCompByIngdMol(int ingdID, float strength, boolean rxReqd);

}
