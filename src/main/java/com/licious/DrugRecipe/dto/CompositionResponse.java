package com.licious.DrugRecipe.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompositionResponse {
    String compName;
    List<ResponseUtils> responseUtilsList;
    String molName;
    Boolean rxReqd;
}
