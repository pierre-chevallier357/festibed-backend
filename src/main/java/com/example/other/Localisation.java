package com.example.other;

public class Localisation {
    
    private int codePostal;
    private String adresse;
    private String departement;
    private String region;
    private String commune;
    private CoordonneeGPS coordonnesGPS;

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

    public CoordonneeGPS getCoordonnesGPS() {
        return this.coordonnesGPS;
    }

    public void setCoordonnesGPS(String coordonnees) {
        try{
            String[] tab = coordonnees.split(",");
            double x = Double.parseDouble(tab[1]);
            double y = Double.parseDouble(tab[2]);
            this.coordonnesGPS.setX(x);
            this.coordonnesGPS.setY(y);
        }catch(Exception e){}
    }

    public String getCoordonnesGPSString() {
        return this.coordonnesGPS.getX()+","+this.coordonnesGPS.getY();
    }


}
