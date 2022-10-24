package uiMain;

import gestorAplicacion.clasesLogicas.*;
import gestorAplicacion.clasesLogicasHerencia.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import gestorAplicacion.*;

public class Main {

	public static int lanzarDados(int caras) {// retorna un numero aleatorio del 1 a caras
		return (int) Math.floor(Math.random() * (caras) + 1);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int opcion; // aqui se guardan las opciones que va seleccionando el jugador
		boolean x = true; // variable temporal, mientras colocamos bien las condiciones
		Individuo iniciativa[] = new Individuo[2]; // organiza los turnos de combate
		boolean cargaRobot = false; // se utiliza para el ataque cargado del robot
		int desicionRobot; // se utiliza para el turno de robot en la pelea
		int j, bloquear; // variables de apoyo para ciclos
		boolean huir = true;

		System.out.println("Bienvenidos, Breve introduccion y tutorial aqui!!");
		System.out.println("\nPresiona cualquier tecla para comenzar");
		in.nextLine();

		// Arrays necesarios
		ArrayList<Herramientas> objetosh1 = new ArrayList();
		ArrayList<Herramientas> objetosh2 = new ArrayList();
		ArrayList<Herramientas> objetosh3 = new ArrayList();
		ArrayList<Herramientas> objetosh4 = new ArrayList();
		ArrayList<Herramientas> objetosh5 = new ArrayList();
		ArrayList<Herramientas> objetosh6 = new ArrayList();
		ArrayList<Herramientas> objetosh7 = new ArrayList();
		ArrayList<Herramientas> objetosh8 = new ArrayList();
		ArrayList<Herramientas> objetosh9 = new ArrayList();

		// instancias de intruso y robot
		Intruso intruso = new Intruso();
		Robot robot = new Robot();

		// instancias de Herramientas
		Objetos clave = new Objetos(false, "Clave para desbloquear alguna habitacion", false, 0, 0);
		objetosh2.add(clave); // Revisar

		Objetos mascaraIronMan = new Objetos(true, "El objetivo final", false, 0, 0); // Si algo cuadrar esto
		objetosh4.add(mascaraIronMan);

		Objetos diamante = new Objetos(true, "Un diamante", false, 0, 0);
		objetosh3.add(diamante);

		Objetos llaveInglesa = new Objetos(false, "Llave inglesa", false, 0, 0); // Si algo cuadrar esto
		objetosh1.add(llaveInglesa);

		Objetos escudoCapitanAmerica = new Objetos(true, "Escudo del Capitán America", false, 2, 1); // Le puse que si
																										// tiene alarma
		escudoCapitanAmerica.setDescripion(
				"Escudo de vibranium con los colores de la bandera, te sientes inspirado solo al llevarlo contigo."
						+ "\nSi lo usas serás más difícil de golpear por ese turno.");
		objetosh2.add(escudoCapitanAmerica);

		Armas martilloThor = new Armas(true, "Martillo de Thor", 10, 0);
		martilloThor.setDescripion(
				"Martillo mágico con el que puedes atacar, sientes como fluye energía eléctrica por tu cuerpo."
						+ "\nSi lo usas puedes aturdir a tu adversario con un rayo.");
		objetosh4.add(martilloThor);

		Objetos lanzaTelaranas = new Objetos(true, "Lanza Telarañas", true, 2, 0);
		lanzaTelaranas.setDescripion("Dispositivo lanza telarañas, probablemente pertenece a Spiderman."
				+ "\nSi lo usas lanzas una telaraña... Obviamente.");
		objetosh1.add(lanzaTelaranas);

		Objetos inyeccion = new Objetos(false, "Inyección de adrenalina", false, 0, 50);
		inyeccion.setDescripion("Inyectadora con líquido verde, lleva marcada las siglas S.H.I.E.L.D."
				+ "\nSi lo usas recuperarás tu salud.");
		objetosh4.add(inyeccion);

		System.out.println("Ahora iniciaras en la habitaci�n 1 ");

		// Instancias de habitacion
		// Instancias de habitacion

		Habitacion Numero1 = new Habitacion(1, false, objetosh1, intruso, null);
		Habitacion Numero2 = new Habitacion(2, false, objetosh2, null, null);
		Habitacion Numero3 = new Habitacion(3, false, objetosh3, null, null);
		Habitacion Numero4 = new Habitacion(4, true, objetosh4, null, null);
		Habitacion Numero5 = new Habitacion(5, true, objetosh5, null, null);
		Habitacion Numero6 = new Habitacion(6, true, objetosh6, null, null);
		Habitacion Numero7 = new Habitacion(7, true, objetosh7, null, null);
		Habitacion Numero8 = new Habitacion(8, true, objetosh8, null, null);
		Habitacion Numero9 = new Habitacion(9, true, objetosh9, null, robot);

		Habitacion[] casa = new Habitacion[] { Numero1, Numero2, Numero3, Numero4, Numero5, Numero6, Numero7, Numero8,
				Numero9 };

		Numero1.setHabitacionesContiguas(Numero4, null, Numero2, null);
		Numero2.setHabitacionesContiguas(Numero5, null, Numero3, Numero1);
		Numero3.setHabitacionesContiguas(Numero6, null, null, Numero2);
		Numero4.setHabitacionesContiguas(Numero7, Numero1, Numero5, null);
		Numero5.setHabitacionesContiguas(Numero8, Numero2, Numero6, Numero4);
		Numero6.setHabitacionesContiguas(Numero9, Numero3, null, Numero5);
		Numero7.setHabitacionesContiguas(null, Numero4, Numero8, null);
		Numero8.setHabitacionesContiguas(null, Numero5, Numero9, Numero7);
		Numero9.setHabitacionesContiguas(null, Numero6, null, Numero8);

		// Inicio de habitaciones de intruso y robot, el intruso inicia en la habitaci�n
		// 0 y el robot en Habitacion 8

		intruso.setUbicacion(Numero1);
                intruso.getUbicacion().setLuces(Ahorro.ENCENDIDO);
                intruso.addHistorial();
		robot.setUbicacion(Numero9);
                robot.addHistorial();

		// Ir pasando recogiendo cosas

		// Hacer un input de ir a la siguiente habitacion
		// Hacer un input de recoger cosas
		// Hacer un input de usar cosas

		// ciclo de turnos del jugador
		while (x) {// COLOCAR CONDICION (hasta que gane o quede sin vida)

			System.out.println("Descripcion de la escena que ve");

			if (robot.getUbicacion() == intruso.getUbicacion()) {// si la ubicacion del jugador == ubicacion robot
				System.out.println("El robot te ha encontrado! preparate para luchar!!");
				while (intruso.getHealth() > 0 && robot.getHealth() > 0 && huir) {// COLOCAR COONDICION (hasta que la
																					// vida de alguno < 0, o el jugador
																					// logre escapar)
					bloquear = 0;
					if (robot.getSpeed() + Main.lanzarDados(5) > intruso.getSpeed() + Main.lanzarDados(5)) {// define el
																											// orden de
																											// turnos
						iniciativa[0] = robot;
						iniciativa[1] = intruso;
					} else {
						iniciativa[1] = robot;
						iniciativa[0] = intruso;
					}
					for (int i = 0; i < 2; i++) {
						if (iniciativa[i].equals(intruso)) {// acciones del jugador
							System.out.println("Es tu turno:");
							if (intruso.isStunned()) {
								System.out.println("Estas aturdido, no puedes moverte");
								intruso.stun(false);
								opcion = -1;
							} else {
								System.out.println("1. Atacar" + "\n2. Bloquear" + "\n3. Usar" + "\n4. Huir");
								opcion = in.nextInt();
							}
							switch (opcion) {
							case 1:
								System.out.println("¿Con que desea atacar?");
								System.out.println("1. A puñetazos");
								j = 2;
								for (Armas arma : intruso.getWeaponInventory()) {// muestra en pantalla las armas que
																					// tiene en inventario
									System.out.println(j + ". " + arma.getName());
									j++;
								}
								opcion = in.nextInt();
								if (opcion == 1 && Main.lanzarDados(5) >= robot.getArmor()) {
									intruso.atacar(robot);// ataca a punetazos
									System.out.println(
											"Le diste un puño al robot, probablemente te dolió mas a ti que a él.");
									System.out.println("Te sobas la mano.");
								} else if (opcion != 1 && Main.lanzarDados(5) >= robot.getArmor()) {// se a�ade el diferente de 1
									intruso.atacar(robot,
											intruso.getWeaponInventory().get(opcion - 2).getBonusDamage());// ataca + el
																											// bonus del
																											// arma
									System.out.println("Atacaste al robot exitosamente");
								} else {
									System.out.println("El Robot bloqueo tu ataque!");// hay una probabilidad de que el
																						// robot bloquee
								}
								break;
							case 2:
								System.out.println("Tomas una posición defensiva y te preparas para recibir el ataque");
								bloquear = 2;
								break;
							case 3:
								j = 1;
								System.out.println("¿Qué deseas utilizar?:");
								for (Objetos objeto : intruso.getObjectInventory()) {// muestra en pantalla los objetos
																						// que tiene en inventario
									System.out.println(j + ". " + objeto.getName());
									j++;
								}
								opcion = in.nextInt();
								if (intruso.getObjectInventory().get(opcion).isShocker()) {
									intruso.getObjectInventory().get(opcion).usar(robot);
								} else {
									intruso.getObjectInventory().get(opcion).usar(intruso);
								}
								break;
							case 4:
								if (intruso.getSpeed() + Main.lanzarDados(5) >= 4) {
									huir = false;
									System.out.print("Tu agilidad te permitió saltar fuera del combate");
								} else {
									System.out.println(
											"Intentas huir, pero el robot te cierra el paso, mas suerte la proxima vez");
								}

								break;
							default:
								break;
							}
						} else {// acciones del robot
							System.out.println("Es el turno del robot:");
							if (robot.isCargaRobot()) {// ataque cargado
								desicionRobot = 100;// esta linea evita que haga otra cosa en el turno
								System.out.println(robot.ataqueCargado(intruso, bloquear));
							} else {
								desicionRobot = Main.lanzarDados(10);
							}
							// otras acciones
							robot.turno(desicionRobot, intruso, bloquear);
							bloquear = 0;
						}
					}
				}
			}
                        
			System.out.println("¿Que deseas hacer?:" + "\n1. Moverte" + "\n2. Interactuar" + "\n3. Hablar con Jarvis");
			opcion = in.nextInt();
			switch (opcion) {// aqui se implementan las diferentes funcionalidades
			case 1:
                                 //Movimiento del intruso
				 System.out.println(intruso.habitacionesDisponibles());
				 System.out.println("Donde quieres moverte?");
				 int opcionHab=in.nextInt();
				 intruso.mover(casa[opcionHab-1]);
                                 
                                 //Movimiento del robot
                                 robot.escuchar(casa);
                                 robot.escanear();
                                 if(robot.isNextTo()){
                                     //no se mueve
                                 }else if (robot.isAware()){
                                     //algoritmo de busqueda aqui
                                 } else {
                                     robot.mover(casa[robot.decidirDireccion()-1]);//movimiento aleatorio
                                 }
				break;
			case 2:
				System.out.println("Puedes interactuar con tus objetos actuales");
				break;
			case 3:
				System.out.println("Tus habilidades en Hacking te permiten tomar control de la IA Jarvis..."
						+ "\nJ.A.R.V.I.S.: ¿En qué te puedo asistir?"
						+ "\n1. Dame informacion acerca de las habitaciones."
						+ "\n2. Dame informacion acerca del robot."
						+ "\n3. Apaga las luces para que el robot no me encuentre."
						+ "\n4. No sé que hacer, dame una pista.");
				opcion = in.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("De qué habitación necesitas saber?");
					opcion = in.nextInt();
					System.out.println(casa[opcion - 1].ayudaJarvis());
					break;
				case 2:
					System.out.println(robot.ayudaJarvis());
				case 3:
					// apaga las luces de la habitacion actual
				case 4:
					// pista dependiendo del avance o al azar
				}	
				break;
			default:
				break;
			}
		}

		// mensajes finales
		if (x) {
			System.out.println("mensaje de Ganaste y descripcion del final");
		} else {
			System.out.println("mensaje de perdiste");
		}

	}

}
