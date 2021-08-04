package com.licious.DrugRecipe.RepositoryService;

import com.licious.DrugRecipe.Repositories.*;
import com.licious.DrugRecipe.dto.CompositionRequest;
import com.licious.DrugRecipe.dto.CompositionResponse;
import com.licious.DrugRecipe.dto.ResponseUtils;
import com.licious.DrugRecipe.models.*;
import com.licious.DrugRecipe.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompositionService {

    @Autowired
    private CompositionIngredientRepository compositionIngredientRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private MoleculeIngredientRepository moleculeIngredientRepository;
    @Autowired
    private MoleculeRepository moleculeRepository;
    @Autowired
    private CompositionRepository compositionRepository;

    public CompositionResponse getCompositionByCompId(int compID) {
        CompositionResponse compResponse = new CompositionResponse();
        /* LOGIC */
        String compName = compositionRepository.findById(compID).get().getCompName();


        return compResponse;

    }

    public Molecule findMoleculeByIngd(List<Integer> ingdIdList) {
        List<Molecule> moleculeList = moleculeRepository.findAll();

        for(Molecule molecule : moleculeList) {
            List<Integer> moleculeIngdIdList = moleculeIngredientRepository.findAllMoleculeIngdByMolId(molecule.getMolID());
            if(moleculeIngdIdList.containsAll(ingdIdList) && ingdIdList.containsAll(moleculeIngdIdList)) {
                return moleculeRepository.getById(molecule.getMolID());
            }
        }
        return null;
    }

    public List<Composition> getCompositionByIngd(String ingdName, Float strength, String unit) {
        //Get Ingredient ID, get all ingredients
        int ingdID = ingredientRepository.findOneByName().get().getIngdID();
        List<Integer> compIdList = compositionIngredientRepository.findAllByIngdStrengthUnit(ingdID, strength, unit);
        List<Composition> compositionList = new ArrayList<>();
        //for every ingredient in composition
        for(Integer compID : compIdList) {
            //find and append composition to List to be returned
            Composition comp = compositionRepository.findById(compID).get();
            compositionList.add(comp);
        }
        return compositionList;
    }

    public List<Composition> getCompositionByIngdMol(String ingdName, Float strength, String unit, Boolean rxReqd) {
        int ingdID = ingredientRepository.findOneByName(ingdName).get().getId();
        List<Integer> compIdList = compositionIngredientRepository.findAllCompByIngdMol(ingdID, strength, unit, rxReqd);
        List<Composition> compList = new ArrayList<>();
        for(Integer compID : compIdList) {
            Composition comp = compositionRepository.findById(compID).get();
            compList.add(comp);
        }
        return compList;
    }





    public String addCompositonMol(CompositionRequest requestDTO){
        System.out.println(requestDTO.getIngd());
        List<String> existingIngredientNames=getIngredientNames();
        List<String> existingMoleculeNames=getMoleculeNames();
        List<String> existingCompositionNames=getCompositeNames();

        List<ResponseUtils> responseUtilsList =requestDTO.getIngd();
        for(ResponseUtils ingredient: responseUtilsList){
            String ingredientName=ingredient.getName();
            float strength=ingredient.getStrength();
            String unit=ingredient.getUnit();
            if(existingIngredientNames.indexOf(ingredientName)==-1){
                Ingredient ingredient1=new Ingredient();
                ingredient1.setIngdName(ingredientName);
                ingredientRepository.save(ingredient1);
            }

        }
        List<String> ingredientNameList= responseUtilsList
                .stream().map(i->i.getName()).collect(Collectors.toList());

        String moleculeName= Utils.createMoleculeName(ingredientNameList);
        String compositionName=Utils.createCompositionName(responseUtilsList);
        if(existingMoleculeNames.indexOf(moleculeName)==-1){
            Molecule molecule=new Molecule();
            molecule.setMolName(moleculeName);
            molecule.setRxReqd(requestDTO.isRxReqd());
            moleculeRepository.save(molecule);
        }
        Molecule molecule=moleculeRepository.findByMolName(moleculeName).get();
        int moleculeId=molecule.getMolID();
        if(existingCompositionNames.indexOf(compositionName)>0) {
            return "Duplicate Composition Found!";
        }
        else {
            Composition composition=new Composition();
            composition.setCompName(compositionName);
            compositionRepository.save(composition);
        }
        Composition composition=compositionRepository.findOneByName(compositionName).get();
        int compositionId=composition.getCompID();
        for(ResponseUtils ingredientDetail: responseUtilsList){
            Ingredient ingredient=ingredientRepository.findOneByName(ingredientDetail.getName()).get();

            composition=null;
            composition=compositionRepository.findById(compositionId).get();

            CompositionIngredient compositionIngredient =new CompositionIngredient();
            compositionIngredient.setComp(composition);
            compositionIngredient.setIngd(ingredient);
            compositionIngredient.setStrength(ingredientDetail.getStrength());
            compositionIngredient.setUnit(ingredientDetail.getUnit());
            compositionIngredientRepository.save(compositionIngredient);

            MoleculeIngredient moleculeIngredient=new MoleculeIngredient();
            moleculeIngredient.setMol(molecule);
            moleculeIngredient.setIngd(ingredient);
            moleculeIngredientRepository.save(moleculeIngredient);

        }
        return "add Composition successful";
    }
    public List<String> getIngredientNames(){
        return ingredientRepository.findAll().stream().map(t->t.getName()).collect(Collectors.toList());
    }
    public List<String> getMoleculeNames(){
        return moleculeRepository.findAll().stream().map(t->t.getName()).collect(Collectors.toList());
    }
    public List<String> getCompositeNames(){
        return compositionRepository.findAll().stream().map(t->t.getName()).collect(Collectors.toList());
    }






}
