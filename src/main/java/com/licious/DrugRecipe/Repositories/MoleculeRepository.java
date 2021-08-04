package com.licious.DrugRecipe.Repositories;

import com.licious.DrugRecipe.models.Molecule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoleculeRepository extends JpaRepository {
    List<Molecule> findById(int id);
    List<Molecule> findByMolName(String molName);
}
