package modele;

import observer.*;
public  interface I_modeleGrille {

    public void addObservateur(I_Observateur o);
    public void removeObservateur(I_Observateur o);
    public  void notifyObservateur();
    public  boolean ajouterMotHoriz(String string, int i, int j);
    public  boolean ajouterMotVert(String string, int i, int j);
    public void ajouterLettre(String c,int x, int y);
    public int getHauteur();
    public int getLargeur();
    public Case[][] getTableauDeCases();
}