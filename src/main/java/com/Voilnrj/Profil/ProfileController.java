package com.Voilnrj.Profil;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/profils")
public class ProfileController {
    public ProfileService profileService;
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("")
    public List<Profil> findAll() {
        return profileService.findAll();
    }

    @GetMapping("/{id}")
    public Profil findById(@PathVariable("id") Long id) {
        return profileService.findById(id);
    }

    @PostMapping("")
    public Profil save(@RequestBody Profil profil) {
        return profileService.save(profil);
    }

    @PutMapping("/{id}")
    public Profil updateById(@PathVariable("id") Long id, @RequestBody Profil profil) {
        return profileService.updateById(id, profil);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        profileService.deleteById(id);
    }

}
