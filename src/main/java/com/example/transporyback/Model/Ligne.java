package com.example.transporyback.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class  Ligne {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idLigne;

    private String designation;


    @ManyToOne
    @JoinColumn(name = "idStation")
    private Station station;


    @ManyToOne
    @JoinColumn(name = "idItirenaire")
    private Itirenaire itirenaire;
}
