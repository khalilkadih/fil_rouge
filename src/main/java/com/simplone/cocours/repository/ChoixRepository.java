package com.simplone.cocours.repository;

import com.simplone.cocours.entities.Choix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoixRepository extends JpaRepository<Choix,Long> {
    Choix findByNumChoixAndAndEtudiantPostuleCne(int numChoix,String cne);
    List<Choix> findByConcours(String references);
    Choix findByRefConcoursOrderByEtudiantPostuleDiplomeEtudiantNoteDesc(String reference);


}
