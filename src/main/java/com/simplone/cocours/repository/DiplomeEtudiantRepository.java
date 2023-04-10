package com.simplone.cocours.repository;

import com.simplone.cocours.entities.Choix;
import com.simplone.cocours.entities.DiplomeEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiplomeEtudiantRepository extends JpaRepository<DiplomeEtudiant,Long> {
    /*Choix findByNumChoixAndAndEtudiantPostuleCne(int numChoix,String cne);*/
    /*List<Choix> findByConcours(String references);*/


}
