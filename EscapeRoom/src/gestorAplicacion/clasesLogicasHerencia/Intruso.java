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
    	for (Herramientas herramientas : getUbicacion().getListaObjetos() ) {
    		if(herramientas.)
    		if( herramientas instanceof Armas ) {
    			weaponInventory.add((Armas) herramientas);
    		}
    		else {
 
    			objectInventory.add((Objetos) herramientas);
    		}
    	this.getUbicacion().setListaObjetos(null);
    		//inventory.add(this.getUbicacion().getListaObjetos().get(i));
    		//this.getUbicacion().setListaObjetos(null);
    	}
    	//Hacer for por habitacion buscando los objetos y agregandolos a esta lista y borrandolos de la habitacion'
    }
    
    
    public void interactuarObjetos() {
    	
    }
    
    public void ineractiarArmas() {
    	
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

    @Override
    public void addHistorial() {
        Intruso.getHistorial().add("Intruso se movio a la habitacion: " + this.getUbicacion().getNumero());
    }

    @Override
    public void mover(Habitacion hab) {
        this.getUbicacion().setLuces(Ahorro.APAGADO);//apaga las luces
        this.getUbicacion().setIntruso(null);
        this.setUbicacion(hab);
        this.getUbicacion().setLuces(Ahorro.ENCENDIDO);//enciende las luces de la habitacion siguiente
        this.getUbicacion().setIntruso(this);
        this.addHistorial();    
    }
    
}
