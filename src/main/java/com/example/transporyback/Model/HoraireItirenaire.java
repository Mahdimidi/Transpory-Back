package com.example.transporyback.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class HoraireItirenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idHoraireItirenaire;

    private String duree;

    @ManyToOne
    @JoinColumn(name = "idItirenaire")
    private Itirenaire itirenaire;

    @ManyToOne
    @JoinColumn(name = "idHoraire")
    private Horaire horaires;

}
