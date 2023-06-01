package com.example.transporyback.Controller;


import com.example.transporyback.Model.Horaire;
import com.example.transporyback.Model.Itirenaire;
import com.example.transporyback.Model.Station;
import com.example.transporyback.Repository.ItirenaireRepository;
import com.example.transporyback.Service.IHoraireService;
import com.example.transporyback.Service.ItirenaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itirenaire")
public class ItirenaireController {

    @Autowired
    ItirenaireRepository itirenaireRepository;
    @Autowired
    ItirenaireService itirenaireService;

    @GetMapping(value = "/afficheritirenaire")
    public List<Itirenaire> getItirenaire(){
        return itirenaireService.getItirenaire();
    }

    @GetMapping(value = "/afficheritirenaire/{id}")
    public Optional<Itirenaire> findById(@PathVariable("id") int id){
        return itirenaireService.findById(id);}

    @PostMapping(value = "/ecrireitirenaire")
    public void addItirenaire(@RequestBody Itirenaire itirenaire){
        itirenaireService.addItirenaire(itirenaire);
    }
    @PutMapping("/modifierItirenaire/{id}")
    public ResponseEntity<Itirenaire> UpdateItirenaire(@PathVariable("id") Long id, @RequestBody Itirenaire itirenaire) {
        Itirenaire I = itirenaireService.UpdateItirenaire(id, itirenaire);
        return ResponseEntity.ok(I);
    }

    @DeleteMapping("/deleteitirenaire/{id}")
    public void deleteItirenaire(@PathVariable int id){
        itirenaireService.deleteItirenaire(id);
    }

}
