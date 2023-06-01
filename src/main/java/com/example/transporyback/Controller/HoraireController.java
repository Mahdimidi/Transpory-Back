package com.example.transporyback.Controller;

import com.example.transporyback.Model.Horaire;
import com.example.transporyback.Model.Itirenaire;
import com.example.transporyback.Model.Ligne;
import com.example.transporyback.Repository.HoraireRepository;
import com.example.transporyback.Request.HoraireRequest;
import com.example.transporyback.Service.HoraireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/horaire")
public class HoraireController {


    @Autowired
     HoraireService horaireService;


    @GetMapping(value = "/afficherHoraire")
    public List<Horaire> getHoraire(){return horaireService.getHoraire();}

    @GetMapping(value = "/afficherHoraire/{id}")
    public Optional<Horaire> findById(@PathVariable("id") int id){
        return horaireService.findById(id);}

    @PutMapping("/modifierHoraire/{id}")
    public ResponseEntity<Horaire> updateHoraire(@PathVariable("id") Long id, @RequestBody Horaire horaire) {
        Horaire H = horaireService.updateHoraire(id, horaire);
        return ResponseEntity.ok(H);
    }
    @PostMapping(value = "/ecrireHoraire")
    public void addHoraire(@RequestBody Horaire Hr){
        horaireService.addHoraire(Hr);
    }


    @DeleteMapping("/deleteHoraire/{id}")
    public void deleteHoraire(@PathVariable int id){
        horaireService.deleteHoraire(id);}
}
