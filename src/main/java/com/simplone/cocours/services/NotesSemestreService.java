/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplone.cocours.services;

import com.simplone.cocours.entities.NotesSemestre;
import com.simplone.cocours.entities.User;

public interface NotesSemestreService {

    public int CreerNotesSemestre(User etudiantPostule);
    public int updateNotesSemestre(User etudiantPostule);
    public NotesSemestre findByRefSemestreAndEtudiantPostuleCne(String refSemestre, String cne);
   
}
