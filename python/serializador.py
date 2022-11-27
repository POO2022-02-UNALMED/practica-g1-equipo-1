import pickle

#Logicas

from Armas import Armas
from Habitacion import Habitacion
from Herramientas import Herramientas #talvez esta no esta en el main
from Individuo import Individuo
from Jarvis import Jarvis
from Objetos import Objetos
from Bot import Bot

#herencia
from Robot import Robot
from Intruso import Intruso
import pathlib
import os

class Serializador():
    
    def serializar(lista, className):
        def camino(className):
            return os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\"+className+".txt")
            
        try:
            picklefile = open(camino(className), 'wb')
            pickle.dump(lista, picklefile)
            picklefile.close()
            
        except:
            print("Falla al serializar")

    def serializarTodo():
        Serializador.serializar(Armas.getArmas(), "armas")
        Serializador.serializar(Habitacion.getHabitaciones(), "habitaciones")
        Serializador.serializar(Objetos.getObjetos(), "objetos")
        Serializador.serializar(Intruso.getIntrusos(), "intrusos ")
        Serializador.serializar(Robot.getRobots(), "robots")
