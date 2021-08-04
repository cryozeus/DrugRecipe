package com.licious.DrugRecipe.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="compositions")
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int compID;

    private String compName;

    private List<CompositionIngredients> compIngdList;
}
