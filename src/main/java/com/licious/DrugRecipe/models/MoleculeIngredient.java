package com.licious.DrugRecipe.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="molecules_ingredients")
public class MoleculeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int molIngdID;

    //Foreign key to Molecule.molID;
    @JoinColumn(name = "molecule_id", referencedColumnName = "molID")
    private Molecule mol;
    //Foreign key to Ingredient.ingdID;
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingdID")
    private Ingredient ingd;


}
