import pickle

#Logicas
from python.gestorAplicacion.clasesLogicas.Ahorro import Ahorro
from python.gestorAplicacion.clasesLogicas.Armas import Armas
from python.gestorAplicacion.clasesLogicas.Habitacion import Habitacion
from python.gestorAplicacion.clasesLogicas.Herramientas import Herramientas #talvez esta no esta en el main
from python.gestorAplicacion.clasesLogicas.Individuo import Individuo
from python.gestorAplicacion.clasesLogicas.Jarvis import Jarvis
from python.gestorAplicacion.clasesLogicas.Objetos import Objetos
from python.gestorAplicacion.clasesLogicas.Bot import Bot

#herencia
from python.gestorAplicacion.clasesLogicasHerencia.Robot import Robot
from python.gestorAplicacion.clasesLogicasHerencia.Intruso import Intruso
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