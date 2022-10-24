package gestorAplicacion.clasesLogicasHerencia;
import java.util.ArrayList;
import java.util.Objects;

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
	
	
	public String mostrarArmas() {
		String mensaje = "Tienes estas armas:  ";
        for(Armas arma: weaponInventory) {
            mensaje += arma.getName();
	    }
        return mensaje;
	}
	
	
	public String mostrarObjetos() {
		String mensaje = "Tienes estos objetos: ";
        for(Objetos objeto: objectInventory) {
            mensaje += objeto.getName();
	    }
        return mensaje;
	}
	
	public String interactuar(Objetos objeto) { //Hacer que escoja el objeto
    	if( objeto.getBonusHealth() == 0) {
    		//Es una llave
    		if(objeto.getNumero() == this.getUbicacion().getNumero()) {
    			this.getUbicacion().setBloqueada(false);
    			return "Puerta desbloqueada";
    		}
    		
    	}
    	else {
    		//es recuperar vida
    		this.setHealth(this.getHealth() + objeto.getBonusHealth());
    		return "Su salud a aumentado";
    	}
		return null; //Agregue esto para corregir el error
    	
    }
	
    //Interacciones
    public void agarrar(){//Agrega al inventario los objetos de la habitacion y los elimina de los objetos de la habitacion
    	if (this.getUbicacion().getNumero() == 3 || this.getUbicacion().getNumero() == 6  || this.getUbicacion().getNumero() == 8 ) {
    		this.getUbicacion().setAlarma(Ahorro.ACTIVADO);
    		
    	}
    	for (Herramientas herramientas : getUbicacion().getListaObjetos() ) {
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
    public void addHistorial() {
        Intruso.getHistorial().add("Intruso se movio a la habitacion: " + this.getUbicacion().getNumero());
    }

    @Override
    public void mover(Habitacion hab) {
    	if (hab.isBloqueada()) {
    		habitacionesDisponibles();
    	}
    	
    	else {
            this.getUbicacion().setLuces(Ahorro.APAGADO);//apaga las luces
            this.getUbicacion().setIntruso(null);
            this.setUbicacion(hab);
            this.getUbicacion().setLuces(Ahorro.ENCENDIDO);//enciende las luces de la habitacion siguiente
            this.getUbicacion().setIntruso(this);
            this.addHistorial(); 
    	}
   
    }
    
  //Metodos de jarvis
    
    public String infohabitacion() {
    	String mensaje = "Las habitaciones son: ";
    	for (Habitacion habita: habitacionesJarvis) {
    	    mensaje += habita.getNumero() + " ";
    	}
    	return mensaje ;
    }

    public String infoRobot() {
        String ultimo =Robot.getHistorial().get(Robot.getHistorial().size()-1);
    	return  ultimo;
    }
    
    @Override
    public String ayudaJarvis() { //tipo dato aleatorio
    	Habitacion habitacionAzar = habitacionesJarvis.get((int) Math.floor(Math.random() * (habitacionesJarvis.size()) -1)); //get un numero al azar, mirar bien si si retorna como quiero
        if(habitacionAzar.getListaObjetos() == null) {
        	return "En la habitacion "+habitacionAzar.getNumero()+" no hay objetos." ;
        }
        else {
        	for (String nombres: habitacionesJarvis) { //que esto de los nombres de los objetos de las habitaciones y los returne abajo
        		
        	}
        	return "En la habitacion "+habitacionAzar.getNumero()+" hay estos objetos: " ; //Recorrer la lista de objetos y devolverla
        }
    }
}
