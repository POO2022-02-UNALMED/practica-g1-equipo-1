import pickle

#Logicas
from python.gestorAplicacion.clasesLogicas.Ahorro import Ahorro
from python.gestorAplicacion.clasesLogicas.Armas import Armas
from python.gestorAplicacion.clasesLogicas.Habitacion import Habitacion
from python.gestorAplicacion.clasesLogicas.Individuo import Individuo
from python.gestorAplicacion.clasesLogicas.Jarvis import Jarvis
from python.gestorAplicacion.clasesLogicas.Objetos import Objetos
from python.gestorAplicacion.clasesLogicas.Bot import Bot

#herencia
from python.gestorAplicacion.clasesLogicasHerencia.Robot import Robot
from python.gestorAplicacion.clasesLogicasHerencia.Intruso import Intruso
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
        serializar(Ahorro)