package uiMain;
import gestorAplicacion.clasesLogicas.*;
import gestorAplicacion.clasesLogicasHerencia.*;

import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.*;
public class Main {

	public static int lanzarDados(int caras) {// retorna un numero aleatorio del 1 a caras
		return (int) Math.floor(Math.random() * (caras) + 1);
	}

	public static void main(String[] args) { //Inicio de metodo main
		Scanner in = new Scanner(System.in);
		int opcion; // aqui se guardan las opciones que va seleccionando el jugador
		boolean x = true; // variable temporal, mientras colocamos bien las condiciones
		Individuo iniciativa[] = new Individuo[2]; // organiza los turnos de combate
		boolean cargaRobot = false; // se utiliza para el ataque cargado del robot
		int desicionRobot; // se utiliza para el turno de robot en la pelea

		System.out.println("Bienvenidos, Breve introduccion y tutorial aqui!!");
		System.out.println("\nPresiona cualquier tecla para comenzar");
		in.nextLine();

		//Arrays necesarios
		ArrayList<Herramientas> objetosh1 = new ArrayList<Herramientas>();
		ArrayList<Herramientas> objetosh2 = new ArrayList<Herramientas>();
		ArrayList<Herramientas> objetosh3 = new ArrayList<Herramientas>();
		ArrayList<Herramientas> objetosh4 = new ArrayList<Herramientas>();
		//Objetos del robot (Ninguno)
		ArrayList<Herramientas> objetosh0 = new ArrayList<Herramientas>();
		
		
		// instancias de intruso y robot
		Intruso intruso = new Intruso();
		Robot robot = new Robot();

		// instancias de Herramientas
		Herramientas clave = new Herramientas(false,"Clave para desbloquear alguna habitacion",false,false,true,0,0,0,0);
		objetosh2.add(clave); // Revisar
		
		Herramientas mascaraIronMan = new Herramientas(true,"El objetivo final",false,false,false,0,0,0,0); //Si algo cuadrar esto
		objetosh4.add(mascaraIronMan);
		
		Herramientas diamante = new Herramientas(true,"Un diamante",false,false,true,0,0,0,0);
		objetosh3.add(diamante);

		Herramientas llaveInglesa = new Herramientas(false,"Llave inglesa",false,false,true,0,0,0,0); //Si algo cuadrar esto
		objetosh1.add(llaveInglesa);

		Herramientas escudoCapitanAmerica = new Herramientas(true,"Escudo del Capitan America", false, false, true, 0, 2, 1,
				0); //Le puse que si tiene alarma
		escudoCapitanAmerica.setDescripion(
				"Escudo de vibranium con los colores de la bandera americana, te sientes inspirado solo al llevarlo contigo."
						+ "\nSi lo usas seras mas dificil de golpear por ese turno.");
		objetosh2.add(escudoCapitanAmerica);
		
		Herramientas martilloThor = new Herramientas(true,"Martillo de Thor", true, true, true, 10, 0, 0, 0);
		martilloThor.setDescripion(
				"Martillo magico con el que puedes atacar, sientes como fluye energia electrica por tu cuerpo."
						+ "\nSi lo usas puedes aturdir a tu adversario con un rayo.");
		objetosh4.add(martilloThor);
		
		Herramientas lanzaTelaranas = new Herramientas(true,"Lanza Telaranas", false, true, true, 0, 0, 2, 0);
		lanzaTelaranas.setDescripion("Dispositivo lanza telaranas, probablemente pertenece a Spiderman."
				+ "\nSi lo usas lanzas una telarana... Obviamente.");
		objetosh1.add(lanzaTelaranas);
		
		Herramientas inyeccion = new Herramientas(false,"Inyeccion de adrenalina", false, false, true, 0, 0, 0, 50);
		inyeccion.setDescripion("Inyectadora con liquido verde, lleva marcada las siglas S.H.I.E.L.D."
				+ "\nSi lo usas recuperaras tu salud.");
		objetosh4.add(inyeccion);
		
		System.out.println("Ahora iniciaras en la habitaci�n 1 ");

		
		//Instancias de habitacion
		Habitacion Numero1 = new Habitacion(1, false, objetosh1 , intruso, null);
		Habitacion Numero2 = new Habitacion(2, false, objetosh2 , null, null);
		Habitacion Numero3 = new Habitacion(3, false, objetosh3 , null, null);
		Habitacion Numero4 = new Habitacion(4, true, objetosh4 , null, null);
		//Instancias de habitacion de inicio del robot
		Habitacion Numero0 = new Habitacion(0, true, objetosh0 , robot, null);
		
		//Inicio de habitaciones de intruso y robot, el intruso inicia en la habitaci�n 1 y el robot en Habitacion 0
		
		System.out.println("En esta habitacion debes escoger los materiales necesarios para crear"+
		"\n una llave inglesa y un poderoso martillo, elige bien: "+"\n1. Acero asgardiano y Madera roble"+"\n2. Hierro asgardiano y Madera abedul"
				+"\n3. Uru asgardiano y Madera Groot");
		
		//creacion del asistente jarvis
		Jarvis jarvis = new Jarvis();
		
		int opcionmaterial=in.nextInt();
		int contadorintentos;
		
		if (opcionmaterial == 1 || opcionmaterial ==2 ) {
		//Orientacion de Jarvis 
		}
		else {
			// Felicitacion  de Jarvis
			
			intruso.agarrar();
			Numero1.setIntruso(null);
			Numero2.setIntruso(intruso);
			intruso.setHabitacion(Numero2);
			Numero1.setRobot(robot);
			opcionmaterial=0;
		}
		
		
		
		System.out.println("El Robot ha iniciado la marcha, elige sabiamente durante tu recorrido para no ser alcanzado");
		System.out.println("En esta habitacion debes escoger los materiales necesarios para crear"+
				"\n una llave inglesa y un poderoso martillo, elige bien: "+"\n1. Acero asgardiano y Madera roble"+
				"\n2. Hierro asgardiano y Madera abedul"+
				"\n3. Uru asgardiano y Madera Groot");
		
		int opcionmaterial2=in.nextInt();
		if (opcionmaterial == 1 || opcionmaterial ==2 ) {
		//Orientacion de Jarvis 
		}
		else {
		// Felicitacion  de Jarvis
			intruso.agarrar();
			Numero2.setIntruso(null);
			Numero3.setIntruso(intruso);
			intruso.setHabitacion(Numero3);
			Numero2.setRobot(robot);
			opcionmaterial=0;
		}

		
		
		
		
		// Ir pasando recogiendo cosas
		
		//Hacer un input de ir a la siguiente habitacion
		//Hacer un input de recoger cosas
		//Hacer un input de usar cosas
		
		
		
		// ciclo de turnos del jugador
		while (x) {// COLOCAR CONDICION (hasta que gane o quede sin vida)

			System.out.println("Descripcion de la escena que ve");

			if (x) {// COLOCAR CONDICION (si la ubicacion del jugador == ubicacion robot)
				System.out.println("El robot te ha encontrado! preparate para luchar!!");
				while (true) {// COLOCAR COONDICION (hasta que la vida de alguno < 0, o el jugador logre
								// escapar)
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
							System.out.println("1. Atacar" + "\n2. Bloquear" + "\n3. Usar" + "\n4. Huir");
							opcion = in.nextInt();
							switch (opcion) {
							case 1:
								System.out.println("¿Con que desea atacar?");
								System.out.println("1. A puñetazos");
								int j = 2;
								for (Herramientas inventory : intruso.getInventory()) {// muestra en pantalla las armas
																						// que tiene en inventario
									System.out.println(j + ". " + inventory.getName());
									j++;
								}
								opcion = in.nextInt();
								if (opcion == 1 && Main.lanzarDados(5) >= robot.getArmor()) {
									intruso.atacar(robot);// ataca a punetazos
									System.out.println(
											"Le diste un puño al robot, probablemente te dolió mas a ti que a él.");
									System.out.println("Te sobas la mano.");
								} else if (Main.lanzarDados(5) >= robot.getArmor()) {
									intruso.atacar(robot, intruso.getInventory().get(opcion - 2).getBonusDamage());// ataca
																													// +
																													// el
																													// bonus
																													// del
																													// arma
								} else {
									System.out.println("El Robot bloqueo tu ataque!");// hay una probabilidad de que el
																						// robot bloquee
								}
								break;
							case 2:// aumenta tu armadura por un turno
								break;
							case 3:// utiliza un objeto especial
								break;
							case 4:// intentas huir del combate
								break;
							default:
								break;
							}

						} else {// acciones del robot
							System.out.println("Es el turno del robot:");
							if (cargaRobot) {// ataque cargado
								desicionRobot = 100;// esta linea evita que haga otra cosa en el turno
								if (Main.lanzarDados(5) >= intruso.getArmor()) {
									robot.atacar(intruso);
									robot.atacar(intruso);
									robot.atacar(intruso);
									System.out.println("El robot lanza un poderoso laser hacia ti!!");
								} else {
									System.out.println(
											"El robot lanza un poderoso laser hacia ti! Por suerte, logras esquivarlo");
								}
								cargaRobot = false;
							} else {
								desicionRobot = Main.lanzarDados(10);
							}
							// ataque normal
							if (desicionRobot < 6) {// del 1 al 5 ataque normal
								if (Main.lanzarDados(5) >= intruso.getArmor()) {
									robot.atacar(intruso);
								} else {
									System.out.println("Bloqueaste el golpe del robot");
								}

							} else if (desicionRobot == 6 || desicionRobot == 7) {// 6 o 7 recarga de ataque cargado
								cargaRobot = true;
								System.out.println("El pecho del robot comienza a brillar con fuerza");
							} else if (desicionRobot == 8 || desicionRobot == 9) {// 8 o 9 stunear

							} else if (desicionRobot == 10) {// 10 roba un objeto
								// robar objeto
							}

						}
					}
				}
			}

			System.out.println("¿Que deseas hacer?:" + "\n1. Moverte" + "\n2. Interactuar" + "\n3. Hablar con Jarvis");
			opcion = in.nextInt();
			switch (opcion) {// aqui se implementan las diferentes funcionalidades
			case 1:
				break;
			case 2:
				break;
			case 3:
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

	}//Final de metodo main

}
