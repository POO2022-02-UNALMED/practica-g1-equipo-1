package gestorAplicacion.clasesLogicas;
import java.io.Serializable;


import java.util.ArrayList;

public class Armas implements Herramientas, Serializable {
    private String description = "objeto generico";
    private final String name;
    private final int bonusDamage, bonusSpeed;
    private static ArrayList<Armas> armas = new ArrayList<>();
    
    public static ArrayList<Armas> getArmas() {
		return armas;
	}

	public Armas(String name, int bdamage, int bspeed){
    	this.name = name;
        this.bonusDamage = bdamage;
        this.bonusSpeed = bspeed;
    }
    
    public Armas(String name){//para crear objetos como computadores,ventanas o cosas que no se puedan recoger.
    	this.name = name;
        this.bonusDamage = 0;
        this.bonusSpeed = 0;
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
    public int getBonusDamage(){
        return bonusDamage;
    }
    public int getBonusSpeed(){
        return bonusSpeed;
    }
    
    //METODO SET
    public void setDescripion(String i){
        description = i;
    }

    @Override
    public void usar(Individuo i) {
       
    }
}
