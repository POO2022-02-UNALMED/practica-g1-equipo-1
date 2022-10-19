package escapeRun;
import java.util.ArrayList;

public class Habitacion {
	private int numero; //Que numero es la habitacion
	private boolean bloqueada; //Si tiene bloqueo o no
	private ArrayList<Herramientas> listaObjetos = new ArrayList<>();//El listado de objetos de cada habitacion
	private Individuo intruso, robot; //Si hay alguien en la habitacion
	
	public Habitacion(int numero, boolean bloqueada, ArrayList<Herramientas> listaObjetos, Individuo intruso,
			Individuo robot) { //Se podria modificar este constructor para que se inicialice con lo que queremos o crear el vacio
		this.numero = numero;
		this.bloqueada = bloqueada;
		this.listaObjetos = listaObjetos;
		this.intruso = intruso;
		this.robot = robot;
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
	
}
