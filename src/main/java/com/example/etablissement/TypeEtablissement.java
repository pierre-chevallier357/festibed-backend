package com.example.etablissement;

public enum TypeEtablissement {

    STRING_ONE("H�TEL"),
    STRING_TWO("CAMPING"),
    STRING_THREE("PARC R�SIDENTIEL DE LOISIRS"),
    STRING_FOUR("VILLAGE DE VACANCES"),
    STRING_FIVE("R�SIDENCE DE TOURISME");

    private final String text;

    TypeEtablissement(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public TypeEtablissement setTypeEtab(String type){
        
        TypeEtablissement i = null;
        switch (type) {
            case "H�TEL" :
                i = TypeEtablissement.STRING_ONE;
                break;
            case "CAMPING" : 
                i = TypeEtablissement.STRING_TWO;
                break;
            case "PARC R�SIDENTIEL DE LOISIRS" : 
                i = TypeEtablissement.STRING_THREE;
                break;
            case "VILLAGE DE VACANCES" :
                i = TypeEtablissement.STRING_FOUR;
                break;
            case "R�SIDENCE DE TOURISME" :
                i = TypeEtablissement.STRING_FIVE;
                break;
        }
        return i;

    }
    
}
