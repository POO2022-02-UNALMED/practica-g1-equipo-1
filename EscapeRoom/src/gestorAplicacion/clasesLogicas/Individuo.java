package gestorAplicacion.clasesLogicas;


import java.util.ArrayList;

public abstract class Individuo {
    private int health, armor, speed;
    private boolean stunned = false;
    private ArrayList<Integer> locations = new ArrayList<>();
    private Habitacion ubicacion;
    
    public Individuo(int health,int armor, int speed){
        this.health = health;
        this.armor = armor;
        this.speed = speed;
    }
    //Metodos para moverse
    public void mover(int j){
        switch (j){
            case 1:
                ubicacion = ubicacion.getNorte();
                break;
            case 2:
                ubicacion = ubicacion.getSur();
                break;
            case 3: 
                ubicacion = ubicacion.getEste();
                break;
            case 4:
                ubicacion = ubicacion.getOeste();
                break;
            default:
                break;
        }
    }
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
