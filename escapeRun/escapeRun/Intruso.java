/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escapeRun;

/**
 *
 * @author LENOVO
 */
public class Intruso extends Individuo{
    private static final int ATTACK = 10;
    
    public Intruso() {
        super(100, 0, 10);
    }
    
    //METODOS PELEAR
    @Override
    public void atacar(Individuo r){
        r.setHealth(r.getHealth()-ATTACK);
    }
    
    //METODOS GET
    public static int getATTACK(){
        return ATTACK;
    }
    
    //METODOS SET
    
}
