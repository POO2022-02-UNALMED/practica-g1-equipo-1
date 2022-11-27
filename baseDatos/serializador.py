import pickle

#Logicas
from python.Ahorro import Ahorro
from python.Armas import Armas
from python.Habitacion import Habitacion
from python.Herramientas import Herramientas #talvez esta no esta en el main
from python.Individuo import Individuo
from python.Jarvis import Jarvis
from python.Objetos import Objetos
from python.Bot import Bot

#herencia
from python.Robot import Robot
from python.Intruso import Intruso
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
