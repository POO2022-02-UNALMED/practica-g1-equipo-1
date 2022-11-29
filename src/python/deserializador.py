import pickle

#Logicas
from Ahorro import Ahorro
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

def deserializar(listaObjetos, className):
        def camino(className):
            return ("python/baseDatos/temp/"+className+".txt")

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