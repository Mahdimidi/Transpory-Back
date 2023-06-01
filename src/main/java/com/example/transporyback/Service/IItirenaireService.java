package com.example.transporyback.Service;

import com.example.transporyback.Model.Itirenaire;

import java.util.List;
import java.util.Optional;

public interface IItirenaireService {
    List<Itirenaire> getItirenaire();

    Optional<Itirenaire> findById(long id);

    void addItirenaire(Itirenaire itirenaire);

    Itirenaire UpdateItirenaire(Long id, Itirenaire itirenaire);

    void deleteItirenaire(long id);
}
