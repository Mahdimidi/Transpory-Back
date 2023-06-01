package com.example.transporyback.Model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Administrateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String email;

    private String password;

    public Administrateur(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
