package com.example.transporyback.Service;

import com.example.transporyback.Model.Horaire;
import com.example.transporyback.Request.HoraireRequest;

import java.util.List;
import java.util.Optional;

public interface IHoraireService{
    List<Horaire> getHoraire();

    Optional<Horaire> findById(long id);

    Horaire updateHoraire(Long id, Horaire horaire);

    void addHoraire(Horaire horaire);

    void deleteHoraire(long id);
}
