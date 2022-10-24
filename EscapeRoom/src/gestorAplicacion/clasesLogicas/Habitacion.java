package gestorAplicacion.clasesLogicas;


import java.util.ArrayList;

public class Habitacion implements Jarvis{
	private int numero; //Que numero es la habitacion
	private boolean bloqueada; //Si tiene bloqueo o no
	private ArrayList<Herramientas> listaObjetos = new ArrayList<>();//El listado de objetos de cada habitacion
	private Individuo intruso, robot; //Si hay alguien en la habitacion
        private Habitacion norte, sur, este, oeste;	
        private Ahorro luces, alarma, computador;
	public Habitacion(int numero, boolean bloqueada, ArrayList<Herramientas> listaObjetos, Individuo intruso,
			Individuo robot) { //Se podria modificar este constructor para que se inicialice con lo que queremos o crear el vacio
		this.numero = numero;
		this.bloqueada = bloqueada;
		this.listaObjetos = listaObjetos;
		this.intruso = intruso;
		this.robot = robot;
                this.luces = Ahorro.APAGADO;
                this.alarma = Ahorro.APAGADO;
                this.computador = Ahorro.APAGADO;
                
                Individuo.habitacionesJarvis.add(this);
	}

	//Desbloquar puerta con una herramienta
	public String desbloquar() {
		if (bloqueada == true) {
			//buscar una clave de acceso y desbloquar la puerta
			
		}
		return "Puerta desbloquada, puede avanzar";
	}
	
	//Getter y setters
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isBloqueada() {
		return bloqueada;
	}
	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}

	public ArrayList<Herramientas> getListaObjetos() {
		return listaObjetos;
	}
	public void setListaObjetos(ArrayList<Herramientas> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}

	public Individuo getIntruso() {
		return intruso;
	}
	public void setIntruso(Individuo intruso) {
		this.intruso = intruso;
	}

	public Individuo getRobot() {
		return robot;
	}
	public void setRobot(Individuo robot) {
		this.robot = robot;
	}
        
        public void setAlarma(Ahorro a){
            alarma = a;
        }
        public Ahorro getAlarma(){
            return alarma;
        }
        public void setLuces(Ahorro a){
            luces = a;
        }
        public Ahorro getLuces(){
            return luces;
        }
        public void setComputador(Ahorro a){
            alarma = a;
        }
        
	
        public void setHabitacionesContiguas(Habitacion norte, Habitacion sur, Habitacion este, Habitacion oeste){
            this.norte = norte;
            this.sur = sur;
            this.este = este;
            this.oeste = oeste;
        }
        
        public Habitacion getNorte(){
            return norte;
        } 
        public Habitacion getSur(){
            return sur;
        }
        public Habitacion getEste(){
            return este;
        }
        public Habitacion getOeste(){
            return oeste;
        }

    @Override
    public String ayudaJarvis() {
        String a;
        if(intruso != null ){
            a = "estas ahi";
        } else if(robot != null){
            a = "el robot esta ahi";
        } else {
            a = "no hay nadie ahi";
        }
        return "En esta habitacion hay " + listaObjetos.size() + " objetos, " + a;//y ya pasaste o no has pasado por ahi
    }
}
