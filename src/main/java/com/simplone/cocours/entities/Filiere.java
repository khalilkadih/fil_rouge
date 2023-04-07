package com.simplone.cocours.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nameOfFilier;
    private String chefDeFiliere;



}
