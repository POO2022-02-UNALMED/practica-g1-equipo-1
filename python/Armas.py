from herramientas import Herramientas

class Armas(Herramientas): #Revisar lo del serializado
    _armas = []

    @staticmethod
    def getArmas():
        return Armas._armas

    def __init__(self, name, bdamage, bspeed):
        self._description = "objeto generico"
        self._name = name
        self._bonusDamage = bdamage
        self._bonusSpeed = bspeed
        Armas._armas.append(self)
   
    #METODOS GET

    def getName(self):
        return self._name
    def getDescription(self):
        return self._description
    def getBonusDamage(self):
        return self._bonusDamage
    def getBonusSpeed(self):
        return self._bonusSpeed

    #METODO SET
    def setDescripion(self, i):
        self._description = i

    def usar(self, i):
        pass

    def toString(self):
        m = "nombre: " + self._name + "\ndescripcion: " + self._description + "\nbonus damage: " + str(self._bonusDamage) + "\nbonus speed: " + str(self._bonusSpeed) + "\n"
        return m
