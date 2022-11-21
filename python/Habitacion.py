from jarvis import Jarvis
from ahorro import Ahorro

class Habitacion(Jarvis):
    _habitaciones = []

    @staticmethod
    def getHabitaciones():
        return Habitacion._habitaciones

    def __init__(self, numero, bloqueada, listaObjetos, intruso, robot):
        self._norte = None
        self._sur = None
        self._este = None
        self._oeste = None

        self._numero = numero
        self._bloqueada = bloqueada
        self._listaObjetos = listaObjetos
        self._intruso = intruso
        self._robot = robot
        self._luces = Ahorro.APAGADO
        self._alarma = Ahorro.APAGADO
        Habitacion._habitaciones.append(self)

    #Getter y setters
    def getNumero(self):
        return self._numero
    def setNumero(self, numero):
        self._numero = numero

    def isBloqueada(self):
        return self._bloqueada
    def setBloqueada(self, bloqueada):
        self._bloqueada = bloqueada

    def getListaObjetos(self):
        return self._listaObjetos
    def setListaObjetos(self, listaObjetos):
        self._listaObjetos = listaObjetos

    def getIntruso(self):
        return self._intruso
    def setIntruso(self, intruso):
        self._intruso = intruso

    def getRobot(self):
        return self._robot
    def setRobot(self, robot):
        self._robot = robot

    def setAlarma(self, a):
        self._alarma = a
    def getAlarma(self):
        return self._alarma
    def setLuces(self, a):
        self._luces = a
    def getLuces(self):
        return self._luces


    def setHabitacionesContiguas(self, norte, sur, este, oeste):
        self._norte = norte
        self._sur = sur
        self._este = este
        self._oeste = oeste

    def getNorte(self):
        return self._norte
    def getSur(self):
        return self._sur
    def getEste(self):
        return self._este
    def getOeste(self):
        return self._oeste
    
    #Jarvis
    def ayudaJarvis(self):
        if self._intruso is not None:
            a = "estas ahi"
        elif self._robot is not None:
            a = "el robot esta ahi"
        else:
            a = "no hay nadie ahi"
        return "En esta habitacion hay " + str(len(self._listaObjetos)) + " objetos, " + a #y ya pasaste o no has pasado por ahi

    def toString(self):
        o = ""
        for e in self._listaObjetos:
            o += "\n" + e
        m = "numero: " + str(self._numero) + "\nbloqueada: " + self._bloqueada + "\nintruso: " + self._intruso + "\nrobot: " + self._robot + "\nhabitacionesContiguas: " + self._norte.getNumero() + " " + self._sur.getNumero() + " " + self._este.getNumero() + " " +self._oeste.getNumero()
        m += "\nalarma: " + self._alarma + "\nluces: " + self._luces
        m += "\nlista objetos: " + o
        return m
