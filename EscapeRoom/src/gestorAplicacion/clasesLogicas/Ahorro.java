package gestorAplicacion.clasesLogicas;

public class Ahorro implements Jarvis {
	private Habitacion habitacion;
	//No se si poner interruptor

	public Ahorro(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	//Getter y setters
	//HOLA PRUEBA

    @Override
    public String ayudaJarvis() {
        return "apaga y prende equipos";
    }
}