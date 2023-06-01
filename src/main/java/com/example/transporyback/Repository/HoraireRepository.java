package com.example.transporyback.Repository;

import com.example.transporyback.Model.Horaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestResource

public interface HoraireRepository extends JpaRepository<Horaire, Long> {

}
