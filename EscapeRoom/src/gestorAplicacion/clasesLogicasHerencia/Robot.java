package gestorAplicacion.clasesLogicasHerencia;
import gestorAplicacion.clasesLogicas.*;
import java.util.ArrayList;
import java.util.Objects;
import uiMain.Main;


public class Robot extends Individuo {
		private static final int ATTACK = 12;
        private boolean aware,nextTo;//atributo que guarda si el robot sabe donde esta el intruso
        private boolean cargaRobot; //para ataque cargado
        private Habitacion goingTo;//hacia donde se va a mover

	public Robot() {
        super(300, 3, 7);
        aware = false;
        nextTo = false;
        cargaRobot = false;
    }
    
    //Metodos de busqueda
    public void escuchar(Habitacion[] casa){
        for(int i = 0; i < casa.length; i++){
            if(casa[i].getAlarma().equals(Ahorro.ACTIVADO)){
                this.aware = true;
                break;
            } else {
                this.aware = false;
            }
        }
    }
    public void escanear(){
        ArrayList<Habitacion> disponibles = new ArrayList<>();
	disponibles.add(this.getUbicacion().getNorte());
	disponibles.add(this.getUbicacion().getSur());
	disponibles.add(this.getUbicacion().getEste());
	disponibles.add(this.getUbicacion().getOeste());
        for(Habitacion Hab: disponibles) {
            if (!Objects.isNull(Hab) && Hab.getLuces().equals(Ahorro.ENCENDIDO)) {
                nextTo = true;
                goingTo = Hab;
                break;
	    } else {
                nextTo = false;
            }
	}
    }
    
    public void buscar(){
        
    }


    //METODOS PELEAR
    @Override
    public void atacar(Individuo i) {
        i.setHealth(i.getHealth()-ATTACK);
    }
    public String ataqueCargado(Individuo i, int bloquear){
        cargaRobot = false;
        if (Main.lanzarDados(5) >= i.getArmor() + bloquear) {
            this.atacar(i);
            this.atacar(i);
            this.atacar(i);
            return "El robot lanza un poderoso laser hacia ti!!";
        } else {
            return "El robot lanza un poderoso laser hacia ti! Por suerte, logras esquivarlo";
	}
    }
    public String turno(int desicion,Individuo i, int bloquear){
        if (desicion < 6) {// del 1 al 5 ataque normal
            if (Main.lanzarDados(5) >= i.getArmor() + bloquear) {
                this.atacar(i);
                return "El robot te acaba de asestar un golpe";
            } else {
                return "Bloqueaste el golpe del robot";
	    }

	} else if (desicion == 6 || desicion == 7) {// 6 o 7 recarga de ataque cargado
            cargaRobot = true;
            return "El pecho del robot comienza a brillar con fuerza";
	} else if (desicion == 8 || desicion == 9) {// 8 o 9 stunear
            if (Main.lanzarDados(5) >= i.getArmor() + bloquear) {
                i.stun(true);
                return "El robot te electrocutó, estarás aturdido por el siguiente turno";
	    } else {
		return "Bloqueaste el golpe del robot";
	    }
	} else if (desicion == 10) {// 10 roba un objeto
	    return "robar objeto";
	} else {
            return "";
        }
    }
    
    //METODOS GET
    public static int getATTACK(){
        return ATTACK;
    }
    public boolean isAware(){
        return aware;
    }
    public boolean isNextTo(){
        return nextTo;
    }
    public boolean isCargaRobot(){
        return cargaRobot;
    }
    public Habitacion getGoingTo(){
        return goingTo;
    }
    
    //METODOS SET
    public void setAware(boolean b){
        aware = b;
    }

    @Override
    public String ayudaJarvis() {
        String a;
        if(aware || nextTo){
            a = "sabe dónde estás.";
        } else {
            a = "no nota tu presencia... aún.";
        }
        return "El robot se encuentra en la habitacion " + this.getUbicacion().getNumero() + ", tiene " + this.getHealth() + " puntos de vida y " + a;
    }
    
    @Override
    public void addHistorial() {
        Robot.getHistorial().add("Robot se movio a la habitacion " + this.getUbicacion().getNumero());
    }

    @Override
    public void mover(Habitacion hab) {
        this.getUbicacion().setRobot(null);
        this.setUbicacion(hab);
        this.getUbicacion().setRobot(this);
        this.addHistorial();   
    }

   public int decidirDireccion(){
       ArrayList<Habitacion> disponibles = new ArrayList<>();
	disponibles.add(this.getUbicacion().getNorte());
	disponibles.add(this.getUbicacion().getSur());
	disponibles.add(this.getUbicacion().getEste());
	disponibles.add(this.getUbicacion().getOeste());
        ArrayList<Integer> i = new ArrayList<>();
        for(Habitacion Hab: disponibles) {
            if (!Objects.isNull(Hab)) {
                i.add(Hab.getNumero());	    }
	}
        return i.get(Main.lanzarDados(i.size())-1);
   }
}
