package vue;

import controller.*;
import modele.*;
import observer.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GrilleGraphique extends JFrame implements I_Observateur, I_Grille, ActionListener, MouseListener {

    private int largeur = 3;
    private int hauteur = 3;
    private final int TAILLECASE = 100;
    private ArrayList<JLabel> tableau = new ArrayList<>();

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem addTestMenuItem;
    private JMenuItem addTestLetter;
    private JMenuItem addEssaiMenuItemOk;
    private JMenuItem addEssaiMenuItemKO;
    private I_Controller controller;
    private I_modeleGrille modele;

    public GrilleGraphique(I_Controller ctrl, I_modeleGrille modele) throws HeadlessException{

        this.controller = ctrl;
        this.modele = modele;
        modele.addObservateur(this);
        this.largeur = modele.getLargeur();
        this.hauteur = modele.getHauteur();
        System.out.printf("Création d'une grille %s x %s%n", this.largeur,this.hauteur);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(TAILLECASE * largeur, TAILLECASE * hauteur));
        setLocation(100,200);
        setResizable(false);
        GridLayout layout = new GridLayout(hauteur, largeur);
        setLayout(layout);
        createControls();
        buildGrilleChiffres();
        setVisible(true);
        pack();

    }

    public void ajouterLettreTableau(String c,int x, int y){
        tableau.get((((y-1)*largeur)+x)-1).setText(c);

    }

    private void createControls(){
        menuBar = new JMenuBar();
        menu = new JMenu("actions");
        addTestLetter = new JMenuItem("Ajouter un L");
        menu.add(addTestLetter);
        addTestLetter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                modele.ajouterLettre("L",1,1);
                ajouterLettreTableau("L",1,1);
            }
        });
        addEssaiMenuItemOk = new JMenuItem("Ajouter un mot horizontal");
        menu.add(addEssaiMenuItemOk);
        addEssaiMenuItemOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame frame = new JFrame();
                int x=0;
                int y=0;
                do {
                    x = Integer.parseInt(JOptionPane.showInputDialog(frame, "Position X de depart du mot :"));
                }while (x<1 || x>10);
                do {
                    y = Integer.parseInt(JOptionPane.showInputDialog(frame, "Position Y de depart du mot :"));
                }while (y<1 || y>10);
                String mot = JOptionPane.showInputDialog(frame, "Entrez votre mot :");
                for (int i=0;i<mot.length();i++) {
                    ajouterLettreTableau(String.valueOf(mot.charAt(i)),x+i,y);
                }
                controller.ajouterMotHoriz(mot, x, y);
            }
        });
        addEssaiMenuItemOk = new JMenuItem("Ajouter un mot vertical");
        menu.add(addEssaiMenuItemOk);
        addEssaiMenuItemOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame frame = new JFrame();
                int x=0;
                int y=0;
                do {
                    x = Integer.parseInt(JOptionPane.showInputDialog(frame, "Position X de depart du mot :"));
                }while (x<1 || x>10);
                do {
                    y = Integer.parseInt(JOptionPane.showInputDialog(frame, "Position Y de depart du mot :"));
                }while (y<1 || y>10);
                String mot = JOptionPane.showInputDialog(frame, "Entrez votre mot :");
                for (int i=0;i<mot.length();i++) {
                    ajouterLettreTableau(String.valueOf(mot.charAt(i)),x,y+i);
                }
                controller.ajouterMotVert(mot, x, y);
            }
        });
        JMenuItem exit = new JMenuItem("Quitter");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        menu.add(exit);
        menuBar.add(menu);
        setJMenuBar(menuBar);

    }

    private void buildGrilleChiffres(){
        for(int i=1; i<=hauteur; i++) {
            for (int j = 1; j <= largeur; j++) {
                JLabel jl;
                if(i%2==0)
                {
                    jl = jl(".", new Color(212+((j%2)*12), 212+((j%2)*12), 212+((j%2)*12)));
                }
                else {
                    jl = jl(".", new Color(212+((((j+1)%2)*12)), 212+((((j+1)%2)*12)), 212+((((j+1)%2)*12))));
                }
                jl.addMouseListener(this);
                tableau.add(jl);
                add(jl);
            }
        }
    }

    private JLabel jl(String lettre, Color c){
        JLabel label = new JLabel(lettre);
        label.setOpaque(true);
        label.setBackground(c);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, TAILLECASE/2));
        return label;
    }

    @Override
    public void update(GrilleVirtuelle gv){
        for(int i=1; i<=hauteur * largeur; i++) {
        }

        Case[][] tab = gv.getTableauDeCases();
        for(int h=0;h<gv.getHauteur();h++){
            for(int l=0;l<gv.getLargeur();l++){
                tableau.get(h * gv.getLargeur()+l).setText(String.valueOf(tab[l][h]));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

    @Override
    public void sendMessage(String s){
        JOptionPane.showMessageDialog(null, s);
    }

    @Override
    public void mouseClicked(MouseEvent arg0){
        if(arg0.getSource() instanceof JLabel){
            System.out.println(arg0.getSource().toString());
            JLabel j = (JLabel)arg0.getSource();
            System.out.println(j.getText());
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0){

    }

    @Override
    public void mouseExited(MouseEvent arg0){

    }

    @Override
    public void mousePressed(MouseEvent arg0){

    }

    @Override
    public void mouseReleased(MouseEvent arg0){

    }




}
