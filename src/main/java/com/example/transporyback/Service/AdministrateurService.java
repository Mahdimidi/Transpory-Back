package com.example.transporyback.Service;

import com.example.transporyback.Model.Administrateur;
import com.example.transporyback.Repository.AdministrateurRepository;

import com.example.transporyback.Security.SecurityConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.security.Key;
import java.util.Base64;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
@Slf4j
@Service
public class AdministrateurService implements IAdministrateurService{

    @Autowired
    AdministrateurRepository administrateurRepository;

    public AdministrateurService(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    @Override
    public Administrateur save(Administrateur admin) {

        return administrateurRepository.save(admin);
    }

    @Override
    public Optional<Administrateur> findById(Long id) {
        if (id==null){
            log.error("Id de administrateur est nulle");
        }

        return  administrateurRepository.findById(id);

    }

    @Override
    public List<Administrateur> findAll() {
        return administrateurRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        administrateurRepository.deleteById(id);
    }

    public ResponseEntity<?> login(Administrateur request) {
        Administrateur user = administrateurRepository.findByEmail(request.getEmail()).orElse(null);

        if (user != null) {
            if (user.getPassword().equals(request.getPassword())) {
                // Generate JWT token
                String token = generateJwtToken(user.getEmail());

                // Return the JWT token in the response
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
        }
    }



    private String generateJwtToken(String email) {
        byte[] keyBytes = Base64.getDecoder().decode(SecurityConst.secretKey);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder()
                .setSubject(email)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}


