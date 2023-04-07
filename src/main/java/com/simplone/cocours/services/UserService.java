package com.simplone.cocours.services;


import com.simplone.cocours.entities.User;

import java.util.List;

public interface UserService {
    // inscrire un nouveau etudiant
    public int sinscrire(User etudiantConcours);

    //trouver etudiant en se basant sur son cne
    public User findByCne(String cne);

    //supprimer etudiant
    public int removeEtudiant(String cne);

    //trouver tous les etudiants
    public List<User> findAll();

    //mise a jour d'un etudiant
    public int updateEtudiant(User etudiantPostule);

    //trouver la listes des etudiant qui ont postulé pour le meme concours
    public List<User> findByRefConcours(String reference);
}
