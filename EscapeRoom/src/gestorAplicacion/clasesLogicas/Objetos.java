
package gestorAplicacion.clasesLogicas;
import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.clasesLogicasHerencia.Robot;

public class Objetos implements Herramientas, Serializable{
	private static ArrayList<Objetos> objetos = new ArrayList<>();
    public static ArrayList<Objetos> getObjetos() {
		return objetos;
	}
    

	public static void setObjetos(ArrayList<Objetos> objetos) {
		Objetos.objetos = objetos;
	}


	private String description = "objeto generico";
    private final String name;
    private final boolean shocker;
    private final int bonusArmor, bonusHealth, numero;
    
    public Objetos(String name, boolean shocker, int barmor, int bhealth, int numero){
    	this.name = name;
        this.shocker = shocker;
        this.bonusArmor = barmor;
        this.bonusHealth = bhealth;
		this.numero = numero;
    }
    
    public Objetos(String name){//para crear objetos como computadores,ventanas o cosas que no se puedan recoger.
    	this.name = name;
        this.shocker = false;
        this.bonusArmor = 0;
        this.bonusHealth = 0;
		this.numero = 0;
    }
    
    //METODOS GET
    
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getDescription(){
        return description;
    }
    public boolean isShocker(){
        return shocker;
    }
    public int getBonusArmor(){
        return bonusArmor;
    }
    public int getBonusHealth(){
        return bonusHealth;
    }
   
    public int getNumero() {
		return numero;
	}

	//METODO SET
    public void setDescripion(String i){
        description = i;
    }

    @Override
    public void usar(Individuo i) {
        if (shocker){
            i.stun(true);
        } else {
            i.setArmor(i.getArmor()+bonusArmor);
            i.setHealth(i.getHealth()+bonusHealth);
            if (i.getHealth() > 100){i.setHealth(100);}
            
        }
    }
}
