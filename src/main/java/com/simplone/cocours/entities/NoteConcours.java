package com.simplone.cocours.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class NoteConcours  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double noteEcrit;
    private double noteOral;

    @OneToOne( cascade = CascadeType.REMOVE,mappedBy = "noteConcours")
    private RetenueEcrit retenueEcrit;
}
