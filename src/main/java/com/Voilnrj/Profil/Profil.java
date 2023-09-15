package com.Voilnrj.Profil;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

@Entity
@Getter
@Setter
@Table(name = "profils")
public class Profil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String profilName;
    private String foreName;
    private String profilEmail;
    private String phoneNumber;
    private String profilPassword;
}
