package com.licious.DrugRecipe.models;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="composition_ingredients")
public class CompositionIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int compIngrID;

    //add foreign key to Composition.compID
    @JoinColumn(name = "composition_id", referencedColumnName = "compID")
    private Composition comp;
    //add foreign key to Ingredient.ingdID
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingdID")
    private Ingredient ingd;

    private String unit;
    private Float strength;
}
