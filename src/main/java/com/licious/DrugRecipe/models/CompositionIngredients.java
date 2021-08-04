package com.licious.DrugRecipe.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CompositionIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int compIngrID;

    //add foreign key to Compositions.compID
    private int compID;
    //add foreign key to Ingredients.ingdID
    private int ingdID;
    private String unit;
    private Float strength;
}
