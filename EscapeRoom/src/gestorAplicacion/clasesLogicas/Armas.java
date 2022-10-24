package gestorAplicacion.clasesLogicas;



public class Armas implements Herramientas {
    private String description = "objeto generico";
    private final String name;
    private final int bonusDamage, bonusSpeed;
    
    public Armas(String name, int bdamage, int bspeed){
    	this.name = name;
        this.bonusDamage = bdamage;
        this.bonusSpeed = bspeed;;
    }
    
    public Armas(String name){//para crear objetos como computadores,ventanas o cosas que no se puedan recoger.
    	this.name = name;
        this.bonusDamage = 0;
        this.bonusSpeed = 0;
    }
    
    //METODOS GET
    
    public String getName(){
        return name;
    }
    
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
