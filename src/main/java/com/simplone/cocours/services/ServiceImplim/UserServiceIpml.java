package com.simplone.cocours.services.ServiceImplim;

import com.simplone.cocours.entities.Choix;
import com.simplone.cocours.entities.User;
import com.simplone.cocours.repository.ConcoursRepository;
import com.simplone.cocours.repository.UserRepository;
import com.simplone.cocours.services.ChoixService;
import com.simplone.cocours.services.DiplomeEtudiantService;
import com.simplone.cocours.services.NotesSemestreService;
import com.simplone.cocours.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIpml implements UserService {
    private final ChoixService choixService;
    private final UserRepository userRepository;
    private final ConcoursRepository concoursRepository;
    private final NotesSemestreService notesSemestreService;
    private final DiplomeEtudiantService diplomeEtudiantService;

    public UserServiceIpml(ChoixService choixService, UserRepository userRepository, ConcoursRepository concoursRepository, NotesSemestreService notesSemestreService, DiplomeEtudiantService diplomeEtudiantService) {
        this.choixService = choixService;
        this.userRepository = userRepository;
        this.concoursRepository = concoursRepository;
        this.notesSemestreService = notesSemestreService;
        this.diplomeEtudiantService = diplomeEtudiantService;
    }

    @Override
    public int sinscrire(User etudiantConcours) {
        User e = findByCne(etudiantConcours.getCne());
        if (e != null) {
            return -1;
        }
        if (validateChoixs(etudiantConcours.getChoixs()) == false) {
            return -2;
        } else {

            diplomeEtudiantService.ajouterDiplome(etudiantConcours);
            etudiantConcours.setCne(etudiantConcours.getCne().toLowerCase());

            etudiantConcours.setFirstName(etudiantConcours.getFirstName().toUpperCase());
            etudiantConcours.setLastName(etudiantConcours.getLastName().toLowerCase());


            etudiantConcours.setEmail(etudiantConcours.getEmail().toLowerCase());
            userRepository.save(etudiantConcours);
            //   ajouter les choixs de cet etudiant
            choixService.ajouterChoixs(etudiantConcours);
            //  ajoute les note semestre de cet etudiant
            notesSemestreService.CreerNotesSemestre(etudiantConcours);
            return 1;
        }    }

    @Override
    public User findByCne(String cne) {
        return null;
    }

    @Override
    public int removeEtudiant(String cne) {
        return 0;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public int updateEtudiant(User etudiantPostule) {
        User ep = findByCne(etudiantPostule.getCne());
        if (ep == null) {
            return -1;
        } else {
            ep.setAdressPersonnelle(etudiantPostule.getAdressPersonnelle());
            ep.setCin(etudiantPostule.getCin());
            ep.setFirstName(etudiantPostule.getFirstName());
            ep.setLastName(etudiantPostule.getLastName());
            ep.setCne(etudiantPostule.getCne());
            ep.setTelephone(etudiantPostule.getTelephone());
            ep.setEmail(etudiantPostule.getEmail());
            ep.setNiveau(etudiantPostule.getNiveau());
            choixService.updateChoixsEtudiants(etudiantPostule);
            notesSemestreService.updateNotesSemestre(etudiantPostule);
            diplomeEtudiantService.updateDiplomeEtudiant(etudiantPostule);
            userRepository.save(ep);
            return 1;
        }
    }

    @Override
    public List<User> findByRefConcours(String reference) {
        List<User> etudiantPostules = new ArrayList<>();
        for (Choix choix : this.choixService.findByRefConcoursOrderByNumChoix(reference)) {
            etudiantPostules.add(choix.getEtudiantPostule());
        }
        return etudiantPostules;
    }


    public boolean validateChoixs(List<Choix> choixs) {
        if (choixs == null || choixs.isEmpty()) {
            return false;
        } else {
            int cmp = 0;
            for (Choix choix : choixs) {
                if (concoursRepository.findByReference(choix.getConcours().toString()) != null) {
                    cmp++;
                }
            }
            return (cmp == choixs.size());
        }
    }
}
