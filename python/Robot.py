import math
import random
from individuo import Individuo
from ahorro import Ahorro
#from main import Main

class Robot(Individuo):
    
    @staticmethod
    def lanzarDados(caras):
        return int(math.floor(random.random() * (caras) + 1))


    _robots = []
    @staticmethod
    def getRobots():
        return Robot._robots

    _ATTACK = 12

    def __init__(self, health = 150, armor = 3, speed = 7, aware = False, nextTo = False, cargaRobot = False):
        self._goingTo = None

        super().__init__(health, armor, speed)
        self._aware = aware
        self._nextTo = nextTo
        self._cargaRobot = cargaRobot
        Robot._robots.append(self)

    #Metodos de busqueda
    def escuchar(self, casa):
        if self.getHealth() > 0:
            for hab in casa:
                if hab.getAlarma() is Ahorro.ENCENDIDO:
                    self._aware = True
                    self._goingTo = hab
                    break
                else:
                    self._aware = False

    def escanear(self):
        if self.getHealth() > 0:
            disponibles = []
            disponibles.append(self.getUbicacion().getNorte())
            disponibles.append(self.getUbicacion().getSur())
            disponibles.append(self.getUbicacion().getEste())
            disponibles.append(self.getUbicacion().getOeste())
            for Hab in disponibles:
                if (Hab is not None) and Hab.getLuces() is Ahorro.ENCENDIDO:
                    self._nextTo = True
                    self._goingTo = Hab
                    break
                else:
                    self._nextTo = False

    def apagarAlarma(self):
        if self.getHealth() > 0 and self.getUbicacion().getAlarma() is Ahorro.ENCENDIDO:
            self.getUbicacion().setAlarma(Ahorro.ACTIVADO)
    def buscar(self, casa):
        hab = None
        if self.getHealth() > 0:
            disponibles = []
            disponibles.append(self.getUbicacion().getNorte())
            disponibles.append(self.getUbicacion().getSur())
            disponibles.append(self.getUbicacion().getEste())
            disponibles.append(self.getUbicacion().getOeste())
            j = 0
            for d in disponibles:
                if d is None:
                    j += 1
            if (self._goingTo.getNorte() is not None) and self._goingTo.getNorte() in disponibles:
                hab = self._goingTo.getNorte()
            elif (self._goingTo.getSur() is not None) and self._goingTo.getSur() in disponibles:
                hab = self._goingTo.getSur()
            elif (self._goingTo.getEste() is not None) and self._goingTo.getEste() in disponibles:
                hab = self._goingTo.getEste()
            elif (self._goingTo.getOeste() is not None) and self._goingTo.getOeste() in disponibles:
                hab = self._goingTo.getOeste()
            elif j == 2:
                for d in disponibles:
                    if d is not None:
                        hab = d
            else:
                hab = casa[4]
        return hab
    
    #METODOS PELEAR
    def atacar(self, i):
        i.setHealth(i.getHealth()-Robot._ATTACK)

    def ataqueCargado(self, i):
        self._cargaRobot = False
        if Robot.lanzarDados(5) >= i.getArmor():
            self.atacar(i)
            self.atacar(i)
            self.atacar(i)
            return "El robot lanza un poderoso laser hacia ti!!"
        else:
            return "El robot lanza un poderoso laser hacia ti! Por suerte, logras esquivarlo"
    def turno(self, desicion, i):
        if desicion < 6:
            if Robot.lanzarDados(5) >= i.getArmor():
                self.atacar(i)
                return "El robot te acaba de asestar un golpe"
            else:
                return "Bloqueaste el golpe del robot"

        elif desicion == 6 or desicion == 7:
            self._cargaRobot = True
            return "El pecho del robot comienza a brillar con fuerza"
        elif desicion == 8 or desicion == 9:
            if Robot.lanzarDados(5) >= i.getArmor():
                i.stun(True)
                return "El robot te electrocutó, estarás aturdido por el siguiente turno"
            else:
                return "Bloqueaste el golpe del robot"
        elif desicion == 10:
            if i.getObjectInventory():
                dados = Robot.lanzarDados(len(i.getObjectInventory()))-1
                quitada = i.getObjectInventory().pop(dados)
                self.getUbicacion().getListaObjetos().append(quitada)
                
                return "El robot logra quitarte " + quitada.getName() + " y lo arroja al suelo."
            else:
                return "El robot intenta quitarte algo... pero aun no has recogido nada."

        else:
            return ""

    #METODOS GET
    @staticmethod
    def getATTACK():
        return Robot._ATTACK
    def isAware(self):
        return self._aware
    def isNextTo(self):
        return self._nextTo
    def isCargaRobot(self):
        return self._cargaRobot
    def getGoingTo(self):
        return self._goingTo

    #METODOS SET
    def setAware(self, b):
        self._aware = b

    def ayudaJarvis(self):
        if self._aware or self._nextTo:
            a = "sabe dónde estás."
        else:
            a = "no nota tu presencia... aún."
        if self.getHealth() > 0:
            return "El robot se encuentra en la habitacion " + str(self.getUbicacion().getNumero()) + ", tiene " + str(self.getHealth()) + " puntos de vida y " + a
        else:
            return "El robot ya ha sido destruido"

    def addHistorial(self):
        Robot.getHistorial().append("Robot se movio a la habitacion " + str(self.getUbicacion().getNumero()))
    def mover(self, hab):
        if self.getHealth() > 0:
            self.getUbicacion().setRobot(None)
            self.setUbicacion(hab)
            self.getUbicacion().setRobot(self)
            self.addHistorial()
        else:
            self.setUbicacion(None)

    def decidirDireccion(self):
        disponibles = []
        disponibles.append(self.getUbicacion().getNorte())
        disponibles.append(self.getUbicacion().getSur())
        disponibles.append(self.getUbicacion().getEste())
        disponibles.append(self.getUbicacion().getOeste())
        i = []
        for Hab in disponibles:
            if Hab is not None:
                i.append(Hab.getNumero())
        return i[Robot.lanzarDados(len(i))-1]

    def toString(self):

        m = "El Robot tiene... vida: " + self.getHealth() + " armadura: " + self.getArmor() + " velocidad: " + self.getSpeed() + " ataque: " + str(Robot._ATTACK)
        m += ", esta en la habitacion " + self.getUbicacion().getNumero()
        return m

