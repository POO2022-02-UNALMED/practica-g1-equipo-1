package gestorAplicacion.clasesLogicasHerencia;
import gestorAplicacion.clasesLogicas.*;


public class Robot extends Individuo {
        private static final int ATTACK = 12;

    
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

    @Override
    public void ayudaJarvis() {
        //retorna la ubicacion del robot
    }

   
}
