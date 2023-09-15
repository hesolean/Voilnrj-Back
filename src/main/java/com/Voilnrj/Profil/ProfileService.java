package com.Voilnrj.Profil;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProfileService {
    private static ProfilRepository profilRepository;
    private static ObjectMapper objectMapper;
    public ProfileService(ProfilRepository profilRepository, ObjectMapper objectMapper) {
        this.profilRepository = profilRepository;
        this.objectMapper = objectMapper;
    }

    public ProfilRepository findAll(){
        List<Profil> profils = profilRepository.findAll();
        return (ProfilRepository) profils.stream().map(profil -> objectMapper.convertValue(profil, Profil.class)).toList();
    }
    public static Profil findById(Long id){
        Profil profil = profilRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profil not found")
        );
        return objectMapper.convertValue(profil, Profil.class);
    }

    public Profil save(Profil profil){
        return profilRepository.save(profil);
    }

    public Profil updateById(Long id, Profil profil) {
        Profil presentProfil = profilRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Profil non trouvé pour l'id " + id)
        );
        presentProfil.setProfilName(profil.getProfilName() == null ? presentProfil.getProfilName() : profil.getProfilName());
        presentProfil.setForeName(profil.getForeName() == null ? presentProfil.getForeName() : profil.getForeName());
        presentProfil.setProfilEmail(profil.getProfilEmail() == null ? presentProfil.getProfilEmail() : profil.getProfilEmail());
        presentProfil.setPhoneNumber(profil.getPhoneNumber() == null ? presentProfil.getPhoneNumber() : profil.getPhoneNumber());
        presentProfil.setProfilPassword(profil.getProfilPassword() == null ? presentProfil.getProfilPassword() : profil.getProfilPassword());
        return profilRepository.save(presentProfil);
    }

    public void deleteById(Long id) {
        profilRepository.deleteById(id);
    }
}
