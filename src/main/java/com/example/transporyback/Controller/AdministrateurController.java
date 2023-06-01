package com.example.transporyback.Controller;

import com.example.transporyback.Model.Administrateur;
import com.example.transporyback.Repository.AdministrateurRepository;
import com.example.transporyback.Service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Admin")
public class AdministrateurController  {


    @Autowired
    AdministrateurService administrateurService;

    @Autowired
    AdministrateurRepository administrateurRepository;

    @PostMapping("/login")
    public ResponseEntity<?>  login(@RequestBody Administrateur administrateur) {
        return administrateurService.login(administrateur);
    }
}
