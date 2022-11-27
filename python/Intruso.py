
from Individuo import Individuo
from Ahorro import Ahorro
from Armas import Armas

class Intruso(Individuo):

    _intrusos = []

    _ATTACK = 10

    def __init__(self, health = 100, armor = 0, speed = 0):
        self._weaponInventory = []
        self._objectInventory = []

        super().__init__(health, armor, speed)
        Intruso._intrusos.append(self)

    @staticmethod
    def getIntrusos():
        return Intruso._intrusos
    
    def mostrarArmas(self):
        mensaje = "Tienes estas armas:  "
        i = 1
        for arma in self._weaponInventory:
            mensaje += "\n" + str(i) + ". " + arma.getName()+ "."
            i += 1
        return mensaje

    def mostrarObjetos(self):
        mensaje = "Tienes estos objetos:"
        i = 1
        for objeto in self._objectInventory:
            mensaje += "\n" + str(i) + ". " + objeto.getName() + "."
            i += 1
        return mensaje


    #Interacciones
    def agarrar(self):
        m = "sin problemas."
        if self.getUbicacion().getAlarma() is Ahorro.ACTIVADO:
            self.getUbicacion().setAlarma(Ahorro.ENCENDIDO)
            m = "una alarma empezo a sonar."
        for herramientas in self.getUbicacion().getListaObjetos():
            if isinstance(herramientas, Armas):
                self._weaponInventory.append(herramientas)
            else:
                self._objectInventory.append(herramientas)
        self.getUbicacion().getListaObjetos().clear()
        return "Recogiste todos los objetos, " + m


    #METODOS PELEAR
    def atacar(self, r):
        r.setHealth(r.getHealth()-Intruso._ATTACK)
    def atacar(self, r, bonus):
        r.setHealth(r.getHealth()-Intruso._ATTACK-bonus)

    #METODOS GET
    @staticmethod
    def getATTACK():
        return Intruso._ATTACK
    def getWeaponInventory(self):
        return self._weaponInventory
    def getObjectInventory(self):
        return self._objectInventory

    #METODOS SET
    def setWeaponInventory(self, a):
        self._weaponInventory = a
    def setObjectInventory(self, o):
        self._objectInventory = o

    def addHistorial(self):
        Intruso.getHistorial().append("Intruso se movio a la habitacion: " + str(self.getUbicacion().getNumero()))

    def mover(self, hab):
        if hab.isBloqueada():
            super().habitacionesDisponibles()
        else:
            if self.getUbicacion().getLuces() is not Ahorro.ROTO:
                self.getUbicacion().setLuces(Ahorro.APAGADO) #apaga las luces
            self.getUbicacion().setIntruso(None)
            self.setUbicacion(hab)
            if self.getUbicacion().getLuces() is not Ahorro.ROTO:
                self.getUbicacion().setLuces(Ahorro.ENCENDIDO) #enciende las luces
            self.getUbicacion().setIntruso(self)
            self.addHistorial()



    def ayudaJarvis(self):

        mensaje = "Te encuentras en la habitacion " + str(self.getUbicacion().getNumero())
        if not self.getUbicacion().getListaObjetos() and self.getUbicacion().getLuces() is Ahorro.ENCENDIDO:
            mensaje += "\nNo hay objetos que recoger en esta habitacion"
        elif self.getUbicacion().getListaObjetos() and self.getUbicacion().getLuces() is Ahorro.ENCENDIDO:
            mensaje += "\nVes algunos objetos que te podrian ser utiles: "
            for h in self.getUbicacion().getListaObjetos():
                mensaje += "\n" + h.getName() + ": " + h.getDescription()
        else:
            mensaje += "\nNo hay luz, por lo que no ves nada."
        if self.getUbicacion().getAlarma() is Ahorro.ENCENDIDO:
            mensaje += "\nUna alarma esta sonando en la habitacion."
        return mensaje

    def toString(self):
        o = ""
        a = ""
        for e in self._weaponInventory:
            a += "\n" + e
        for e in self._objectInventory:
            o += "\n" + e
        m = "El intruso tiene... vida: " + self.getHealth() + ", armadura: " + self.getArmor() + ", velocidad: " + self.getSpeed() + ", ataque: " + str(Intruso._ATTACK)
        m += ", esta en la habitacion " + self.getUbicacion().getNumero()
        m +=", inventario Armas: " + a
        m +=", inventario objetos: " + o
        return m
