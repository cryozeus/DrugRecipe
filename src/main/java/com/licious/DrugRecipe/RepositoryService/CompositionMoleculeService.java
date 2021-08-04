package com.licious.DrugRecipe.RepositoryService;

import com.licious.DrugRecipe.Repositories.*;
import com.licious.DrugRecipe.models.Composition;
import org.hibernate.dialect.IngresDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompositionMoleculeService {

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

}
