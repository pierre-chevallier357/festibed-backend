package com.example.etablissement;

import com.example.other.Localisation;

public class Etablissement {

    private int IDEtab;
    private TypeEtablissement type;
    private Classement classement;
    private String nomCommercial;
    private String numeroDeTelephone;
    private String email;
    private String siteInternet;
    private int capaciteDAccueil;
    private Localisation localisation;
    private int nbLogement;

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

    public Localisation getLocalisation() {
        return this.localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
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
        this.type.setTypeEtab(type);
    }

    public String getType() {
        return type.toString();
    }
    
    public void setNbLogement(int nbLogement) {
        this.nbLogement = nbLogement;
    }
    
	public int getNbLogement() {
		return nbLogement;
	}
}