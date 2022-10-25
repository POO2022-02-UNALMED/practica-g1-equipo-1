package gestorAplicacion.clasesLogicas;
import java.io.Serializable;
import java.util.ArrayList;


public enum Ahorro implements Serializable{
	
    ACTIVADO, ENCENDIDO, APAGADO, ROTO;
	private static ArrayList<Ahorro> ahorros = new ArrayList<>();

	public static ArrayList<Ahorro> getAhorros() {
		return ahorros;
	}

	
	

}