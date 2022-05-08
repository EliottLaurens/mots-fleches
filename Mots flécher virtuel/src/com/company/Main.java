package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
	// write your code here
        System.out.print("Entrez la largeur de la grille:");
        int n = scanner.nextInt();
        System.out.print("Entrez la longeur de la grille:");
        int m = scanner.nextInt();
        Grille grille = new Grille(n,m);
    }
}
