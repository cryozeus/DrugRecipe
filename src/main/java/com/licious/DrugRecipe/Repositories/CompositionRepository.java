package com.licious.DrugRecipe.Repositories;

import com.licious.DrugRecipe.models.Composition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompositionRepository extends JpaRepository {
    List<Composition> findById(int id);
    List<Composition> findByCompName(String compName);
}
