package com.example.demo.service;

import com.example.demo.dao.VoitureRepository;
import com.example.demo.model.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogueDatabase {

    @Autowired
    private VoitureRepository voitureRepository;

    public void add( Voiture p){
        voitureRepository.save(p);
    }

    // Méthode pour ajouter une liste de voitures
    public void addAll(List<Voiture> newVoitures) {
        // Ici, nous utilisons la méthode saveAll() du repository
        // Cette méthode enregistre toutes les entités de la liste dans la base de données
        voitureRepository.saveAll(newVoitures);
    }

    public List<Voiture> getAll(){
        return voitureRepository.findAll();
    }

    public Optional<Voiture> findById(Integer id){
        return voitureRepository.findById(id);
    }

    public void delete(Integer id) {
        voitureRepository.deleteById(id);
    }

    public void update(Voiture voiture) {
        voitureRepository.save(voiture);
    }

}