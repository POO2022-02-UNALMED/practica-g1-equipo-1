package gestorAplicacion.clasesLogicasHerencia;
import gestorAplicacion.clasesLogicas.*;
import java.util.ArrayList;
import java.util.Objects;
import uiMain.Main;


public class Robot extends Individuo {
        private static final int ATTACK = 12;
        private boolean aware,nextTo;//atributo que guarda si el robot sabe donde esta el intruso

    
    public Robot() {
        super(300, 3, 7);
        aware = false;
        nextTo = false;
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
        if (this.getUbicacion().getNorte().getLuces().equals(Ahorro.ENCENDIDO) 
                || this.getUbicacion().getSur().getLuces().equals(Ahorro.ENCENDIDO) 
                || this.getUbicacion().getEste().getLuces().equals(Ahorro.ENCENDIDO) 
                || this.getUbicacion().getOeste().getLuces().equals(Ahorro.ENCENDIDO) ){
            nextTo = true;
            
        }
    }
    public void buscar(){
        
    }


    //METODOS PELEAR
    @Override
    public void atacar(Individuo i) {
        i.setHealth(i.getHealth()-ATTACK);
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
        return "El robot se encuentra en la habitacion" + this.getUbicacion().getNumero() + ", tiene " + this.getHealth() + " puntos de vida y " + a;
    }
    
    @Override
    public void addHistorial() {
        Robot.getHistorial().add("Robot se movio a la habitacion " + this.getUbicacion().getNumero());
    }

    @Override
    public void mover(Habitacion hab) {
        this.setUbicacion(hab);
        this.addHistorial();   
    }

   public int decidirDireccion(){
       ArrayList<Habitacion> disponibles = new ArrayList<>();
	disponibles.add(this.getUbicacion().getNorte());
	disponibles.add(this.getUbicacion().getSur());
	disponibles.add(this.getUbicacion().getEste());
	disponibles.add(this.getUbicacion().getOeste());
        int[] i = null;
        int j = 0;
        for(Habitacion Hab: disponibles) {
            if (!Objects.isNull(Hab)) {
                i[j] = Hab.getNumero();
                j++;
	    }
	}
        return i[Main.lanzarDados(i.length)-1];
   }
}
