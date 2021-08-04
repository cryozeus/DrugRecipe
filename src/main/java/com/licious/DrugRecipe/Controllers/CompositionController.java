package com.licious.DrugRecipe.Controllers;

import com.licious.DrugRecipe.RepositoryService.CompositionService;
import com.licious.DrugRecipe.dto.CompositionResponse;
import com.licious.DrugRecipe.models.Composition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

public class CompositionController {
    @Autowired
    CompositionService compositionService;

    public CompositionResponse getCompositionByCompId(@RequestParam int compID) {
        return compositionService.getComposition
    }



}
