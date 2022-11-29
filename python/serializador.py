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


    
def serializar():
    """ Método encargado de guardar los datos del
        sistema al cerrar la app"""

    datos = {
            "armas": Armas.getArmas(),
            "habitaciones": Habitacion.getHabitaciones(),
            "objetos": Objetos.getObjetos(),
            "intrusos ": Intruso.getIntrusos(), 
            "robots": Robot.getRobots(), 
            }

    for archivo, dato in datos.items():
        picklefile = open(os.path.join(pathlib.Path(__file__).parent.absolute(), f"temp\\{archivo}"),"wb")
        pickle.dump(dato, picklefile)
        picklefile.close()


