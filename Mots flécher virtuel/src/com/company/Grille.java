package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Grille {
    private static Scanner scanner = new Scanner(System.in);
    public static Case[][] tab;
    boolean created = false;
    ArrayList<Mot> listMot = new ArrayList<Mot>();
    
    public Grille(int n, int m) {
        try {
            if (valCase(n,m)){
            tab = new Case[n][m];/*
            tab[0][0].posX = 0;
            tab[0][0].posY = 0;
            for (int a=0; a<n;a++){
                for (int b=0; b<m;b++){
                    tab[a][b].posX = a;
                    tab[a][b].posY = b;
                }
            }*/
            created = true;}
        }
        catch (ValueZeroException ex){
            System.out.println(ex.getMessage());
        }
    }
    public  static boolean valCase(int n, int m)throws ValueZeroException{
        if (n <= 0 || m <= 0 || n > 10 || m > 10){
            throw new ValueZeroException("Les valeur ne sont pas correct");
        }
        return true;
    }
    public void addMot(Mot mot){
        listMot.add(mot);
    }
}
