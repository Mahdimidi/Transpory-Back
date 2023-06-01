package com.example.transporyback.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Station {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    private long idStation;

    private String designation;

    private long lattitude;

    private long longitude;



    @OneToMany(mappedBy = "station")
    private List<Ligne> lignes=new ArrayList<Ligne>();

    @ManyToMany
    private List<MoyenDeTransport> moyenDeTransports;

}
