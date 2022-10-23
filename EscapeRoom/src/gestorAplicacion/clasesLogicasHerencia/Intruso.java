package gestorAplicacion.clasesLogicasHerencia;
import java.util.ArrayList;

import gestorAplicacion.clasesLogicas.*;

public class Intruso extends Individuo{
    private ArrayList<Armas> weaponInventory = new ArrayList<>(); //inventario armas
    private ArrayList<Objetos> objectInventory = new ArrayList<>();//inventario objetos
    private static final int ATTACK = 10;
    
    public Intruso(int health, int armor, int speed) {
		super(health, armor, speed);
		
	}

	public Intruso() {
        this(100,0,0);
        
    }
    
    //Interacciones
    public void agarrar(){ //Agrega al inventario los objetos de la habitacion y los elimina de los objetos de la habitacion 
    	for (int i=0;i<this.getUbicacion().getListaObjetos().size();i++) {
    		//inventory.add(this.getUbicacion().getListaObjetos().get(i));
    		//this.getUbicacion().setListaObjetos(null);
    	}
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
    
    public ArrayList<Armas> getWeaponInventory(){
        return weaponInventory;
    }
    public ArrayList<Objetos> getObjectInventory(){
        return objectInventory;
    }
    
    //METODOS SET

    @Override
    public String ayudaJarvis() {
        return "dar pista";
    }
    
}
