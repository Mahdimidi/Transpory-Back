package com.example.transporyback.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Horaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idHoraire;

    private long designation;

    @OneToMany(mappedBy = "horaires")
    private List<HoraireItirenaire> horaireItirenaires=new ArrayList<>();

}
