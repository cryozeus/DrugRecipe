package com.licious.DrugRecipe.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompositionRequest {
    private List<ResponseUtils> ingd;
    private Boolean rxReqd;
}
