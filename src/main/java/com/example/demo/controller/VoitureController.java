package com.example.demo.controller;

import com.example.demo.model.Voiture;
import com.example.demo.service.CatalogueDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class VoitureController {

    @Autowired
    private CatalogueDatabase catalogue;

    // GET /voitures
    @GetMapping("voitures")
    public List<Voiture> getVoitures() {
        return catalogue.getAll();
    }

    // POST /voitures
    @PostMapping("voiture")
    public ResponseEntity<?> addVoiture(@RequestBody Voiture newVoiture) {
        if (newVoiture.getMarque().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("La marque est obligatoire");
        }
        else {
            catalogue.add(newVoiture);
            System.out.println(newVoiture);
            return ResponseEntity.status(HttpStatus.CREATED).body(newVoiture);
        }
    }

    @PostMapping("voitures")
    public ResponseEntity<?> addVoitures(@RequestBody List<Voiture> newVoitures) {
        for (Voiture newVoiture : newVoitures) {
            if (newVoiture.getMarque().isBlank()) {
                return ResponseEntity
                        .badRequest()
                        .body("La marque de toutes les voitures est obligatoire");
            }
        }

        catalogue.addAll(newVoitures);  // Assurez-vous que votre catalogue supporte addAll()
        return ResponseEntity.status(HttpStatus.CREATED).body(newVoitures);
    }

    //GET /voitures/4
    @GetMapping("voitures/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        Optional<Voiture> optional = catalogue.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    //DELETE /voitures/4
    @DeleteMapping("voitures/{id}")
    public void delete(@PathVariable Integer id) {
        catalogue.delete(id);
    }

    //PUT /voitures/4
    @PutMapping("voitures")
    public void update(@RequestBody Voiture voiture) {
        catalogue.update(voiture);
    }

}
