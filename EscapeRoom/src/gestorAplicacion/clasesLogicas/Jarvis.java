package gestorAplicacion.clasesLogicas;
import gestorAplicacion.clasesLogicasHerencia.*;

public interface Jarvis {
    String PISTA1 = "J.A.R.V.I.S.: Las habitaciones bloqueadas pueden ser accesadas por medio de llaves especiales, revisa cada habitacion y puede que las encuentres.";
    String PISTA2 = "J.A.R.V.I.S.: Si tu vida es muy baja puedes intentar huir del robot, sobrevive hoy para luchar mañana.";
    String PISTA3 = "J.A.R.V.I.S.: El robot puede detectar si las luces de la habitacion contigua estan encendidas, si las apagas podrias pasar desapercibido.";
    String PISTA4 = "J.A.R.V.I.S.: Por cada accion que realices, el robot se mueve de habitacion buscandote, procura no quedarte mucho tiempo en una misma habitacion.";
    String PISTA5 = "J.A.R.V.I.S.: El objeto que buscas se encuentra en la habitacion 9, si lo obtienes podrias salir de aqui con vida, apresurate!";
	//public String infohabitacion();
	//public String infoRobot();
	public String ayudaJarvis();
	
	
}
