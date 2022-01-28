package com.example.api_festival;

import com.example.other.Localisation;

public class Festival {

    private String nom;
    private String domaine;
    private String complementDomaine;
    private String dateFestival;
    private String periodicite;
    private String moisDebut;
    private String siteInternet;
    private int idFestival;
    private String codeInsee;
    private String commentaire;
    private String moisIndicatif;
    private String dateDebut;
    private String dateFin;
    private int duree;
    private Localisation localisation;
    private int Capacite;

    public Festival(){}

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Localisation getLocalisation() {
        return this.localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public String getDomaine() {
        return this.domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
    
    public String getComplementDomaine() {
        return this.complementDomaine;
    }

    public void setComplementDomaine(String complementDomaine) {
        this.complementDomaine = complementDomaine;
    }

    public String getDateFestival() {
        return this.dateFestival;
    }

    public void setDateFestival(String dateFestival) {
        this.dateFestival = dateFestival;
    }

    public String getPeriodicite() {
        return this.periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public String getMoisDebut() {
        return this.moisDebut;
    }

    public void setMoisDebut(String moisDebut) {
        this.moisDebut = moisDebut;
    }

    public String getSiteInternet() {
        return this.siteInternet;
    }

    public void setSiteInternet(String siteInternet) {
        this.siteInternet = siteInternet;
    }

    public int getIdFestival() {
        return this.idFestival;
    }

    public void setIdFestival(int idFestival) {
        this.idFestival = idFestival;
    }

    public String getCodeInsee() {
        return this.codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getMoisIndicatif() {
        return this.moisIndicatif;
    }

    public void setMoisIndicatif(String moisIndicatif) {
        this.moisIndicatif = moisIndicatif;
    }

    public String getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getDuree() {
        return this.duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

	public int getCapacite() {
		return Capacite;
	}

	public void setCapacite(int capacite) {
		Capacite = capacite;
	}  
}
