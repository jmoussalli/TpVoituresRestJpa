package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="voitures")
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marque;
    private String modele;
    private String annee;
    private String couleur;
    private String dateImmatriculation;
    private String immatriculation;

    public Voiture() {
    }

    public Voiture(String marque, String modele, String annee, String couleur, String dateImmatriculation, String immatriculation) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.couleur = couleur;
        this.dateImmatriculation = dateImmatriculation;
        this.immatriculation = immatriculation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getDateImmatriculation() {
        return dateImmatriculation;
    }

    public void setDateImmatriculation(String dateImmatriculation) {
        this.dateImmatriculation = dateImmatriculation;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee='" + annee + '\'' +
                ", couleur='" + couleur + '\'' +
                ", dateImmatriculation='" + dateImmatriculation + '\'' +
                ", immatriculation='" + immatriculation + '\'' +
                '}';
    }
}