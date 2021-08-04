package com.licious.DrugRecipe.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class MoleculeIngredients {

    @Id
    private int molIngdID;

    //Foreign key to Molecule.molID;
    private int molID;
    //Foreign key to Ingredient.ingdID;
    private int ingdID;


}
