package exec;

import controller.*;
import modele.*;

public class Start_CTRL {

    public static void main(String[] args){
        I_modeleGrille gv = new GrilleVirtuelle(0,0);
        I_Controller ctrl = new ControllerGrille(gv);


    }


}
