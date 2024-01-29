package com.example.demo.controller;

import com.example.demo.model.Voiture;
import com.example.demo.service.CatalogueDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CatalogueController {

    @Autowired
    private CatalogueDatabase catalogue;

    @GetMapping("readCatalogue")
    public List<Voiture> getVoitures(){
        return catalogue.getAll();
    }
}
