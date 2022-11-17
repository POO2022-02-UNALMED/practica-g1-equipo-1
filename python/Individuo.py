class Individuo(Jarvis):

    _historial = []

    def __init__(self, health, armor, speed):
        #instance fields found by Java to Python Converter:
        self._health = 0
        self._armor = 0
        self._speed = 0
        self._stunned = False
        self._ubicacion = None

        self._health = health
        self._armor = armor
        self._speed = speed
    #Metodos para moverse
    def mover(self, hab):
        pass

    def habitacionesDisponibles(self):
        disponibles = []
        disponibles.append(self.getUbicacion().getNorte())
        disponibles.append(self.getUbicacion().getSur())
        disponibles.append(self.getUbicacion().getEste())
        disponibles.append(self.getUbicacion().getOeste())
        mensaje = "Puedes moverte a la habitacion numero: "
        mensaje2 = "Aun no puedes moverte a la habitacion numero: "
        for Hab in disponibles:
            if (not Objects.isNull(Hab)) and Hab.isBloqueada():
                mensaje2 += Hab.getNumero() + " Porque esta Bloqueada "
            if not Objects.isNull(Hab): #arreglar esto
                mensaje += Hab.getNumero() + " "
        return mensaje+"\n"+mensaje2

    def habitacionesaDesbloquear(self):
        disponibles = []
        disponibles.append(self.getUbicacion().getNorte())
        disponibles.append(self.getUbicacion().getSur())
        disponibles.append(self.getUbicacion().getEste())
        disponibles.append(self.getUbicacion().getOeste())
        mensaje = "Estas habitaciones estan bloqueada: "
        b = False
        #  String mensaje2 = "Esta habitaciones no estan bloqueadas: "
        for Hab in disponibles:
            if (not Objects.isNull(Hab)) and Hab.isBloqueada():
                mensaje += Hab.getNumero() + " "
                b = True
        if b:
            return mensaje
        else:
            return "no hay habitaciones bloqueadas alrededor"
    def addHistorial(self):
        pass

    #Pelea
    def atacar(self, i):
        pass
    # METODOS GET
    def getHealth(self):
        return self._health
    def getArmor(self):
        return self._armor
    def getSpeed(self):
        return self._speed
    def isStunned(self):
        return self._stunned
    def getUbicacion(self):
        return self._ubicacion
    def setUbicacion(self, ubicacion):
        self._ubicacion = ubicacion
    @staticmethod
    def getHistorial():
        return Individuo._historial

    #METODOS SET
    def setHealth(self, i):
        self._health = i
    def setArmor(self, i):
        self._armor = i
    def setSpeed(self, i):
        self._speed = i
    def stun(self, i):
        self._stunned = i
      
