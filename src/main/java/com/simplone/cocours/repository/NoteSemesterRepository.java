package com.simplone.cocours.repository;

import com.simplone.cocours.entities.Choix;
import com.simplone.cocours.entities.NotesSemestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteSemesterRepository extends JpaRepository<NotesSemestre,Long> {

        NotesSemestre findByRefSemestreAAndAndEtudiantPostuleCne(String refernce);


}
