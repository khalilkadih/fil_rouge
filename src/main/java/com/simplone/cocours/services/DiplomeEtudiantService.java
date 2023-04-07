/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplone.cocours.services;


import com.simplone.cocours.entities.User;

public interface DiplomeEtudiantService {

    public int ajouterDiplome(User etudiantPostule);
    public int updateDiplomeEtudiant(User etudiantPostule);
}
