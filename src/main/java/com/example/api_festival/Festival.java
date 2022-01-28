package com.example.api_festival;


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
    private int Capacite;
    private int codePostal;
    private String adresse;
    private String departement;
    private String region;
    private String commune;
    private double coordonnesGPSX;
    private double coordonnesGPSY;

    public Festival(){}

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public int getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDepartement() {
        return this.departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommune() {
        return this.commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public void setCoordonnesGPS(String coordonnees) {
        try{
            String[] tab = coordonnees.split(",");
            this.coordonnesGPSX = Double.parseDouble(tab[1]);;
            this.coordonnesGPSY = Double.parseDouble(tab[2]);
        }catch(Exception e){}
    }

    public String getCoordonnesGPSString() {
        return this.coordonnesGPSX+","+this.coordonnesGPSY;
    }
}
