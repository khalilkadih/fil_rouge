package com.simplone.cocours.repository;

import com.simplone.cocours.entities.Concours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcoursRepository extends JpaRepository<Concours, Long> {

    Concours findByReference(String refernce);
    Concours findByFiliere(String filiere);

    List<Concours> findByAnneeConcours(int anneConcours);

}
