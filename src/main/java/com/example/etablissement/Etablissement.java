package com.example.etablissement;


public class Etablissement {

    private int IDEtab;
    private String type;
    private Classement classement;
    private String nomCommercial;
    private String numeroDeTelephone;
    private String email;
    private String siteInternet;
    private int capaciteDAccueil;    
    private int codePostal;
    private String adresse;
    private String departement;
    private String region;
    private String commune;
    private int nbLogement;
    private double coordonnesGPSX;
    private double coordonnesGPSY;

    public int getIDEtab() {
        return this.IDEtab;
    }

    public void setIDEtab(int IDEtab) {
        this.IDEtab = IDEtab;
    }

    public String getClassement() {
        return this.classement.ToString();
    }

    public void setClassement(String classement) {
        this.classement = Classement.setClassement(classement);
    }

    public String getNomCommercial() {
        return this.nomCommercial;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    public String getNumeroDeTelephone() {
        return this.numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteInternet() {
        return this.siteInternet;
    }

    public void setSiteInternet(String siteInternet) {
        this.siteInternet = siteInternet;
    }

    public int getCapaciteDAccueil() {
        return this.capaciteDAccueil;
    }

    public void setCapaciteDAccueil(int capaciteDAccueil) {
        this.capaciteDAccueil = capaciteDAccueil;
    }

    public void setType(String type) {
        this.type =type;
    }

    public String getType() {
        return type;
    }
    
    public void setNbLogement(int nbLogement) {
        this.nbLogement = nbLogement;
    }
    
	public int getNbLogement() {
		return nbLogement;
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