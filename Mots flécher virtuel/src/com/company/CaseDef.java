package com.company;

import java.util.Scanner;

public class CaseDef extends Case{
    private static Scanner scanner = new Scanner(System.in);
    private int nombreMot;
    private Fleche fleche1;
    private Fleche fleche2;
    private boolean direction1;
    private boolean direction2;
    private Mot mot1;
    private Mot mot2;
    private String def1;
    private String def2;

    public CaseDef(int x, int y, String m, String d, boolean dirMot, int dirFleche){
        nombreMot = 1;
        this.posX =x;
        this.posY =y;
        this.def1 = d;
        this.fleche1 = new Fleche(dirFleche);
        if(dirFleche==1 || dirFleche==3)
        {
            direction1 = true;
            mot1 = new Mot(m, dirMot, x+1, y);
        }
        else
        {
            direction1 = false;
            mot1 = new Mot(m, dirMot, x, y+1);
        }
    }

    public CaseDef(int x, int y, String m1, String m2, String d1, String d2, boolean dirMot1, boolean dirMot2, int dirFleche1, int dirFleche2){
        nombreMot = 2;
        this.posX =x;
        this.posY =y;
        this.def1 = d1;
        this.def2 =d2;
        this.fleche1 = new Fleche(dirFleche1);
        this.fleche2 = new Fleche(dirFleche2);
        if(dirFleche1==1 || dirFleche1==3)
        {
            this.direction1 = true;
            this.mot1 = new Mot(m1, dirMot1, x+1, y);
        }
        else
        {
            this.direction1 = false;
            this.mot1 = new Mot(m1, dirMot1, x, y+1);
        }
        if(dirFleche2==1 || dirFleche2==3)
        {
            this.direction2 = true;
            this.mot2 = new Mot(m2, dirMot2, x+1, y);
        }
        else
        {
            this.direction2 = false;
            this.mot2 = new Mot(m2, dirMot2, x, y+1);
        }
    }
    public int getNombreMot(){
        return this.nombreMot;
    }
}