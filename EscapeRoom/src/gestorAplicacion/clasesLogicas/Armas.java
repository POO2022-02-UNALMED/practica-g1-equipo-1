package gestorAplicacion.clasesLogicas;
import java.io.Serializable;

import java.util.ArrayList;

public class Armas implements Herramientas, Serializable {
    private String description = "objeto generico";
    private final String name;
    private final int bonusDamage, bonusSpeed;
    private static ArrayList<Armas> armas = new ArrayList<Armas>();
    
    private static final long serialVersionUID= 1L;
    
    public static ArrayList<Armas> getArmas() {
		return armas;
	}

	public Armas(String name, int bdamage, int bspeed){
    	this.name = name;
        this.bonusDamage = bdamage;
        this.bonusSpeed = bspeed;
        armas.add(this);
        
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
    
    @Override
     public String toString(){   
        String m = "nombre: " + this.name + "\ndescripcion: " + this.description + "\nbonus damage: " + bonusDamage + "\nbonus speed: " + bonusSpeed + "\n";
        return m;
    }
}
