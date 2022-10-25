package gestorAplicacion.clasesLogicas;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import baseDatos.Deserializador;


public enum Ahorro implements Serializable{
	
    ACTIVADO, ENCENDIDO, APAGADO, ROTO;
	private static List<Ahorro> ahorros = new ArrayList<Ahorro>();
	
	private static final long serialVersionUID= 1L;

	public static List<Ahorro> getAhorros() {
		return ahorros;
	}

	public static void setAhorros(List<Ahorro> ahorros) {
		Ahorro.ahorros = ahorros;
	}
	
	

	
	

}