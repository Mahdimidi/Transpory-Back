package com.example.transporyback.Service;

import com.example.transporyback.Model.Horaire;
import com.example.transporyback.Repository.HoraireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoraireService implements IHoraireService{


  @Autowired
    HoraireRepository horaireRepository;


  @Override
  public List<Horaire> getHoraire(){

    return  horaireRepository.findAll();
  }
  @Override
  public Optional<Horaire> findById(long id){
    return  horaireRepository.findById(id);
  }
  @Override
  public Horaire updateHoraire(Long id, Horaire horaire) {
    Optional<Horaire> H = horaireRepository.findById(id);
    if (H.isPresent()) {
      Horaire updateHoraire =H.get();
      // Mettez à jour les propriétés de l'entité existante avec les valeurs de l'entité donnée
      updateHoraire.setDesignation(horaire.getDesignation());
      // ... mettez à jour d'autres propriétés

      return horaireRepository.save(updateHoraire);
    } else {
      // Gérez le cas où l'entité avec l'identifiant donné n'existe pas
      throw new IllegalArgumentException("Entité introuvable pour l'identifiant : " + id);
    }
  }

  @Override
  public void addHoraire(Horaire horaire){
   // Horaire h =new Horaire();
    //h.setDesignation(horaire.getDesignation());
    // System.out.println(horaire);
    horaireRepository.save(horaire);

  }
  @Override
  public void deleteHoraire(long id){
    horaireRepository.deleteById(id);
  }
}
