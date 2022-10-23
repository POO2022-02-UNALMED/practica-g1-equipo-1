package gestorAplicacion.clasesLogicas;



public class Armas implements Herramientas {
    private boolean alarma;
    private String description = "objeto generico";
    private final String name;
    private final int bonusDamage, bonusSpeed;
    
    public Armas(boolean alarma, String name, int bdamage, int bspeed){
        this.alarma = alarma;
    	this.name = name;
        this.bonusDamage = bdamage;
        this.bonusSpeed = bspeed;;
    }
    
    public Armas(String name){//para crear objetos como computadores,ventanas o cosas que no se puedan recoger.
        this.alarma = false;
    	this.name = name;
        this.bonusDamage = 0;
        this.bonusSpeed = 0;
    }
    
    //METODOS GET
    
    public String getName(){
        return name;
    }
    
    public void setAlarma(boolean alarma) {
        this.alarma = alarma;
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
    public boolean isAlarma() {
        return alarma;
    }

    @Override
    public void usar(Individuo i) {
       
    }
}
