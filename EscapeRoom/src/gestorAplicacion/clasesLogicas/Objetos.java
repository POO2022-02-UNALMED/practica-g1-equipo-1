
package gestorAplicacion.clasesLogicas;
import java.io.Serializable;
import java.util.ArrayList;


public class Objetos implements Herramientas, Serializable{
	private static ArrayList<Objetos> objetos = new ArrayList<Objetos>();
    public static ArrayList<Objetos> getObjetos() {
		return objetos;
	}
    
    private static final long serialVersionUID= 1L;


	private String description = "objeto generico";
    private final String name;
    private final boolean shocker;
    private final int bonusArmor, bonusHealth;
    
    public Objetos(String name, boolean shocker, int barmor, int bhealth){
    	this.name = name;
        this.shocker = shocker;
        this.bonusArmor = barmor;
        this.bonusHealth = bhealth;
        objetos.add(this);
    }
    
    public Objetos(String name){
    	this.name = name;
        this.shocker = false;
        this.bonusArmor = 0;
        this.bonusHealth = 0;
        objetos.add(this);
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
    
    public String toString(){   
        String m = "nombre: " + this.name + "\ndescripcion: " + this.description + "\nbonus armor: " + bonusArmor + "\nbonus health: " + bonusHealth + "\n aturde: " + shocker + "\n";
        return m;
    }
}
