package modele;

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

    public CaseDef(int x, int y){
        this.posX = x;
        this.posY = y;
        nombreMot = 0;
        do {
            System.out.print("Combien de definitions souhaitez-vous entrer ? ");
            nombreMot = scanner.nextInt();
        }while (nombreMot<1 || nombreMot>2);
        if(nombreMot==1)
        {
            int f = 0;
            System.out.print("Entrez la définition de votre mot : ");
            def1 = scanner.nextLine();
            System.out.print("Entrez votre mot : ");
            String m1 = scanner.nextLine();
            do {
                System.out.print("Entrez la direction de la fleche (1=Droite, 2=Bas, 3=Bas-Droite, 4=Droite-Bas :");
                f = scanner.nextInt();
            }while (f<1 || f>4);
            fleche1 = new Fleche(f);
            if(f==1 || f==3)
            {
                direction1 = true;
                mot1 = new Mot(m1, direction1, posX+1, posY);
            }
            else
            {
                direction1 = false;
                mot1 = new Mot(m1, direction1, posX, posY+1);
            }


        }

        else
        {
            int f1 = 0;
            int f2 = 0;
            System.out.print("Entrez la définition de votre premier mot : ");
            def1 = scanner.nextLine();
            System.out.print("Entrez votre premier mot : ");
            String m1 = scanner.nextLine();
            do {
                System.out.print("Entrez la direction de la fleche du premier mot (1=Droite, 2=Bas, 3=Bas-Droite, 4=Droite-Bas :");
                f1 = scanner.nextInt();
            }while (f1<1 || f1>4);
            fleche1 = new Fleche(f1);
            if(f1==1 || f1==3)
            {
                direction1 = true;
                mot1 = new Mot(m1, direction1, posX+1, posY);
            }
            else
            {
                direction1 = false;
                mot1 = new Mot(m1, direction1, posX, posY+1);
            }

            System.out.print("Entrez la définition de votre deuxieme mot : ");
            def1 = scanner.nextLine();
            System.out.print("Entrez votre deuxieme mot : ");
            String m2 = scanner.nextLine();
            do {
                System.out.print("Entrez la direction de la fleche du deuxieme mot (1=Droite, 2=Bas, 3=Bas-Droite, 4=Droite-Bas :");
                f2 = scanner.nextInt();
            }while (f2<1 || f2>4);
            fleche1 = new Fleche(f2);
            if(f2==1 || f2==3)
            {
                direction2 = true;
                mot2 = new Mot(m2, direction1, posX+1, posY);
            }
            else
            {
                direction2 = false;
                mot2 = new Mot(m2, direction1, posX, posY+1);
            }
        }

    }
}
