
package escapeRun;


public class Robot extends Individuo {
        private static final int ATTACK = 12;

    
    public Robot() {
        super(300, 3, 7);
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

   
}
