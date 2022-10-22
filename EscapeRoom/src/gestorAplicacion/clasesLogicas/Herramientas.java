package gestorAplicacion.clasesLogicas;



public class Herramientas {
    private String description = "objeto generico";
    private final String name;
    private final boolean weapon, shocker, usable;
    private final int bonusDamage, bonusArmor, bonusSpeed, bonusHealth;
    
    public Herramientas(String name, boolean weapon,boolean shocker, boolean usable, int bdamage, int barmor, int bspeed, int bhealth){
        this.name = name;
        this.weapon = weapon;
        this.shocker = shocker;
        this.usable = usable;
        this.bonusDamage = bdamage;
        this.bonusArmor = barmor;
        this.bonusSpeed = bspeed;
        this.bonusHealth = bhealth;
    }
    
    public Herramientas(String name){//para crear objetos como computadores,ventanas o cosas que no se puedan recoger.
        this.name = name;
        this.weapon = false;
        this.shocker = false;
        this.usable = false;
        this.bonusDamage = 0;
        this.bonusArmor = 0;
        this.bonusSpeed = 0;
        this.bonusHealth = 0;
    }
    
    //METODOS GET
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public boolean isWeapon(){
        return weapon;
    }
    public boolean isShocker(){
        return shocker;
    }
    public boolean isUsable(){
        return usable;
    }
    public int getBonusDamage(){
        return bonusDamage;
    }
    public int getBonusArmor(){
        return bonusArmor;
    }
    public int getBonusSpeed(){
        return bonusSpeed;
    }
    public int getBonusHealth(){
        return bonusHealth;
    }
    
    //METODO SET
    public void setDescripion(String i){
        description = i;
    }

}
