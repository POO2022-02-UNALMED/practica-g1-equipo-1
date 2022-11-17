class Objetos(Herramientas):

    def _initialize_instance_fields(self):
        #instance fields found by Java to Python Converter:
        self._description = "objeto generico"
        self._name = None
        self._shocker = False
        self._bonusArmor = 0
        self._bonusHealth = 0

    _objetos = []
    @staticmethod
    def getObjetos():
        return Objetos._objetos
    #Cuadrar lo de los constructores, no hay un equivalente en Python a los constructores múltiples
    def __init__(self, name, shocker, barmor, bhealth):
        self._initialize_instance_fields()

        self._name = name
        self._shocker = shocker
        self._bonusArmor = barmor
        self._bonusHealth = bhealth
        Objetos._objetos.append(self)

    def __init__(self, name):
        self._initialize_instance_fields()

        self._name = name
        self._shocker = False
        self._bonusArmor = 0
        self._bonusHealth = 0
        Objetos._objetos.append(self)
    
    #METODOS GET

    def getName(self):
        return self._name
    def getDescription(self):
        return self._description
    def isShocker(self):
        return self._shocker
    def getBonusArmor(self):
        return self._bonusArmor
    def getBonusHealth(self):
        return self._bonusHealth

    #METODO SET
    def setDescripion(self, i):
        self._description = i

    def usar(self, i):
        if self._shocker:
            i.stun(True)
        else:
            i.setArmor(i.getArmor()+self._bonusArmor)
            i.setHealth(i.getHealth()+self._bonusHealth)
            if i.getHealth() > 100:
                i.setHealth(100)


    def toString(self):
        m = "nombre: " + self._name + "\ndescripcion: " + self._description + "\nbonus armor: " + str(self._bonusArmor) + "\nbonus health: " + str(self._bonusHealth) + "\n aturde: " + self._shocker + "\n"
        return m
