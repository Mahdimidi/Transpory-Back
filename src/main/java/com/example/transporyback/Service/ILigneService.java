package com.example.transporyback.Service;

import com.example.transporyback.Model.Ligne;

import java.util.List;
import java.util.Optional;

public interface ILigneService {
    List<Ligne> getLigne();

    Optional<Ligne> findById(long id);

    void addLigne(Ligne ligne);

 

    void deleteLigne(long id);

    /*
        @Override
        public void updateLigne(Ligne ligne, long id){
            ligneRepository.save(ligne);
        }*/
    Ligne updateLigne(Long id, Ligne ligne);
}
