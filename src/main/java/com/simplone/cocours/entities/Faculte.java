package com.simplone.cocours.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Faculte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nameOfFaculte;
    @OneToMany
    private List<Filiere> filieres;
    private String Adress;


}
