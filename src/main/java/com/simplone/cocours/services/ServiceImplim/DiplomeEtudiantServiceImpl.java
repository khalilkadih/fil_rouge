package com.simplone.cocours.services.ServiceImplim;

import com.simplone.cocours.entities.DiplomeEtudiant;
import com.simplone.cocours.entities.Mention;
import com.simplone.cocours.entities.NotesSemestre;
import com.simplone.cocours.entities.User;
import com.simplone.cocours.repository.DiplomeEtudiantRepository;
import com.simplone.cocours.services.DiplomeEtudiantService;

import java.text.DecimalFormat;

public class DiplomeEtudiantServiceImpl implements DiplomeEtudiantService {

    private final DiplomeEtudiantRepository diplomeEtudiantRepository;

    public DiplomeEtudiantServiceImpl(DiplomeEtudiantRepository diplomeEtudiantRepository) {
        this.diplomeEtudiantRepository = diplomeEtudiantRepository;
    }

    @Override
    public int ajouterDiplome(User etudiantPostule) {
        if (etudiantPostule == null || etudiantPostule.getNotesSemestres() == null || etudiantPostule.getNotesSemestres().isEmpty()) {
            return -7;
        } else {
            double n = 0;
            DiplomeEtudiant diplomeEtudiant = etudiantPostule.getDiplomeEtudiant();
            System.out.println(etudiantPostule.getNotesSemestres().size());
            for (NotesSemestre notesSemestre : etudiantPostule.getNotesSemestres()) {
                System.out.println(notesSemestre.getNote());
                n = n + (notesSemestre.getNote() / etudiantPostule.getNotesSemestres().size());
            }
            diplomeEtudiant.setNote(Double.parseDouble(new DecimalFormat("00.000").format(n)));
            if (diplomeEtudiant.getNote() <10) {
                diplomeEtudiant.setMention(Mention.Ajourné);
            }
            else if (diplomeEtudiant.getNote() >= 10 && diplomeEtudiant.getNote() < 12) {
                diplomeEtudiant.setMention(Mention.Passable);
            } else if (diplomeEtudiant.getNote() >= 12 && diplomeEtudiant.getNote() < 14) {
                diplomeEtudiant.setMention(Mention.Bien);
            } else if (diplomeEtudiant.getNote() >= 14 && diplomeEtudiant.getNote() <= 16) {
                diplomeEtudiant.setMention(Mention.Bien);
            } else if (diplomeEtudiant.getNote() >= 16 && diplomeEtudiant.getNote() <= 18) {
                diplomeEtudiant.setMention(Mention.TresBien);
            }
            diplomeEtudiantRepository.save(diplomeEtudiant);
            return -8;
        }
    }

    @Override
    public int updateDiplomeEtudiant(User etudiantPostule) {
        DiplomeEtudiant diplomeEtudiant = diplomeEtudiantRepository.getOne(etudiantPostule.getDiplomeEtudiant().getId());
        if (diplomeEtudiant == null) {
            return -1;
        } else {
            System.out.println(etudiantPostule.getDiplomeEtudiant().getMention());
            diplomeEtudiant.setMention(etudiantPostule.getDiplomeEtudiant().getMention());
            diplomeEtudiant.setAnneeObtention(etudiantPostule.getDiplomeEtudiant().getAnneeObtention());
            diplomeEtudiant.setNameDiplome(etudiantPostule.getDiplomeEtudiant().getNameDiplome());
            diplomeEtudiantRepository.save(diplomeEtudiant);
            return 1;
        }    }
}
