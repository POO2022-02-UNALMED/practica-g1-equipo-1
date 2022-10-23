package gestorAplicacion.clasesLogicasHerencia;
import gestorAplicacion.clasesLogicas.*;


public class Robot extends Individuo {
        private static final int ATTACK = 12;
        private boolean aware;//atributo que guarda si el robot sabe donde esta el intruso

    
    public Robot() {
        super(300, 3, 7);
    }
    
    //Metodos de busqueda
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
    
    //METODOS SET
    public void setAware(boolean b){
        aware = b;
    }

    @Override
    public String ayudaJarvis() {
        String a;
        if(aware){
            a = "sabe dónde estás.";
        } else {
            a = "no nota tu presencia... aún.";
        }
        return "El robot se encuentra en la habitacion" + this.getUbicacion().getNumero() + ", tiene " + this.getHealth() + " puntos de vida y " + a;
    }

   
}
