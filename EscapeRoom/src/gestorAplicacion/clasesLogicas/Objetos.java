
package gestorAplicacion.clasesLogicas;

public class Objetos implements Herramientas{
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
    
    public String getName(){
        return name;
    }
    
    
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
            
        }
    }
}
