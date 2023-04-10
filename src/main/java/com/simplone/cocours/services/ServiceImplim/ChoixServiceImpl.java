package com.simplone.cocours.services.ServiceImplim;

import com.simplone.cocours.entities.Choix;
import com.simplone.cocours.entities.User;
import com.simplone.cocours.repository.ChoixRepository;
import com.simplone.cocours.services.ChoixService;

import java.util.List;

public class ChoixServiceImpl implements ChoixService {
    private final ChoixRepository choixRepository;

    public ChoixServiceImpl(ChoixRepository choixRepository) {
        this.choixRepository = choixRepository;
    }

    @Override
    public int ajouterChoixs(User etudiantPostule) {
        if (etudiantPostule == null) {
            return -3;
        } else if (etudiantPostule.getChoixs() == null || etudiantPostule.getChoixs().isEmpty()) {
            return -4;
        } else {
            for (Choix choix : etudiantPostule.getChoixs()) {
                choix.setEtudiantPostule(etudiantPostule);
                choixRepository.save(choix);
            }
            return 1;
        }
    }

    @Override
    public int updateChoixsEtudiants(User etudiantPostule) {
        if (etudiantPostule.getChoixs() == null || etudiantPostule.getChoixs().isEmpty()) {
            return -1;
        } else {
            for (Choix choix : etudiantPostule.getChoixs()) {
                Choix c = choixRepository.findByNumChoixAndAndEtudiantPostuleCne(choix.getNumChoix(), etudiantPostule.getCne());
                c.setConcours(choix.getConcours());
                choixRepository.save(c);
            }
            return 1;
        }    }

    @Override
    public List<Choix> findByRefConcoursOrderByNumChoix(String refConcours) {
        return null;
    }

    @Override
    public List<Choix> findByRefConcours(String reference) {
        return (List<Choix>) this.choixRepository.findByConcoursOrderByEtudiantPostuleDesc(reference);
    }

    @Override
    public Choix findByRefChoix(Long id) {
        return this.choixRepository.getOne(id);
    }
}
