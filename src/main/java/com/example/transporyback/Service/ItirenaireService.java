package com.example.transporyback.Service;

import com.example.transporyback.Model.Itirenaire;
import com.example.transporyback.Repository.ItirenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItirenaireService implements IItirenaireService{
    @Autowired
    ItirenaireRepository itirenaireRepository;

    @Override
    public List<Itirenaire> getItirenaire(){

        return itirenaireRepository.findAll();
    }
    @Override
    public Optional<Itirenaire> findById(long id){
        return  itirenaireRepository.findById(id);
    }
    @Override
    public void addItirenaire(Itirenaire itirenaire){

        itirenaireRepository.save(itirenaire);
    }
    @Override
    public Itirenaire UpdateItirenaire(Long id, Itirenaire itirenaire) {
        Optional<Itirenaire> I = itirenaireRepository.findById(id);
        if (I.isPresent()) {
            Itirenaire UpdateItirenaire = I.get();
            // Mettez à jour les propriétés de l'entité existante avec les valeurs de l'entité donnée
            UpdateItirenaire.setDureeMoyenne(itirenaire.getDureeMoyenne());


            // ... mettez à jour d'autres propriétés

            return itirenaireRepository.save(UpdateItirenaire);
        } else {
            // Gérez le cas où l'entité avec l'identifiant donné n'existe pas
            throw new IllegalArgumentException("Entité introuvable pour l'identifiant : " + id);
        }
    }
    @Override
    public void deleteItirenaire(long id){
        itirenaireRepository.deleteById(id);
    }


}
