package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void creagrille1() {
        Grille grille = new Grille(6,6);
        assertEquals(true,grille.created);
    }
    @Test
    void creagrille2() {
        Grille grille = new Grille(0,0);
        assertEquals(false,grille.created);
    }
    @Test
    void creagrille3() {
        Grille grille = new Grille(-6,-6);
        assertEquals(false,grille.created);
    }
    @Test
    void creagrille4() {
        Grille grille = new Grille(11,11);
        assertEquals(false,grille.created);
    }

    @Test
    void infoCase1(){
        Grille grille = new Grille(6,6);
        grille.tab[0][0] = new Case();
        assertEquals(grille.tab[0][0].getClass().getName(),Case.class.getName());
    }
    @Test
    void infoCase2(){
        Grille grille = new Grille(6,6);
        grille.tab[0][0] = new CaseLettre(1,1,"e");
        assertEquals(grille.tab[0][0].getClass().getName(),CaseLettre.class.getName());
    }

    @Test
    void infoCase3(){
        Grille grille = new Grille(6,6);
        grille.tab[0][0] = new CaseDef(1,1,"mot","def",true,1);
        assertEquals(grille.tab[0][0].getClass().getName(),CaseDef.class.getName());
    }
    @Test
    void infoCase4(){
        Grille grille = new Grille(6,6);
        grille.tab[0][0] = new CaseDef(1,1,"mot","mot2","def","def2",true,false,1,2);
        assertEquals(grille.tab[0][0].getClass().getName(),CaseDef.class.getName());
    }
}