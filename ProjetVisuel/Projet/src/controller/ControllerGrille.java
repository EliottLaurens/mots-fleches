package controller;

import vue.*;
import modele.I_modeleGrille;

public class ControllerGrille implements I_Controller {

    private I_modeleGrille model;
    private I_Grille grille;

    public ControllerGrille(I_modeleGrille modele) {
        this.model = modele;
        this.grille = new GrilleGraphique(this, modele);

    }

    @Override
    public void ajouterMotHoriz(String s, int x, int y) {
        boolean resultat = model.ajouterMotHoriz(s, x, y);
        if(resultat == false){
            grille.sendMessage(String.format("ajout de %s en %s,%s impossible",s,x,y));
        }
    }
    public void ajouterMotVert(String s, int x, int y) {
        boolean resultat = model.ajouterMotVert(s, x, y);
        if(resultat == false){
            grille.sendMessage(String.format("ajout de %s en %s,%s impossible",s,x,y));
        }
    }




}
