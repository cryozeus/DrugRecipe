package com.licious.DrugRecipe.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Molecules {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int molID;

    private String molName;
    private  Boolean rxReqd;
}
