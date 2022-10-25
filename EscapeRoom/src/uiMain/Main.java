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
		int desicionRobot; // se utiliza para el turno de robot en la pelea
		int j, bloquear; // variables de apoyo para ciclos
		//boolean huir = true;

		System.out.println("Bienvenidos, Breve introduccion y tutorial aqui!!");
		System.out.println("\nPresiona cualquier tecla para comenzar");
		in.nextLine();

		// Arrays necesarios
		ArrayList<Herramientas> objetosh1 = new ArrayList<>();
		ArrayList<Herramientas> objetosh2 = new ArrayList<>();
		ArrayList<Herramientas> objetosh3 = new ArrayList<>();
		ArrayList<Herramientas> objetosh4 = new ArrayList<>();
		ArrayList<Herramientas> objetosh5 = new ArrayList<>();
		ArrayList<Herramientas> objetosh6 = new ArrayList<>();
		ArrayList<Herramientas> objetosh7 = new ArrayList<>();
		ArrayList<Herramientas> objetosh8 = new ArrayList<>();
		ArrayList<Herramientas> objetosh9 = new ArrayList<>();

		// instancias de intruso y robot
		Intruso intruso = new Intruso();
		Robot robot = new Robot();

		// instancias de Herramientas
		Objetos Llaveh5 = new Objetos("Clave para desbloquear habitacion 5", false, 0, 0, 5);
		objetosh6.add(Llaveh5); // Revisar
		
		Objetos Llaveh7 = new Objetos("Clave para desbloquear habitacion 7", false, 0, 0, 7);
		objetosh3.add(Llaveh7);
		
		Objetos Llaveh9 = new Objetos("Clave para desbloquear habitacion 9", false, 0, 0, 9);
		objetosh8.add(Llaveh9);

		Objetos mascaraIronMan = new Objetos("El objetivo final", false, 0, 0, 0); // Si algo cuadrar esto
		objetosh9.add(mascaraIronMan);

		Objetos emulsionDeScott = new Objetos("Sano y fuerte creceras", false, 0, 30, 0);
		objetosh5.add(emulsionDeScott);

		Objetos vitaminaC = new Objetos("Proteinas", false, 0, 10, 0); // Si algo cuadrar esto
		objetosh2.add(vitaminaC);

		Objetos escudoCapitanAmerica = new Objetos("Escudo del Capitán America", false, 2, 1, 0); // Le puse que si
																										// tiene alarma
		escudoCapitanAmerica.setDescripion(
				"Escudo de vibranium con los colores de la bandera, te sientes inspirado solo al llevarlo contigo."
						+ "\nSi lo usas serás más difícil de golpear por ese turno.");
		objetosh2.add(escudoCapitanAmerica);

		Armas martilloThor = new Armas("Martillo de Thor", 10, 0);
		martilloThor.setDescripion(
				"Martillo mágico con el que puedes atacar, sientes como fluye energía eléctrica por tu cuerpo."
						+ "\nSi lo usas puedes aturdir a tu adversario con un rayo.");
		objetosh4.add(martilloThor);

		Objetos lanzaTelaranas = new Objetos("Lanza Telarañas", true, 2, 0, 0);
		lanzaTelaranas.setDescripion("Dispositivo lanza telarañas, probablemente pertenece a Spiderman."
				+ "\nSi lo usas lanzas una telaraña... Obviamente.");
		objetosh1.add(lanzaTelaranas);

		Objetos inyeccion = new Objetos("Inyección de adrenalina", false, 0, 50, 0);
		inyeccion.setDescripion("Inyectadora con líquido verde, lleva marcada las siglas S.H.I.E.L.D."
				+ "\nSi lo usas recuperarás tu salud.");
		objetosh4.add(inyeccion);

		System.out.println("Ahora iniciaras en la habitaci�n 1 ");

		
		//Jarvis
			
	
		Habitacion Numero1 = new Habitacion(1, false, objetosh1, intruso, null);
		Habitacion Numero2 = new Habitacion(2, false, objetosh2, null, null);
		Habitacion Numero3 = new Habitacion(3, false, objetosh3, null, null);
		Habitacion Numero4 = new Habitacion(4, false, objetosh4, null, null);
		Habitacion Numero5 = new Habitacion(5, true, objetosh5, null, null);
		Habitacion Numero6 = new Habitacion(6, false, objetosh6, null, null);
		Habitacion Numero7 = new Habitacion(7, true, objetosh7, null, null);
		Habitacion Numero8 = new Habitacion(8, false, objetosh8, null, null);
		Habitacion Numero9 = new Habitacion(9, true, objetosh9, null, robot);
                
                Numero3.setAlarma(Ahorro.ACTIVADO);
                Numero6.setAlarma(Ahorro.ACTIVADO);
                Numero8.setAlarma(Ahorro.ACTIVADO);

		Habitacion[] casa = new Habitacion[] { Numero1, Numero2, Numero3, Numero4, Numero5, Numero6, Numero7, Numero8,
				Numero9 };

		ArrayList<Habitacion> habitacionesJarvis = new ArrayList<>();
		
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

		// Hacer un input de recoger cosas
		// Hacer un input de usar cosas

		// ciclo de turnos del jugador
		while (!intruso.getObjectInventory().contains(mascaraIronMan) && intruso.getHealth() > 0) {//hasta que gane o quede sin vida
			boolean huir = true;

			System.out.println("Descripcion de la escena que ve");

			if (robot.getUbicacion() == intruso.getUbicacion()) {// si la ubicacion del jugador == ubicacion robot
				System.out.println("El robot te ha encontrado! preparate para luchar!!");
				while (intruso.getHealth() > 0 && robot.getHealth() > 0 && huir) {//hasta que la
																					// vida de alguno < 0, o el jugador
																					// logre escapar)
					bloquear = 0;
                                        System.out.println("Tienes " + intruso.getHealth() + " puntos de vida.");
                                        System.out.println("El robot tiene " + robot.getHealth() + " puntos de vida.");
                                        
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
								intruso.mostrarArmas();
								opcion = in.nextInt();
                                int dados = Main.lanzarDados(5);
								if (opcion == 1 && dados >= robot.getArmor()) {
									intruso.atacar(robot);// ataca a punetazos
									System.out.println("Le diste un puño al robot, probablemente te dolió mas a ti que a él.");
									System.out.println("Te sobas la mano.");
								} else if (opcion != 1 && dados >= robot.getArmor()) {// se a�ade opcion diferente de 1
									intruso.atacar(robot,intruso.getWeaponInventory().get(opcion - 2).getBonusDamage());// ataca + el
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
								intruso.mostrarObjetos();
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
							System.out.println(robot.turno(desicionRobot, intruso, bloquear));
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
                                 robot.apagarAlarma();
                                 robot.escuchar(casa);
                                 robot.escanear();
                                 if(robot.isNextTo()){
                                     robot.mover(robot.getGoingTo());
                                     
                                 }else if (robot.isAware()){
                                	 robot.mover(robot.buscar(casa));//camino mas corto a la habitacion con alarma
                                 } else {
                                     robot.mover(casa[robot.decidirDireccion()-1]);//movimiento aleatorio
                                 }
				break;
			case 2:
                            System.out.println("¿Que deseas hacer?"
                                    + "\n1. Desbloquear una puerta."
                                    + "\n2. Recojer los objetos."
                                    + "\n3. Curar tu salud."
                                    + "\n4. Romper las luces.");
				int opcionIntec=in.nextInt();
				switch(opcionIntec) {
				case 1:
                                        String m = intruso.habitacionesaDesbloquear();
					System.out.println(m);
                                        if (!"no hay habitaciones bloqueadas alrededor".equals(m)){
                                            System.out.println("Que habitacion quieres desbloquear");
					    opcion = in.nextInt();
                                            switch(opcion){
                                                case 5 :
                                                    if(intruso.getObjectInventory().contains(Llaveh5)){
                                                        Numero5.setBloqueada(false);
                                                    } else {
                                                        System.out.println("no tienes la llave de esta habitacion");
                                                    }
                                                    break;
                                                case 7:
                                                    if(intruso.getObjectInventory().contains(Llaveh7)){
                                                        Numero7.setBloqueada(false);
                                                    } else {
                                                        System.out.println("no tienes la llave de esta habitacion");
                                                    }
                                                    break;
                                                case 9:
                                                    if(intruso.getObjectInventory().contains(Llaveh9)){
                                                        Numero9.setBloqueada(false);
                                                    } else {
                                                        System.out.println("no tienes la llave de esta habitacion");
                                                    }
                                                    break;
                                            }
                                        }
					break;
				case 2:
                                        System.out.println(intruso.agarrar());
					break;
                                case 3:
                                    System.out.println(intruso.mostrarObjetos() + "\n¿Cual deseas usar?");
                                    opcion = in.nextInt();
                                    if (intruso.getObjectInventory().get(opcion).getBonusHealth() == 0){
                                        System.out.println("No puedes usar este objeto para curarte");
                                    } else {
                                       intruso.getObjectInventory().get(opcion).usar(intruso);
                                       System.out.println("Te has curado, ahora tienes " + intruso.getHealth() + "puntos de vida.");
                                    }
                                    break;
                                case 4:
                                    if(intruso.getWeaponInventory().isEmpty()){
                                        System.out.println("Intentas romper las luces con tus manos, lamentablemente no tienes la fuerza suficiente para hacerlo");
                                    } else {
                                        intruso.getUbicacion().setLuces(Ahorro.ROTO);
                                        System.out.println("Las luces de esta habitacion no se volveran a encender.");
                                    }
				}
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
