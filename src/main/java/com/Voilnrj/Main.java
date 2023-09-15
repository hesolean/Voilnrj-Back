package com.Voilnrj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
//    lancer docker, puis le terminal et taper docker-compose up -d
// installer postgres for jpa
    // créer la database sur le terminal : docker ps pour avoir l'id du container
    //puis taper: docker exec -it postgres bash pour arriver aux commandes du container
    // puis taper: psql -U Voilnrj
    // puis taper : \l pour avoir la liste des dtb
    // puis taper : CREATE DATABASE profils;
    // pour se connecter à la db, il faut taper : \c profils
}
