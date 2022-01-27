package com.example.etablissement;


public enum Classement {

    etoiles5 (5),
    etoiles4 (4),
	etoiles3 (3),
	etoiles2 (2),
	etoiles1 (1), 
	AireNaturelle (6);

	
	private int val;
	
	Classement(int nb) {
		val = nb;
	}

	public static Classement setClassement(String classement){

		Classement i = null;
		switch (classement){
            case "1 étoile" :
                i = etoiles1;
            case "2 étoiles" : 
                i = etoiles2;
            case "3 étoiles" : 
                i = etoiles3;
            case "4 étoiles" :
                i = etoiles4;
            case "5 étoiles" :
              	i = etoiles5;
            case "Aire naturelle" : 
                i = AireNaturelle;

        }
		return i;

	}

	public String ToString(){
		String i ="";
		switch (this){
			case etoiles1 :
                i = "1 étoile";
            case etoiles2 : 
                i = "2 étoiles";
            case etoiles3 : 
                i = "3 étoiles";
            case etoiles4 :
                i = "4 étoiles";
            case etoiles5 :
              	i = "5 étoiles";
            case AireNaturelle : 
                i = "Aire naturelle";
		}
		return i;
	}

	public int getPoint() {
		return val;
	}

}
