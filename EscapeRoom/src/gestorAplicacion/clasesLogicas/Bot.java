/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorAplicacion.clasesLogicas;

import gestorAplicacion.clasesLogicasHerencia.Intruso;
import gestorAplicacion.clasesLogicasHerencia.Robot;
import uiMain.Main;

/**
 *
 * @author LENOVO
 */
public class Bot extends Robot{
    private static final int DUMPENER = 6;
    public Bot(){
        super(10, 0, 0, false, false, false);
        
    }
    
    @Override
    public void atacar(Individuo i) {
        i.setHealth(i.getHealth()- Bot.getATTACK()+DUMPENER);
    }
    
    @Override
    public String turno(int desicion,Individuo i){
        if (desicion < 6) {// del 1 al 5 ataque normal
            return "B.O.T.: No escaparas!!";

	} else if (desicion == 6 || desicion == 7) {// 6 o 7 recarga de ataque cargado
            return "B.O.T.: Estas perdido!!";
	} else if (desicion == 8 || desicion == 9) {// 8 o 9 stunear
            return "B.O.T.: JAJAJAJA";
	} else if (desicion == 10) {// 10 roba un objeto
            return"No te lleves lo que no es tuyo!!";
	} else {
            return "";
        }
    }
}
