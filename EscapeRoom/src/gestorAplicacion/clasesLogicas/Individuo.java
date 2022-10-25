package gestorAplicacion.clasesLogicas;


import java.util.ArrayList;
import java.util.Objects;

public abstract class Individuo implements Jarvis{
    public static ArrayList<Habitacion> habitacionesJarvis = new ArrayList<>();
    private int health, armor, speed;
    private boolean stunned = false;
    private static ArrayList<String> historial = new ArrayList<>();
    private Habitacion ubicacion;
    
    public Individuo(int health,int armor, int speed){
        this.health = health;
        this.armor = armor;
        this.speed = speed;
    }
    //Metodos para moverse
    public abstract void mover(Habitacion hab);
    
    public String habitacionesDisponibles(){
    ArrayList<Habitacion> disponibles = new ArrayList<>();
	disponibles.add(this.getUbicacion().getNorte());
	disponibles.add(this.getUbicacion().getSur());
	disponibles.add(this.getUbicacion().getEste());
	disponibles.add(this.getUbicacion().getOeste());
        String mensaje = "Puedes moverte a la habitacion numero: ";
        String mensaje2 = "Aun no puedes moverte a la habitacion numero: ";
        for(Habitacion Hab: disponibles) {
            if (!Objects.isNull(Hab) && Hab.isBloqueada()) {
                mensaje2 += Hab.getNumero() + " Porque esta Bloqueada ";
	    }
            if (!Objects.isNull(Hab)) {
                mensaje += Hab.getNumero() + " ";
            }
        }
        return mensaje+"\n"+mensaje2;
	}
    
    public String habitacionesaDesbloquear() {
    	ArrayList<Habitacion> disponibles = new ArrayList<>();
    	disponibles.add(this.getUbicacion().getNorte());
    	disponibles.add(this.getUbicacion().getSur());
    	disponibles.add(this.getUbicacion().getEste());
    	disponibles.add(this.getUbicacion().getOeste());
    	String mensaje = "Estas habitaciones estan bloqueada: ";
        boolean b = false;
      //  String mensaje2 = "Esta habitaciones no estan bloqueadas: ";
        for(Habitacion Hab: disponibles) {
            if (!Objects.isNull(Hab) && Hab.isBloqueada()) {
                mensaje += Hab.getNumero() + " ";
                b = true;
	    }
        //    if (!Objects.isNull(Hab)) {
          //      mensaje2 += Hab.getNumero() + " ";
	    //}
    	
    }
        if(b){
            return mensaje;
        } else {
            return "no hay habitaciones bloqueadas alrededor";
        }
    }
    public abstract void addHistorial();
    //Metodo para agarrar
    
    // METODOS PELEAR
    public abstract void atacar(Individuo i);
    // METODOS GET
    public int getHealth(){
        return health;
    }
    public int getArmor(){
        return armor;
    }
    public int getSpeed(){
        return speed;
    }
    public boolean isStunned(){
        return stunned;
    }
    public Habitacion getUbicacion(){
        return ubicacion;
    }
    public void setUbicacion(Habitacion ubicacion){
        this.ubicacion = ubicacion;
    }
    public static ArrayList<String> getHistorial(){
        return historial;
    }
    
    
    //METODOS SET
    public void setHealth(int i){
        health = i;
    }
    public void setArmor(int i){
        armor = i;
    }
    public void setSpeed(int i){
        speed = i;
    }
    public void stun(boolean i){
        stunned = i;
    }
}
