package uiMain;

import baseDatos.*;

import gestorAplicacion.clasesLogicas.*;
import gestorAplicacion.clasesLogicasHerencia.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int lanzarDados(int caras) {// retorna un numero aleatorio del 1 a caras
		return (int) Math.floor(Math.random() * (caras) + 1);
	}
	
	private static void salirDelsistema() {
		System.out.println("Vuelva pronto");
		Serializador.serializarDatos();
		System.exit(0);
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int opcion; // aqui se guardan las opciones que va seleccionando el jugador
		boolean x = true; // mientras el robot este vivo
		Individuo iniciativa[] = new Individuo[2]; // organiza los turnos de combate
		int desicionRobot; // se utiliza para el turno de robot en la pelea

		System.out.println(
				"Bienvenidos, Te encuentras en la casa de Tony Stark y tu misión es conseguir la mascara de Ironman. Pero no creas que será tan sencillo, en tu recorrido tendrás diferentes obstáculos como objetos que te activarán alarmas, puertas con su acceso bloqueado y  un robot que te buscará cuando actives una alarma.\r\n"
						+ "Pero no todo es malo, encontrarás objetos útiles en algunas habitaciones y quizá tengas la ayuda de alguien o algo.\r\n"
						+ "");
		System.out.println(
				"Tutorial: debes tomar decisiones sobre tus acciones, pasar entre habitaciones, recoger objetos y utilizarlos.\r\n"
						+ "Si necesitas saber más cosas ya sabrás a quién preguntarle… Disfruta el juego.\r\n"
						+ "");
		System.out.println("\nPresiona Enter para comenzar");
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
                Robot bot = new Bot();

		// instancias de Herramientas

		Objetos Llaveh5 = new Objetos("Llave azul.");
		Llaveh5.setDescripion("Clave para desbloquear habitacion 5.");
		objetosh6.add(Llaveh5);

		Objetos Llaveh7 = new Objetos("Llave plateada.");
		Llaveh7.setDescripion("Clave para desbloquear habitacion 7.");
		objetosh3.add(Llaveh7);

		Objetos Llaveh9 = new Objetos("Llave dorada.");
		Llaveh9.setDescripion("Clave para desbloquear habitacion 9.");

		objetosh8.add(Llaveh9);

		Objetos mascaraIronMan = new Objetos("La mascara de Ironman");
		mascaraIronMan.setDescripion("El objetivo final.");
		objetosh9.add(mascaraIronMan);

		Objetos emulsionDeScott = new Objetos("Emulsion de Scott", false, 0, 30);
		emulsionDeScott.setDescripion("Sano y fuerte crecerás." + "\nTe puedes curar con este objeto");
		objetosh5.add(emulsionDeScott);

		Objetos vitaminaC = new Objetos("Proteinas", false, 0, 5);
		objetosh2.add(vitaminaC);

		Objetos escudoCapitanAmerica = new Objetos("Escudo del Capitán America", false, 5, 1); // tiene alarma

		escudoCapitanAmerica.setDescripion(
				"Escudo de vibranium con los colores de la bandera, te sientes inspirado solo al llevarlo contigo."
						+ "\nSi lo usas serás más difícil de golpear por ese turno.");
		objetosh2.add(escudoCapitanAmerica);

		Armas martilloThor = new Armas("Martillo de Thor", 10, 0);
		martilloThor.setDescripion(
				"Martillo mágico con el que puedes atacar, sientes como fluye energía eléctrica por tu cuerpo."
						+ "\nSi lo usas puedes aturdir a tu adversario con un rayo.");
		objetosh4.add(martilloThor);

		Objetos lanzaTelaranas = new Objetos("Lanza Telarañas", true, 0, 0);
		lanzaTelaranas.setDescripion("Dispositivo lanza telarañas, probablemente pertenece a Spiderman."
				+ "\nSi lo usas lanzas una telaraña... Obviamente.");
		objetosh1.add(lanzaTelaranas);

		Objetos inyeccion = new Objetos("Inyección de adrenalina", false, 0, 50);
		inyeccion.setDescripion("Inyectadora con líquido verde, lleva marcada las siglas S.H.I.E.L.D."
				+ "\nSi lo usas recuperarás tu salud.");
		objetosh4.add(inyeccion);


		// Jarvis

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

		//ArrayList<Habitacion> habitacionesJarvis = new ArrayList<>();

		Numero1.setHabitacionesContiguas(Numero4, null, Numero2, null);
		Numero2.setHabitacionesContiguas(Numero5, null, Numero3, Numero1);
		Numero3.setHabitacionesContiguas(Numero6, null, null, Numero2);
		Numero4.setHabitacionesContiguas(Numero7, Numero1, Numero5, null);
		Numero5.setHabitacionesContiguas(Numero8, Numero2, Numero6, Numero4);
		Numero6.setHabitacionesContiguas(Numero9, Numero3, null, Numero5);
		Numero7.setHabitacionesContiguas(null, Numero4, Numero8, null);
		Numero8.setHabitacionesContiguas(null, Numero5, Numero9, Numero7);
		Numero9.setHabitacionesContiguas(null, Numero6, null, Numero8);

		// Inicio de habitaciones de intruso y robot, el intruso inicia en la habitacion
		// 1 y el robot en Habitacion 9

		intruso.setUbicacion(Numero1);
		intruso.getUbicacion().setLuces(Ahorro.ENCENDIDO);
		intruso.addHistorial();
		robot.setUbicacion(Numero9);
		robot.addHistorial();

		// ciclo de turnos del jugador
		Deserializador.deserializarDatos();
		while (!intruso.getObjectInventory().contains(mascaraIronMan) && intruso.getHealth() > 0) {// hasta que gane o
																									// quede sin vida
			boolean huir = true;

			System.out.println(intruso.ayudaJarvis());

			if (robot.getUbicacion() == intruso.getUbicacion() && robot.getHealth() > 0) {// si la ubicacion del jugador
																							// == ubicacion robot
				System.out.println("El robot te ha encontrado! preparate para luchar!!");

				while (intruso.getHealth() > 0 && robot.getHealth() > 0 && huir) {

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
								System.out.println("¿Con que deseas atacar?" + "\n0. A puñetazos.");
								System.out.println(intruso.mostrarArmas());
								opcion = in.nextInt();
								int dados = Main.lanzarDados(5);
								if (opcion == 0 && dados >= robot.getArmor()) {
									intruso.atacar(robot);
									System.out.println(
											"Le diste un puño al robot, probablemente te dolió mas a ti que a él.");
									System.out.println("Te sobas la mano.");
								} else if (opcion != 0 && dados >= robot.getArmor()) {
									intruso.atacar(robot,
											intruso.getWeaponInventory().get(opcion - 1).getBonusDamage()); // arma
									System.out.println("Atacaste al robot exitosamente");
								} else {
									System.out.println("El Robot bloqueo tu ataque!");
								}
								break;
							case 2:
								System.out
										.println("Tomas una posición defensiva y te preparas para recibir el ataque");
								intruso.setArmor(3);

								break;
							case 3:
								System.out.println(intruso.mostrarObjetos());
								opcion = in.nextInt();
								if (intruso.getObjectInventory().get(opcion - 1).isShocker()) {
									intruso.getObjectInventory().get(opcion - 1).usar(robot);
									System.out.println("Aturdiste al robot.");
								} else {
									intruso.getObjectInventory().get(opcion - 1).usar(intruso);
									System.out.println("Recibiste la bonificacion de este objeto.");
								}
								break;
							case 4:
								if (intruso.getSpeed() + Main.lanzarDados(5) >= 4) {
									huir = false;
									System.out.print("Tu agilidad te permitió saltar fuera del combate.");
								} else {
									System.out.println(
											"Intentas huir, pero el robot te cierra el paso, mas suerte la proxima vez.");
								}
								break;
							default:
								break;
							}
						} else {
							System.out.println("Es el turno del robot:");
							if (robot.isStunned()) {
								System.out.println("El robot esta aturdido, no puede hacer nada.");
                                                                robot.stun(false);
							} else {
								if (robot.isCargaRobot()) {
									desicionRobot = 100;
									System.out.println(robot.ataqueCargado(intruso));
								} else {
									desicionRobot = Main.lanzarDados(10);
								}
								System.out.println(robot.turno(desicionRobot, intruso));
                                                                System.out.println(bot.turno(desicionRobot, intruso));
                                                                bot.atacar(intruso);
                                                                System.out.println("El bot revolotea te estorba en la batalla");
							}
							intruso.setArmor(0);
						}

					}
				}
			}
			if (robot.getHealth() <= 0 && x) {
				System.out.println("Destruiste al robot, ahora solo falta obtener la mascara.");
				x = false;
			}

			if (intruso.getHealth() > 0) {
				System.out.println("¿Que deseas hacer?:" + "\n1. Moverte" + "\n2. Interactuar"
						+ "\n3. Hablar con Jarvis" + "\n4. Salir del juego");
				opcion = in.nextInt();
				switch (opcion) {// aqui se implementan las diferentes funcionalidades
				case 1:
					// Movimiento del intruso
					System.out.println(intruso.habitacionesDisponibles());
					System.out.println("Donde quieres moverte?");
					int opcionHab = in.nextInt();
					intruso.mover(casa[opcionHab - 1]);

					// Movimiento del robot
                                        if(robot.getHealth() > 0){
                                            robot.apagarAlarma();
					robot.escuchar(casa);
					robot.escanear();
					if (robot.isNextTo()) {
						robot.mover(robot.getGoingTo());

					} else if (robot.isAware()) {
                                                System.out.println(robot.buscar(casa).getNumero());
						robot.mover(robot.buscar(casa));// camino mas corto a la habitacion con alarma
					} else {
						robot.mover(casa[robot.decidirDireccion() - 1]);// movimiento aleatorio
					} 
                                        }
					
					break;
				case 2:
					System.out.println("¿Que deseas hacer?" + "\n1. Desbloquear una puerta."
							+ "\n2. Recojer los objetos." + "\n3. Curar tu salud." + "\n4. Romper las luces.");
					int opcionIntec = in.nextInt();
					switch (opcionIntec) {
					case 1:
						String m = intruso.habitacionesaDesbloquear();
						System.out.println(m);
						if (!"no hay habitaciones bloqueadas alrededor".equals(m)) {
							System.out.println("Que habitacion quieres desbloquear");
							opcion = in.nextInt();
							switch (opcion) {
							case 5:
								if (intruso.getObjectInventory().contains(Llaveh5)) {
									Numero5.setBloqueada(false);
								} else {
									System.out.println("no tienes la llave de esta habitacion");
								}
								break;
							case 7:
								if (intruso.getObjectInventory().contains(Llaveh7)) {
									Numero7.setBloqueada(false);
								} else {
									System.out.println("no tienes la llave de esta habitacion");
								}
								break;
							case 9:
								if (intruso.getObjectInventory().contains(Llaveh9)) {
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
						if (intruso.getObjectInventory().get(opcion).getBonusHealth() == 0) {
							System.out.println("No puedes usar este objeto para curarte");
						} else {
							intruso.getObjectInventory().get(opcion).usar(intruso);
							System.out
									.println("Te has curado, ahora tienes " + intruso.getHealth() + "puntos de vida.");
						}
						break;
					case 4:
						if (intruso.getWeaponInventory().isEmpty()) {
							System.out.println(
									"Intentas romper las luces con tus manos, lamentablemente no tienes la fuerza suficiente para hacerlo");
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
							+ "\n4. No sé que hacer, dame una pista." + "\n5. Ver historial de movimientos.");
					opcion = in.nextInt();
					switch (opcion) {
					case 1:
						System.out.println("De qué habitación necesitas saber?");
						opcion = in.nextInt();
						System.out.println(casa[opcion - 1].ayudaJarvis());
						break;
					case 2:
						System.out.println(robot.ayudaJarvis());
						break;
					case 3:
						if (!intruso.getUbicacion().getLuces().equals(Ahorro.ROTO)) {
							intruso.getUbicacion().setLuces(Ahorro.APAGADO);
						}
						System.out.println("J.A.R.V.I.S.: Luces apagadas.");
						break;
					case 4:
						opcion = Main.lanzarDados(10);
						if (opcion < 4) {
							System.out.println(Jarvis.PISTA1);
						} else if (opcion < 6) {
							System.out.println(Jarvis.PISTA2);
						} else if (opcion < 8) {
							System.out.println(Jarvis.PISTA3);
						} else if (opcion < 10) {
							System.out.println(Jarvis.PISTA4);
						} else {
							System.out.println(Jarvis.PISTA5);
						}
						break;
					case 5:
						for (String linea : Individuo.getHistorial()) {
							System.out.println(linea);
						}
						break;
					default:
						break;
					}
                                        break;

				case 4:
					salirDelsistema();
					break;
                                        
                                //codigos para pruebas
                                case 100: //fuerza batalla con robot
                                    robot.setUbicacion(intruso.getUbicacion());
                                    System.out.println("CHEAT: TRAJISTE AL ROBOT A ESTA HABITACION.");
                                    break;
                                case 200://anadir todo a inventario
                                    intruso.setWeaponInventory(Armas.getArmas());
                                    intruso.setObjectInventory(Objetos.getObjetos());
                                    intruso.getObjectInventory().remove(mascaraIronMan);
                                    System.out.println("CHEAT: TU INVENTARIO CONTIENE TODOS LOS OBJETOS.");
                                    break;
                                case 300: //el robot se autodestruye
                                    robot.setHealth(0);
                                    System.out.println("CHEAT: EL ROBOT SE AUTODESTRUYE.");
                                    break;
                                case 400: //perder
                                    intruso.setHealth(0);
                                    System.out.println("CHEAT: FORZASTE DERROTA.");
                                    break;
                                case 500://ganar
                                    intruso.getObjectInventory().add(mascaraIronMan);
                                    System.out.println("CHEAT: FORZASTE VICTORIA.");
                                case 600://activas alarma
                                    intruso.getUbicacion().setAlarma(Ahorro.ENCENDIDO);
				}
			}
		}
		// mensajes finales
		if (intruso.getObjectInventory().contains(mascaraIronMan)) {
			System.out.println(
					"Despues de un arduo trabajo conseguiste lo que buscabas, la mascara de Ironman te permitio abrir un hueco en la pared y huir."
							+ "\nPor fin podras añadir esto a tu mesa de trofeos, tu proximo objetivo: La Capa de Dr Strange... pero eso sera en otra ocasion."
							+ "\nBuen trabajo y Gracias por Jugar!!!");
                        Main.salirDelsistema();
		} else {
			System.out.println(
					"Todo se volvio negro, y cuando abriste los ojos te encontraste en una celda de maxima seguridad."
							+ "\nParece que estaras aqui por un buen tiempo." + "\nFin del Juego.");
                        Main.salirDelsistema();
		}
                

	}

}
