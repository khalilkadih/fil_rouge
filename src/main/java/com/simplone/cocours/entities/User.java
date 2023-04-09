package com.simplone.cocours.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cne;
    private String cin;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String telephone;
    private Date dateDeNaissance;
    private String adressPersonnelle;
    private String niveau;


    @OneToOne(cascade = CascadeType.REMOVE)
    private DiplomeEtudiant diplomeEtudiant;


    @OneToMany(mappedBy = "etudiantPostule", cascade = CascadeType.REMOVE)
    private List<NotesSemestre> notesSemestres;

    @ManyToMany(fetch =FetchType.EAGER)
    private Collection<Role> roles= new ArrayList<>();

    @OneToMany(mappedBy = "etudiantPostule", cascade = CascadeType.REMOVE)
    private List<Choix> choixs;


}
