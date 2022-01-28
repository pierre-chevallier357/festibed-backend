package com.example.etablissement;

public enum TypeEtablissement {

    STRING_ONE("HOTEL"),
    STRING_TWO("CAMPING"),
    STRING_THREE("PARC RESIDENTIEL DE LOISIRS"),
    STRING_FOUR("VILLAGE DE VACANCES"),
    STRING_FIVE("RESIDENCE DE TOURISME");

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
            case "HOTEL" :
                i = TypeEtablissement.STRING_ONE;
                break;
            case "CAMPING" : 
                i = TypeEtablissement.STRING_TWO;
                break;
            case "PARC RESIDENTIEL DE LOISIRS" : 
                i = TypeEtablissement.STRING_THREE;
                break;
            case "VILLAGE DE VACANCES" :
                i = TypeEtablissement.STRING_FOUR;
                break;
            case "RESIDENCE DE TOURISME" :
                i = TypeEtablissement.STRING_FIVE;
                break;
        }
        return i;

    }
    
}
