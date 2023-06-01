package com.example.transporyback.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class MoyenDeTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long id;

    private String type;


    @ManyToMany
    private List<Station> stations;


}
