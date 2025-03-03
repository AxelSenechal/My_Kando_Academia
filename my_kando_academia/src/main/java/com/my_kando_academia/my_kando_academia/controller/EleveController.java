package com.my_kando_academia.my_kando_academia.controller;

import com.my_kando_academia.my_kando_academia.model.Eleve;
import com.my_kando_academia.my_kando_academia.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eleves")
public class EleveController {

    @Autowired
    private EleveRepository eleveRepository;

    @GetMapping
    public List<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eleve> getEleveById(@PathVariable int id) {
        return eleveRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Eleve createEleve(@RequestBody Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eleve> updateEleve(@PathVariable int id, @RequestBody Eleve eleveDetails) {
        return eleveRepository.findById(id)
                .map(eleve -> {
                    eleve.setNom_joueur(eleveDetails.getNom_joueur());
                    eleve.setNom_personnage(eleveDetails.getNom_personnage());
                    eleve.setNombre_heures(eleveDetails.getNombre_heures());
                    Eleve updatedEleve = eleveRepository.save(eleve);
                    return ResponseEntity.ok(updatedEleve);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEleve(@PathVariable int id) {
        return eleveRepository.findById(id)
                .map(eleve -> {
                    eleveRepository.delete(eleve);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
