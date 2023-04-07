/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplone.cocours.services;

import com.simplone.cocours.entities.Choix;
import com.simplone.cocours.entities.User;

import java.util.List;

public interface ChoixService {

    //creer les choix;
    public int ajouterChoixs(User etudiantPostule);

    //mise a jour des choix de l'etudiant
    public int updateChoixsEtudiants(User etudiantPostule);

    public List<Choix> findByRefConcoursOrderByNumChoix(String refConcours);

    public List<Choix> findByRefConcours(String reference);

    public Choix findByRefChoix(Long id);
}
