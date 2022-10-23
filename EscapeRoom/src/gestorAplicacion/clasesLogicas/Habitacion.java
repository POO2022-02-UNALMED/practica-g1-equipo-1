package gestorAplicacion.clasesLogicas;


import java.util.ArrayList;

public class Habitacion {
	private int numero; //Que numero es la habitacion
	private boolean bloqueada; //Si tiene bloqueo o no
	private ArrayList<Herramientas> listaObjetos = new ArrayList<>();//El listado de objetos de cada habitacion
	private Individuo intruso, robot; //Si hay alguien en la habitacion
    private Habitacion norte, sur, este, oeste;	
	public Habitacion(int numero, boolean bloqueada, ArrayList<Herramientas> listaObjetos, Individuo intruso,
			Individuo robot) { //Se podria modificar este constructor para que se inicialice con lo que queremos o crear el vacio
		this.numero = numero;
		this.bloqueada = bloqueada;
		this.listaObjetos = listaObjetos;
		this.intruso = intruso;
		this.robot = robot;
		
		switch(numero) {
		case 1:
			this.setHabitacionesContiguas(Numero4, null, Numero2, null);
		case 2:
			this.setHabitacionesContiguas(norte, sur, este, oeste);
		case 3:
			this.setHabitacionesContiguas(norte, sur, este, oeste);
		case 4:
			this.setHabitacionesContiguas(norte, sur, este, oeste);
		case 5:
			this.setHabitacionesContiguas(norte, sur, este, oeste);
		case 6:
			this.setHabitacionesContiguas(norte, sur, este, oeste);
		case 7:
			this.setHabitacionesContiguas(norte, sur, este, oeste);
		case 8:
			this.setHabitacionesContiguas(norte, sur, este, oeste);
		case 9:
			this.setHabitacionesContiguas(norte, sur, este, oeste);
		}
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
	
        public void setHabitacionesContiguas(Habitacion norte, Habitacion sur, Habitacion este, Habitacion oeste){
            this.norte = norte;
            this.sur = sur;
            this.este = este;
            this.oeste = oeste;
        }
        public Habitacion getNorte(){
            return norte.numero;
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
}
