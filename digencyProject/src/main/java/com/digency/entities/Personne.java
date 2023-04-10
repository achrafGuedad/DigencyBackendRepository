package com.digency.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Personne {


    @Id
    @GeneratedValue
    private int idPersonne;
    private  String nom;
    private String nomArabe;
    private String prenom;



    private String prenomArabe;
    private String cin;
    private String dateNaissance;
    private String typeCarte;

    private  byte[] image;

    private String profession;


    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getIdPersonne() {
        return idPersonne;
    }
    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNomArabe() {
        return nomArabe;
    }
    public void setNomArabe(String nomArabe) {
        this.nomArabe = nomArabe;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPrenomArabe() {
        return prenomArabe;
    }

    public void setPrenomArabe(String prenomArabe) {
        this.prenomArabe = prenomArabe;
    }
    public String getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getTypeCarte() {
        return typeCarte;
    }
    public void setTypeCarte(String typeCarte) {
        this.typeCarte = typeCarte;
    }
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

    public Personne() {
        super();
        // TODO Auto-generated constructor stub
    }


}
