package com.company;

public class Mot {
    private String mot;
    private int longueur;
    private boolean directionMot;
    private int position_depart_mot_x;
    private int position_depart_mot_y;

    public Mot(String word, boolean direction, int pos_x, int pos_y) {
        mot = word;
        longueur = mot.length();
        directionMot = direction;
        position_depart_mot_x = pos_x;
        position_depart_mot_y = pos_y;
    }

    public void ecrireMot(int taille){
        if(longueur==taille){
            String delimSpace = "";
            String[] word  = mot.split(delimSpace);
            int x =position_depart_mot_x ;
            int y =position_depart_mot_y ;
            for (String lettre : word) {
                Grille.tab[x][y] = new CaseLettre(x,y,lettre);
                if(directionMot == true) { x++;}
                else { y++;}
            }
        };
    }
}
