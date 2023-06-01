package com.example.transporyback.Service;

import com.example.transporyback.Model.Station;

import java.util.List;
import java.util.Optional;

public interface IStationService {


    List<Station> getStation();



    Optional<Station> findById(long id);

    void addStation(Station station);


    /*
        Station UpdateStation(Station station);


            @Override
            public void UpdateStation(Station station){
                stationRepository.save(station);
            }
        */
    Station UpdateStation(Long id, Station station);

    void deleteStation(long id);
}
