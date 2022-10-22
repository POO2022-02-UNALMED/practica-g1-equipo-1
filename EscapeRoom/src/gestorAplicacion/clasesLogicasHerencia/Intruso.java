package gestorAplicacion.clasesLogicasHerencia;
import java.util.ArrayList;

import gestorAplicacion.clasesLogicas.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author LENOVO
 */
public class Intruso extends Individuo{
	private Habitacion habitacion;
	private ArrayList<Herramientas> invetario = new ArrayList<>(); //Creo que el unico que debe tener inventario es el intruso
    private static final int ATTACK = 10;
    
    public Intruso() {
        super(100, 0, 10);
    }
    
    //Interacciones
    public void agarrar(){
        //input de que quiere agarrar
    	//Hacer for por habitacion buscando los objetos y agregandolos a esta lista y borrandolos de la habitacion'
    	
        
    }
    
    
    //METODOS PELEAR
    @Override
    public void atacar(Individuo r){
        r.setHealth(r.getHealth()-ATTACK);
    }
    public void atacar(Individuo r, int bonus){
        r.setHealth(r.getHealth()-ATTACK-bonus);
    }
    
    //METODOS GET
    public static int getATTACK(){
        return ATTACK;
    }
    
    //METODOS SET
    
}
