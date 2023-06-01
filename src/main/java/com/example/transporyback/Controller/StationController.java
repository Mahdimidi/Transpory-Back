package com.example.transporyback.Controller;

import com.example.transporyback.Model.Ligne;
import com.example.transporyback.Model.Station;
import com.example.transporyback.Repository.StationRepository;
import com.example.transporyback.Service.StationService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/station")
public class StationController {
    @Autowired
    StationRepository stationRepository;
    @Autowired
    StationService stationService;


    @GetMapping(value = "/afficherStation")
    public List<Station> getStation() {
        return stationService.getStation();
    }
    @GetMapping(value = "/afficherStation/{id}")
    public Optional<Station> findById(@PathVariable("id") int id){
       return stationService.findById(id);
    }
    @PostMapping(value = "/ecrireStation")
    public void addStation(@RequestBody Station station){
         stationService.addStation(station);
    }/*
    @PutMapping("/modifierStation")
    public void updateStation(@RequestBody Station station){
        stationService.UpdateStation(station);
    }*/

    @PutMapping("/modifierStation/{id}")
    public ResponseEntity<Station> UpdateStation(@PathVariable("id") Long id, @RequestBody Station station) {
        Station S = stationService.UpdateStation(id, station);
        return ResponseEntity.ok(S);
    }

    @DeleteMapping("/deleteStation/{id}")
    public void deleteStation(@PathVariable int id){
        stationService.deleteStation(id);
    }

    }
