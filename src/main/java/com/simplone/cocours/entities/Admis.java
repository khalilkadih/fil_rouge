package com.simplone.cocours.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Choix>  chiox;
    @OneToMany
    private List<Concours> concours;

    private Double notePreselection;

    private boolean preselectione;

    private boolean retenueOral;

    private boolean admis;

    @OneToOne(cascade = CascadeType.REMOVE)
    private NoteConcours noteConcours;

    @OneToMany( cascade = CascadeType.REMOVE, mappedBy = "retenueEcrit")
    private List<NoteModuleConours> noteModuleConcourss;
}
