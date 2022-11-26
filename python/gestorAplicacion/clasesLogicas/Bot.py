
from gestorAplicacion.clasesLogicasHerencia.Robot import Robot

class Bot(Robot):
    _DUMPENER = 10
    def __init__(self):
        super().__init__(10, 0, 0, False, False, False)


    def atacar(self, i):
        i.setHealth(i.getHealth()- Bot.getATTACK()+Bot._DUMPENER)

    def turno(self, desicion, i):
        if desicion < 6:
            return "B.O.T.: No escaparas!!"

        elif desicion == 6 or desicion == 7:
            return "B.O.T.: Estas perdido!!"
        elif desicion == 8 or desicion == 9:
            return "B.O.T.: JAJAJAJA"
        elif desicion == 10:
            return"No te lleves lo que no es tuyo!!"
        else:
            return ""
