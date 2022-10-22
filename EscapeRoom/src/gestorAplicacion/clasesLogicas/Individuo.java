package gestorAplicacion.clasesLogicas;


import java.util.ArrayList;

public abstract class Individuo {
    private int health, armor,speed;
    private boolean stunned = false;
    private ArrayList<Herramientas> inventory = new ArrayList<>();
    
    public Individuo(int health,int armor, int speed){
        this.health = health;
        this.armor = armor;
        this.speed = speed;
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
    public ArrayList<Herramientas> getInventory(){
        return inventory;
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
