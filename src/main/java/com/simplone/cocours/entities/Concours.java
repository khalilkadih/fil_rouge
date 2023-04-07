package com.simplone.cocours.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Concours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "concours")
    private List<ModuleConcours> modules;
    private int anneeConcours;

    @Temporal(TemporalType.DATE)
    private Date dateConcoursEcrit;

    @Temporal(TemporalType.DATE)
    private Date dateConcoursOral;

    private int nbreplace;
    private int nbreplaceConcoursEcrit;
    private int nbreplaceConcoursOral;
    @ManyToOne
    private Filiere filiere;

}
