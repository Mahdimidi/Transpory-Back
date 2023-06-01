package com.example.transporyback.Service;

import com.example.transporyback.Model.Administrateur;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IAdministrateurService {
    Administrateur save(Administrateur admin);

    Optional<Administrateur> findById(Long id);

    List<Administrateur> findAll();

    void delete(Long id);

    ResponseEntity<?> login(Administrateur request) ;
}
