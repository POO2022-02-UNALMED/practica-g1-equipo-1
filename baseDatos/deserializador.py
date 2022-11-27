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

def deserializar(listaObjetos, className):
        def camino(className):
            return os.path.join(pathlib.Path(__file__).parent.absolute(), f"temp\{className}.txt")

        #read
        try:
            picklefile = open(camino(className), 'rb')

        except:
            picklefile = open(camino(className), 'x')
            picklefile = open(camino(className), 'rb')

        #unpickle
        if os.path.getsize(camino(className)) > 0:
            listaObjetos = pickle.load(picklefile)
        
        #close
        picklefile.close()

        return listaObjetos
    
def deserializarTodo():
    Armas._armas = deserializar(Armas._armas, "armas")
    Habitacion._habitaciones = deserializar(Habitacion._habitaciones, "habitaciones")
    Intruso._intrusos = deserializar(Intruso._intrusos, "intrusos")
    Objetos._objetos = deserializar(Objetos._objetos, "objetos")
    Robot._robots = deserializar(Robot._robots, "robots")