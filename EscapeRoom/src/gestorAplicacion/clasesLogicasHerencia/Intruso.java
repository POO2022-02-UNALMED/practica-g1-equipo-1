package gestorAplicacion.clasesLogicasHerencia;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import baseDatos.Deserializador;


import gestorAplicacion.clasesLogicas.*;

public class Intruso extends Individuo implements Serializable{
	private static ArrayList<Intruso> intrusos = new ArrayList<Intruso>();
	
	private static final long serialVersionUID= 1L;
	
	public static ArrayList<Intruso> getIntrusos() {
		return intrusos;
	}
	

        /*public static void setIntrusos(List<Intruso> intrusos) {
        Intruso.intrusos = intrusos;
        }*/

	
    private ArrayList<Armas> weaponInventory = new ArrayList<>(); //inventario armas
    private ArrayList<Objetos> objectInventory = new ArrayList<>();//inventario objetos
    private static final int ATTACK = 10;
    
    public Intruso(int health, int armor, int speed) {
		super(health, armor, speed);
		intrusos.add(this);
	}

	public Intruso() {
        this(100,0,0);
        
    }
	
	
	public String mostrarArmas() {
		String mensaje = "Tienes estas armas:  ";
                int i = 1;
        for(Armas arma: weaponInventory) {
            mensaje +=  "\n" + i + ". " + arma.getName()+ ".";
            i++;
	    }
        return mensaje;
	}
	public String mostrarObjetos() {
		String mensaje = "Tienes estos objetos:";
                int i = 1;
        for(Objetos objeto: objectInventory) {
            mensaje += "\n" + i + ". " + objeto.getName() + ".";
            i++;
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
    public String agarrar(){//Agrega al inventario los objetos de la habitacion y los elimina de los objetos de la habitacion
        String m = "sin problemas.";
    	if (this.getUbicacion().getAlarma().equals(Ahorro.ACTIVADO)) {
    		this.getUbicacion().setAlarma(Ahorro.ENCENDIDO);
                m = "una alarma empezo a sonar.";
    	}
    	for (Herramientas herramientas : this.getUbicacion().getListaObjetos() ) {
    		if( herramientas instanceof Armas ) {
    			weaponInventory.add((Armas) herramientas);
    		}
    		else {
    			objectInventory.add((Objetos) herramientas);
    		}
    	}
        this.getUbicacion().getListaObjetos().clear();
        return "Recogiste todos los objetos, " + m;
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
    public void setWeaponInventory(ArrayList<Armas> a){
        weaponInventory = a;
    }
    public void setObjectInventory(ArrayList<Objetos> o){
        objectInventory = o;
    }

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
            if(!this.getUbicacion().getLuces().equals(Ahorro.ROTO)){
                this.getUbicacion().setLuces(Ahorro.APAGADO);//apaga las luces
            }
            this.getUbicacion().setIntruso(null);
            this.setUbicacion(hab);
            if(!this.getUbicacion().getLuces().equals(Ahorro.ROTO)){
                this.getUbicacion().setLuces(Ahorro.ENCENDIDO);//enciende las luces
            }
            this.getUbicacion().setIntruso(this);
            this.addHistorial(); 
    	}
   
    }
    
  //Metodos de jarvis
    
    /*public String infohabitacion() {
    String mensaje = "Las habitaciones son: ";
    for (Habitacion habita: habitacionesJarvis) {
    mensaje += habita.getNumero() + " ";
    }
    return mensaje ;
    }*/

    /*  public String infoRobot() {
    String ultimo =Robot.getHistorial().get(Robot.getHistorial().size()-1);
    return  ultimo;
    }*/
    
    @Override
    public String ayudaJarvis() { //tipo dato aleatorio
        /*Habitacion habitacionAzar = habitacionesJarvis.get((int) Math.floor(Math.random() * (habitacionesJarvis.size()) -1)); //get un numero al azar, mirar bien si si retorna como quiero
        if(habitacionAzar.getListaObjetos() == null) {
        return "En la habitacion "+habitacionAzar.getNumero()+" no hay objetos." ;
        }
        else {
        //for (String nombres: habitacionesJarvis) { //que esto de los nombres de los objetos de las habitaciones y los returne abajo
        
        
        return "En la habitacion "+habitacionAzar.getNumero()+" hay estos objetos: " ; //Recorrer la lista de objetos y devolverla
        }*/
        String mensaje = "Te encuentras en la habitacion " + this.getUbicacion().getNumero();
        if (this.getUbicacion().getListaObjetos().isEmpty() && this.getUbicacion().getLuces().equals(Ahorro.ENCENDIDO)){
            mensaje += "\nNo hay objetos que recoger en esta habitacion";
        } else if (!this.getUbicacion().getListaObjetos().isEmpty() && this.getUbicacion().getLuces().equals(Ahorro.ENCENDIDO)) {
            mensaje += "\nVes algunos objetos que te podrian ser utiles: ";
            for(Herramientas h : this.getUbicacion().getListaObjetos()){
                mensaje += "\n" + h.getName() + ": " + h.getDescription();
            }            
        } else {
            mensaje += "\nNo hay luz, por lo que no ves nada.";
        }
        if (this.getUbicacion().getAlarma().equals(Ahorro.ENCENDIDO)){
            mensaje += "\nUna alarma esta sonando en la habitacion.";
        }
        return mensaje;
    }
}
