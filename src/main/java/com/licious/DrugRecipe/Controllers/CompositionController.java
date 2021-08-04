package com.licious.DrugRecipe.Controllers;

import com.licious.DrugRecipe.RepositoryService.CompositionService;
import com.licious.DrugRecipe.dto.CompositionRequest;
import com.licious.DrugRecipe.dto.CompositionResponse;
import com.licious.DrugRecipe.models.Composition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompositionController {
    @Autowired
    CompositionService compositionService;
    //ADD COMPOSITION(S)
    @PostMapping(value = "/comp/mol")
    public String addCompositionMolecule(@RequestBody List<CompositionRequest> requestList) {
        int counter=0;
        for(CompositionRequest request : requestList) {
            String res = compositionService.addCompositonMol(request);
            if(res == "add Composition successful")
                counter++;
            System.out.println(res);

        }
        return (counter == 1) ? "at least 1 Composition added" : "add Composiiton failed";
    }

    //GET COMPOSITION(S)
    @GetMapping("/comp")
    public CompositionResponse getCompositionByCompId(@RequestParam int compID) {
        return compositionService.getCompositionByCompId(compID);
    }
    @GetMapping("/comp/list")
    public List<Composition> getCompositionByIngredient(@RequestParam String ingdName,
                                                        @RequestParam Float strength,
                                                        @RequestParam String unit) {
        List<Composition> compositionList = compositionService.getCompositionByIngd(ingdName, strength, unit);
        return compositionList;
    }
    @GetMapping("comp/mol")
    public List<Composition> getCompositionByIngredientMolecule(@RequestParam String ingdName,
                                                                @RequestParam Float strength,
                                                                @RequestParam String unit,
                                                                @RequestParam Boolean rxReqd) {
        List<Composition> compositionList = compositionService.getCompositionByIngdMol(ingdName, strength, unit, rxReqd);
        return compositionList;
    }




}
