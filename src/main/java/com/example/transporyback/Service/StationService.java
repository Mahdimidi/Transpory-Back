package com.example.transporyback.Service;

import com.example.transporyback.Model.Station;
import com.example.transporyback.Repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService implements IStationService{

    @Autowired
    StationRepository stationRepository;


    @Override
    public List<Station> getStation(){
        return stationRepository.findAll();
    }
    @Override
    public Optional<Station> findById(long id){
       return  stationRepository.findById(id);
    }
    @Override
    public void addStation(Station station){
         stationRepository.save(station);
    }
/*
    @Override
    public void UpdateStation(Station station){
        stationRepository.save(station);
    }
*/
    @Override
    public Station UpdateStation(Long id, Station station) {
        Optional<Station> S = stationRepository.findById(id);
        if (S.isPresent()) {
            Station UpdateStation = S.get();
            // Mettez à jour les propriétés de l'entité existante avec les valeurs de l'entité donnée
            UpdateStation.setDesignation(station.getDesignation());
            UpdateStation.setLattitude(station.getLattitude());
            UpdateStation.setLongitude(station.getLongitude());
            // ... mettez à jour d'autres propriétés

            return stationRepository.save(UpdateStation);
        } else {
            // Gérez le cas où l'entité avec l'identifiant donné n'existe pas
            throw new IllegalArgumentException("Entité introuvable pour l'identifiant : " + id);
        }
    }
    @Override
    public void deleteStation(long id){
        stationRepository.deleteById(id);
    }
}
