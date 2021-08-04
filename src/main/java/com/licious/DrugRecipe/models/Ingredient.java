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
@Table(name="ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ingdID;

    private String ingdName;
    private List<CompositionIngredients> compIngdList;
    private List<MoleculeIngredients> molIngdList;
}
