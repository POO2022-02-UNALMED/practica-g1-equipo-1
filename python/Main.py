import random
import math
import sys
from Ahorro import Ahorro
from Armas import Armas
from Habitacion import Habitacion
from Individuo import Individuo
from Jarvis import Jarvis
from Objetos import Objetos
from Bot import Bot

from Intruso import Intruso
from Robot import Robot

from excepciones import *


class Main:

    @staticmethod
    def lanzarDados(caras):
        return int(math.floor(random.random() * (caras) + 1))

    @staticmethod
    def salirDelsistema():
        print("Vuelva pronto")
        sys.exit(0)

    def __init__(self):
        opcion = None # aqui se guardan las opciones que va seleccionando el jugador
        x = True # mientras el robot este vivo
        iniciativa = [None for _ in range(2)] # organiza los turnos de combate
        desicionRobot = None # se utiliza para el turno de robot en la pelea

        print("Bienvenidos, Te encuentras en la casa de Tony Stark y tu misión es conseguir la mascara de Ironman. Pero no creas que será tan sencillo, en tu recorrido tendrás diferentes obstáculos como objetos que te activarán alarmas, puertas con su acceso bloqueado y  un robot que te buscará cuando actives una alarma.\r\n" + "Pero no todo es malo, encontrarás objetos útiles en algunas habitaciones y quizá tengas la ayuda de alguien o algo.\r\n" + "")
        print("Tutorial: debes tomar decisiones sobre tus acciones, pasar entre habitaciones, recoger objetos y utilizarlos.\r\n" + "Si necesitas saber más cosas ya sabrás a quién preguntarle… Disfruta el juego.\r\n" + "")
        print("\nPresiona Enter para comenzar")
        #input()

        # Arrays necesarios
        self.objetosh1 = []
        self.objetosh2 = []
        self.objetosh3 = []
        self.objetosh4 = []
        self.objetosh5 = []
        self.objetosh6 = []
        self.objetosh7 = []
        self.objetosh8 = []
        self.objetosh9 = []

        # instancias de intruso y robot
        self.intruso = Intruso()
        self.robot = Robot()
        self.bot = Bot()

        # instancias de Herramientas

        self.Llaveh5 = Objetos("Llave azul.")
        self.Llaveh5.setDescripion("Clave para desbloquear habitacion 5.")
        self.objetosh6.append(self.Llaveh5)

        self.Llaveh7 = Objetos("Llave plateada.")
        self.Llaveh7.setDescripion("Clave para desbloquear habitacion 7.")
        self.objetosh3.append(self.Llaveh7)

        self.Llaveh9 = Objetos("Llave dorada.")
        self.Llaveh9.setDescripion("Clave para desbloquear habitacion 9.")

        self.objetosh8.append(self.Llaveh9)

        self.mascaraIronMan = Objetos("La mascara de Ironman")
        self.mascaraIronMan.setDescripion("El objetivo final.")
        self.objetosh9.append(self.mascaraIronMan)

        self.emulsionDeScott = Objetos("Emulsion de Scott", False, 0, 30)
        self.emulsionDeScott.setDescripion("Sano y fuerte crecerás." + "\nTe puedes curar con este objeto")
        self.objetosh5.append(self.emulsionDeScott)

        self.vitaminaC = Objetos("Proteinas", False, 0, 5)
        self.objetosh2.append(self.vitaminaC)

        self.escudoCapitanAmerica = Objetos("Escudo del Capitán America", False, 5, 1) # tiene alarma

        self.escudoCapitanAmerica.setDescripion("Escudo de vibranium con los colores de la bandera, te sientes inspirado solo al llevarlo contigo." + "\nSi lo usas serás más difícil de golpear por ese turno.")
        self.objetosh2.append(self.escudoCapitanAmerica)

        self.martilloThor = Armas("Martillo de Thor", 10, 0)
        self.martilloThor.setDescripion("Martillo mágico con el que puedes atacar, sientes como fluye energía eléctrica por tu cuerpo." + "\nSi lo usas puedes aturdir a tu adversario con un rayo.")
        self.objetosh4.append(self.martilloThor)

        self.lanzaTelaranas = Objetos("Lanza Telarañas", True, 0, 0)
        self.lanzaTelaranas.setDescripion("Dispositivo lanza telarañas, probablemente pertenece a Spiderman." + "\nSi lo usas lanzas una telaraña... Obviamente.")
        self.objetosh1.append(self.lanzaTelaranas)

        self.inyeccion = Objetos("Inyección de adrenalina", False, 0, 50)
        self.inyeccion.setDescripion("Inyectadora con líquido verde, lleva marcada las siglas S.H.I.E.L.D." + "\nSi lo usas recuperarás tu salud.")
        self.objetosh4.append(self.inyeccion)

        self.Numero1 = Habitacion(1, False, self.objetosh1, self.intruso, None)
        self.Numero2 = Habitacion(2, False, self.objetosh2, None, None)
        self.Numero3 = Habitacion(3, False, self.objetosh3, None, None)
        self.Numero4 = Habitacion(4, False, self.objetosh4, None, None)
        self.Numero5 = Habitacion(5, True, self.objetosh5, None, None)
        self.Numero6 = Habitacion(6, False, self.objetosh6, None, None)
        self.Numero7 = Habitacion(7, True, self.objetosh7, None, None)
        self.Numero8 = Habitacion(8, False, self.objetosh8, None, None)
        self.Numero9 = Habitacion(9, True, self.objetosh9, None, self.robot)

        self.Numero3.setAlarma(Ahorro.ACTIVADO)
        self.Numero6.setAlarma(Ahorro.ACTIVADO)
        self.Numero8.setAlarma(Ahorro.ACTIVADO)

        self.casa = [self.Numero1, self.Numero2, self.Numero3, self.Numero4, self.Numero5, self.Numero6, self.Numero7, self.Numero8, self.Numero9]

        #ArrayList<Habitacion> habitacionesJarvis = new ArrayList<>()

        self.Numero1.setHabitacionesContiguas(self.Numero4, None, self.Numero2, None)
        self.Numero2.setHabitacionesContiguas(self.Numero5, None, self.Numero3, self.Numero1)
        self.Numero3.setHabitacionesContiguas(self.Numero6, None, None, self.Numero2)
        self.Numero4.setHabitacionesContiguas(self.Numero7, self.Numero1, self.Numero5, None)
        self.Numero5.setHabitacionesContiguas(self.Numero8, self.Numero2, self.Numero6, self.Numero4)
        self.Numero6.setHabitacionesContiguas(self.Numero9, self.Numero3, None, self.Numero5)
        self.Numero7.setHabitacionesContiguas(None, self.Numero4, self.Numero8, None)
        self.Numero8.setHabitacionesContiguas(None, self.Numero5, self.Numero9, self.Numero7)
        self.Numero9.setHabitacionesContiguas(None, self.Numero6, None, self.Numero8)

        # Inicio de habitaciones de intruso y robot, el intruso inicia en la habitacion
        # 1 y el robot en Habitacion 9

        self.intruso.setUbicacion(self.Numero1)
        self.intruso.getUbicacion().setLuces(Ahorro.ENCENDIDO)
        self.intruso.addHistorial()
        self.robot.setUbicacion(self.Numero9)
        self.robot.addHistorial()

        # ciclo de turnos del jugador
        """while mascaraIronMan not in intruso.getObjectInventory() and intruso.getHealth() > 0:
            huir = True
            print(intruso.ayudaJarvis())

            if robot.getUbicacion() == intruso.getUbicacion() and robot.getHealth() > 0:
                print("El robot te ha encontrado! preparate para luchar!!")

                while intruso.getHealth() > 0 and robot.getHealth() > 0 and huir:
                    print("Tienes " + str(intruso.getHealth()) + " puntos de vida.")
                    print("El robot tiene " + str(robot.getHealth()) + " puntos de vida.")

                    if robot.getSpeed() + Main.lanzarDados(5) > intruso.getSpeed() + Main.lanzarDados(5):
                        iniciativa[0] = robot
                        iniciativa[1] = intruso
                    else:
                        iniciativa[1] = robot
                        iniciativa[0] = intruso
                    for i in range(0, 2):
                        if iniciativa[i] is intruso:
                            print("Es tu turno:")
                            if intruso.isStunned():
                                print("Estas aturdido, no puedes moverte")
                                intruso.stun(False)
                                opcion = -1
                            else:
                                print("1. Atacar" + "\n2. Bloquear" + "\n3. Usar" + "\n4. Huir")
                                opcion = int(input())
                            if opcion == 1:
                                print("¿Con que deseas atacar?" + "\n0. A puñetazos.")
                                print(intruso.mostrarArmas())
                                opcion = int(input())
                                dados = Main.lanzarDados(5)
                                if opcion == 0 and dados >= robot.getArmor():
                                    intruso.atacar(robot)
                                    print("Le diste un puño al robot, probablemente te dolió mas a ti que a él.")
                                    print("Te sobas la mano.")
                                elif opcion != 0 and dados >= robot.getArmor():
                                    intruso.atacar(robot, intruso.getWeaponInventory()[opcion - 1].getBonusDamage())
                                    print("Atacaste al robot exitosamente")
                                else:
                                    print("El Robot bloqueo tu ataque!")
                            elif opcion == 2:
                                print("Tomas una posición defensiva y te preparas para recibir el ataque")
                                intruso.setArmor(3)

                            elif opcion == 3:
                                print(intruso.mostrarObjetos())
                                opcion = int(input())
                                if intruso.getObjectInventory()[opcion - 1].isShocker():
                                    intruso.getObjectInventory()[opcion - 1].usar(robot)
                                    print("Aturdiste al robot.")
                                else:
                                    intruso.getObjectInventory()[opcion - 1].usar(intruso)
                                    print("Recibiste la bonificacion de este objeto.")
                            elif opcion == 4:
                                if intruso.getSpeed() + Main.lanzarDados(5) >= 4:
                                    huir = False
                                    print("Tu agilidad te permitió saltar fuera del combate.")
                                else:
                                    print("Intentas huir, pero el robot te cierra el paso, mas suerte la proxima vez.")
                        else:
                            print("Es el turno del robot:")
                            if robot.isStunned():
                                print("El robot esta aturdido, no puede hacer nada.")
                                robot.stun(False)
                            else:
                                if robot.isCargaRobot():
                                    desicionRobot = 100
                                    print(robot.ataqueCargado(intruso))
                                else:
                                    desicionRobot = Main.lanzarDados(10)
                                print(robot.turno(desicionRobot, intruso))
                                print(bot.turno(desicionRobot, intruso))
                                bot.atacar(intruso)
                                print("El bot revolotea te estorba en la batalla")
                            intruso.setArmor(0)

            if robot.getHealth() <= 0 and x:
                    print("Destruiste al robot, ahora solo falta obtener la mascara.")
                    x = False

            if intruso.getHealth() > 0:
                print("¿Que deseas hacer?:" + "\n1. Moverte" + "\n2. Interactuar" + "\n3. Hablar con Jarvis" + "\n4. Salir del juego")
                opcion = int(input())
                if opcion == 1:
                    # Movimiento del intruso
                    print(intruso.habitacionesDisponibles())
                    print("Donde quieres moverte?")
                    opcionHab = int(input())
                    intruso.mover(casa[opcionHab - 1])

                    # Movimiento del robot
                    if robot.getHealth() > 0:
                        robot.apagarAlarma()
                        robot.escuchar(casa)
                        robot.escanear()
                        if robot.isNextTo():
                            robot.mover(robot.getGoingTo())
                        elif robot.isAware():
                            print(robot.buscar(casa).getNumero())
                            robot.mover(robot.buscar(casa)) # camino mas corto a la habitacion con alarma
                        else:
                            robot.mover(casa[robot.decidirDireccion() - 1]) # movimiento aleatorio

                elif opcion == 2:
                    print("¿Que deseas hacer?" + "\n1. Desbloquear una puerta." + "\n2. Recojer los objetos." + "\n3. Curar tu salud." + "\n4. Romper las luces.")
                    opcionIntec = int(input())
                    if opcionIntec == 1:
                        m = intruso.habitacionesaDesbloquear()
                        print(m)
                        if "no hay habitaciones bloqueadas alrededor" != m:
                            print("Que habitacion quieres desbloquear")
                            opcion = int(input())
                            if opcion == 5:
                                if Llaveh5 in intruso.getObjectInventory():
                                    Numero5.setBloqueada(False)
                                    print("Desbloqueaste la puerta con exito.")
                                else:
                                    print("no tienes la llave de esta habitacion")
                            elif opcion == 7:
                                if Llaveh7 in intruso.getObjectInventory():
                                    Numero7.setBloqueada(False)
                                    print("Desbloqueaste la puerta con exito.")
                                else:
                                    print("no tienes la llave de esta habitacion")
                            elif opcion == 9:
                                if Llaveh9 in intruso.getObjectInventory():
                                    Numero9.setBloqueada(False)
                                    print("Desbloqueaste la puerta con exito.")
                                else:
                                    print("no tienes la llave de esta habitacion")

                    elif opcionIntec == 2:
                        print(intruso.agarrar())
                    elif opcionIntec == 3:
                        print(intruso.mostrarObjetos() + "\n¿Cual deseas usar?")
                        opcion = int(input())
                        if intruso.getObjectInventory()[opcion].getBonusHealth() == 0:
                            print("No puedes usar este objeto para curarte")
                        else:
                            intruso.getObjectInventory()[opcion].usar(intruso)
                            print("Te has curado, ahora tienes " + str(intruso.getHealth()) + "puntos de vida.")
                    elif opcionIntec == 4:
                        if not intruso.getWeaponInventory():
                            print("Intentas romper las luces con tus manos, lamentablemente no tienes la fuerza suficiente para hacerlo")
                        else:
                            intruso.getUbicacion().setLuces(Ahorro.ROTO)
                            print("Las luces de esta habitacion no se volveran a encender.")
                elif opcion == 3:
                    print("Tus habilidades en Hacking te permiten tomar control de la IA Jarvis..." + "\nJ.A.R.V.I.S.: ¿En qué te puedo asistir?" + "\n1. Dame informacion acerca de las habitaciones." + "\n2. Dame informacion acerca del robot." + "\n3. Apaga las luces para que el robot no me encuentre." + "\n4. No sé que hacer, dame una pista." + "\n5. Ver historial de movimientos.")
                    opcion = int(input())
                    if opcion == 1:
                        print("De qué habitación necesitas saber?")
                        opcion = int(input())
                        print(casa[opcion - 1].ayudaJarvis())
                    elif opcion == 2:
                        print(robot.ayudaJarvis())
                    elif opcion == 3:
                        if intruso.getUbicacion().getLuces() is not  Ahorro.ROTO:
                            intruso.getUbicacion().setLuces(Ahorro.APAGADO)
                        print("J.A.R.V.I.S.: Luces apagadas.")
                    elif opcion == 4:
                        opcion = Main.lanzarDados(10)
                        if opcion < 4:
                            print(Jarvis.PISTA1)
                        elif opcion < 6:
                            print(Jarvis.PISTA2)
                        elif opcion < 8:
                            print(Jarvis.PISTA3)
                        elif opcion < 10:
                            print(Jarvis.PISTA4)
                        else:
                            print(Jarvis.PISTA5)
                    elif opcion == 5:
                        for linea in Individuo.getHistorial():
                            print(linea)
                    

                elif opcion == 4:
                    Main.salirDelsistema()
                
        # mensajes finales
        if mascaraIronMan in intruso.getObjectInventory():
            print("Despues de un arduo trabajo conseguiste lo que buscabas, la mascara de Ironman te permitio abrir un hueco en la pared y huir." + "\nPor fin podras añadir esto a tu mesa de trofeos, tu proximo objetivo: La Capa de Dr Strange... pero eso sera en otra ocasion." + "\nBuen trabajo y Gracias por Jugar!!!")
            Main.salirDelsistema()
        else:
            print("Todo se volvio negro, y cuando abriste los ojos te encontraste en una celda de maxima seguridad." + "\nParece que estaras aqui por un buen tiempo." + "\nFin del Juego.")
            Main.salirDelsistema()
            

if __name__ == "__main__":
    Main.main()"""
