package modele;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import observer.I_Observateur;

public class GrilleVirtuelle implements I_modeleGrille{
    private static Scanner scanner = new Scanner(System.in);
    private int hauteur;
    private int largeur;
    private Case[][] tableauDeCases;
    private ArrayList<I_Observateur> tableauObservateurs;

    public GrilleVirtuelle(int hauteur, int largeur) {
        super();
        this.hauteur = hauteur;
        this.largeur = largeur;
        JFrame frame = new JFrame();
        do {
            this.hauteur = Integer.parseInt(JOptionPane.showInputDialog(frame, "Hauteur de la grille:"));
        }while (this.hauteur<1 || this.hauteur>10);
        do {
            this.largeur = Integer.parseInt(JOptionPane.showInputDialog(frame, "Largeur de la grille:"));
        }while (this.largeur<1 || this.largeur>10);
        tableauDeCases = new Case[this.largeur][this.hauteur];
        //initTableau();
        tableauObservateurs = new ArrayList<>();
    }
    /**
     * remplit le tableau avec uniquement des lettres
     */
    /*private void initTableau(){
        for(int h = 0; h < hauteur; h++){
            for (int l =0; l < largeur; l++){
                tableauDeCases[l][h] = '.';
            }
        }
    }*/
    /**
     *
     * @param mot le mot a rajouter
     * @param x la position x
     * @param y la position y
     * @return true si ok, false sinon
     */
    public boolean ajouterMotHoriz(String mot,int x,int y) {
        if(mot.length()+x>largeur) {
            System.out.println("mot ajouté trop long");
            return false;
        }
        else {
            for (int i=0;i<mot.length();i++) {
                tableauDeCases[i+x][y]=new CaseLettre(x,y,String.valueOf(mot.charAt(i)));
            }
        }
        return true;
    }

    public void ajouterLettre(String c,int x, int y){
        tableauDeCases[x][y]=new CaseLettre(x,y,c);
    }

    public boolean ajouterMotVert(String mot,int x,int y) {
        if(mot.length()+y>hauteur) {
            System.out.println("mot ajouté trop long");
            return false;
        }
        else {
            for (int i=0;i<mot.length();i++) {
                tableauDeCases[x][i+y]=new CaseLettre(x,y,String.valueOf(mot.charAt(i)));
            }
        }
        return true;
    }

    public void dumpGrilleVirtuelle() {
        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++){
                System.out.print(tableauDeCases[l][h]);
            }
            System.out.println();
        }
    }
    @Override
    public void addObservateur(I_Observateur o) {
        tableauObservateurs.add(o);
    }

    @Override
    public void removeObservateur(I_Observateur o) {
        tableauObservateurs.remove(o);
    }

    @Override
    public void notifyObservateur() {
        for (I_Observateur o:tableauObservateurs) {
            o.update(this);
        }
    }

    @Override
    public int getHauteur() {
        return hauteur;
    }

    @Override
    public int getLargeur() {
        return largeur;
    }

    @Override
    public Case[][] getTableauDeCases() {
        return tableauDeCases;
    }
}