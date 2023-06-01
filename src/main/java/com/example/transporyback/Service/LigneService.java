package com.example.transporyback.Service;

import com.example.transporyback.Model.Ligne;
import com.example.transporyback.Repository.LigneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneService implements ILigneService{

    @Autowired
    LigneRepository ligneRepository;

    @Override
    public List<Ligne> getLigne(){
       return ligneRepository.findAll();
    }

    @Override
    public Optional<Ligne> findById(long id){
        return  ligneRepository.findById(id);
    }
    @Override
    public void addLigne(Ligne ligne){
        ligneRepository.save(ligne);
    }



    /*
    @Override
    public void updateLigne(Ligne ligne, long id){
        ligneRepository.save(ligne);
    }*/
    @Override
    public Ligne updateLigne(Long id, Ligne ligne) {
        Optional<Ligne> L = ligneRepository.findById(id);
        if (L.isPresent()) {
            Ligne updateLigne = L.get();
            // Mettez à jour les propriétés de l'entité existante avec les valeurs de l'entité donnée
            updateLigne.setDesignation(ligne.getDesignation());
            // ... mettez à jour d'autres propriétés

            return ligneRepository.save(updateLigne);
        } else {
            // Gérez le cas où l'entité avec l'identifiant donné n'existe pas
            throw new IllegalArgumentException("Entité introuvable pour l'identifiant : " + id);
        }
    }
    @Override
    public void deleteLigne(long id){

        ligneRepository.deleteById(id);
    }



}
