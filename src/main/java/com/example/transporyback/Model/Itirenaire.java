package com.example.transporyback.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor

@Entity
public class Itirenaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long idItirenaire;

    private String dureeMoyenne;


    @OneToMany(mappedBy = "itirenaire")
    private List<Ligne> lignes=new ArrayList<Ligne>();


    @OneToMany(mappedBy = "itirenaire")
    private List<HoraireItirenaire> horaireItirenaires=new ArrayList<HoraireItirenaire>();
}
