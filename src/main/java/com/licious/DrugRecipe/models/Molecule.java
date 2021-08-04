package com.licious.DrugRecipe.models;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="molecules")
public class Molecule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int molID;

    private String molName;
    private  Boolean rxReqd;
}
