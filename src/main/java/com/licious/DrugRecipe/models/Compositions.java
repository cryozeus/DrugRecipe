package com.licious.DrugRecipe.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
public class Compositions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int compID;

    private String compName;
}
