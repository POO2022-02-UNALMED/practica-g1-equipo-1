import os.path
import random
from tkinter import *
from tkinter import messagebox

from Ahorro import Ahorro
from Armas import Armas
from Habitacion import Habitacion
from Individuo import Individuo
from Jarvis import Jarvis
from Objetos import Objetos
from Bot import Bot

from Intruso import Intruso
from Robot import Robot
from Main import Main

class FieldFrame(Frame):

    
    def __init__(self, ventana, tituloCriterios = "", criterios = None, tituloValores = "", valores = None, habilitado = None, objeto = None):
        super().__init__(ventana)
        self.pack(expand=True,fill='both',anchor=CENTER)
        #self.columnconfigure(0,weight=1,uniform='col')
        #self.columnconfigure(1,weight=1,uniform='col')
        #self.columnconfigure(2,weight=0)

        self._tituloCriterios = tituloCriterios
        self._criterios = criterios
        self._tituloValores = tituloValores
        self._valores = valores
        self._habilitado = habilitado
        self._objeto = objeto

        self.map = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map.png')
        self.map = self.map.subsample(2)
        self.map1 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map1.png')
        self.map1 = self.map1.subsample(2)
        self.map2 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map2.png')
        self.map2 = self.map2.subsample(2)
        self.map3 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map3.png')
        self.map3 = self.map3.subsample(2)
        self.map4 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map4.png')
        self.map4 = self.map4.subsample(2)
        self.map5 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map5.png')
        self.map5 = self.map5.subsample(2)
        self.map6 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map6.png')
        self.map6 = self.map6.subsample(2)
        self.map7 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map7.png')
        self.map7 = self.map7.subsample(2)
        self.map8 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map8.png')
        self.map8 = self.map8.subsample(2)
        self.map9 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map9.png')
        self.map9 = self.map9.subsample(2)


        
        self._elementos = [] #Array elementos

        #titulo de criterios
        labelTituCrite = Label(self, text = tituloCriterios, font= ("Helvetica 14", 14))
        labelTituCrite.grid(column=0, row=0, padx = (10,10), pady = (10,10),sticky='nsew')

        #colocar titulo de los valores
        labelTituVal = Label(self, text = tituloValores, font= ("Helvetica 14", 14))
        labelTituVal.grid(column=1, row=0, padx = (10,10), pady = (10,10),sticky='nsew')

        #crea los criterios
        for  i in range(len(criterios)):
            labelCriterio = Label(self, text = criterios[i], font = ("Helvetica 14", 12),anchor=CENTER)
            labelCriterio.grid(column=0, row=i+1, padx = (10,10), pady = (10,10),sticky='nsew')

            entryValor = Entry(self, font = ("Helvetica 14", 12))
            entryValor.grid(column=1, row=i+1, padx = (10,10), pady = (10,10),sticky='nsew')

            #poner valor inicial
            if valores is not None:
                entryValor.insert(0, valores[i])
                

            #deshabilitar si es no editable
            if habilitado is not None and not habilitado[i]:
                entryValor.configure(state = DISABLED)
        
            self._elementos.append(entryValor)

        #anexo
        if self._tituloCriterios == 'movimiento':
            labelanex= Label(self, text = 'Tu Ubicacion', font = ("Helvetica 14", 12),anchor=CENTER)
            labelanex.grid(column=0, row=len(self._criterios)+1, padx = (10,10), pady = (10,10),sticky='nsew')

            self.label_map= Label(master=self)
            if Intruso.getIntrusos()[0].getUbicacion().getNumero() == 1:
                self.label_map['image'] = self.map1
            elif Intruso.getIntrusos()[0].getUbicacion().getNumero() == 2:
                self.label_map['image'] = self.map2
            elif Intruso.getIntrusos()[0].getUbicacion().getNumero() == 3:
                self.label_map['image'] = self.map3
            elif Intruso.getIntrusos()[0].getUbicacion().getNumero() == 4:
                self.label_map['image'] = self.map4
            elif Intruso.getIntrusos()[0].getUbicacion().getNumero() == 5:
                self.label_map['image'] = self.map5
            elif Intruso.getIntrusos()[0].getUbicacion().getNumero() == 6:
                self.label_map['image'] = self.map6
            elif Intruso.getIntrusos()[0].getUbicacion().getNumero() == 7:
                self.label_map['image'] = self.map7
            elif Intruso.getIntrusos()[0].getUbicacion().getNumero() == 8:
                self.label_map['image'] = self.map8
            elif Intruso.getIntrusos()[0].getUbicacion().getNumero() == 9:
                self.label_map['image'] = self.map9
            else:
                self.label_map['image'] = self.map
                
            self.label_map.grid(column=1, row=len(self._criterios)+1, padx = (10,10), pady = (10,10),sticky='nsew')   
        elif self._tituloCriterios == 'interaccion' or self._tituloCriterios == 'Tu turno':
            labelanex= Label(self, text = 'Tu Inventario', font = ("Helvetica 14", 12),anchor=CENTER)
            labelanex.grid(column=0, row=len(self._criterios)+1, padx = (10,10), pady = (10,10),sticky='nsew')

            self.textInv = Text(master=self,width=20,height=5)
            self.textInv.grid(column=1, row=len(self._criterios)+1, padx = (10,10), pady = (10,10),sticky='nsew')
            self.textInv.insert('1.0',Intruso.getIntrusos()[0].mostrarArmas() + '\n' + Intruso.getIntrusos()[0].mostrarObjetos())

        self.crearBotones(0,'Aceptar',self.comando)
        self.crearBotones(1,'Borrar',self.borrar)
    
    def actualizarDescripcion(self,descripcion):
        self._objeto.detalles.__setitem__('state','normal')
        self._objeto.detalles.delete('1.0','end-1c')
        self._objeto.detalles.insert('1.0',descripcion)
        self._objeto.detalles.__setitem__('state','disabled')

    def getValue(self, indice):
        #indice = self._criterios.index(criterio)
        return self._elementos[indice].get()
    
    def borrar(self):
        for e in self._elementos:
            e.delete(0,'end')

    def crearBotones(self, col, t, comando1):
        aceptar = Button(self, text=t, font = ("Helvetica 14", 12), fg = "white", bg = "#B1B1B1", command=comando1).grid(pady = 50, column = col, row = len(self._criterios)+2)

    def comando(self):
        
        if self._tituloCriterios == 'movimiento':
            #movimiento intruso
            Intruso.getIntrusos()[0].mover(Habitacion.getHabitaciones()[int(self.getValue(2))-1])

            #movimiento robot
            if Robot.getRobots()[0].getHealth() > 0:
                        Robot.getRobots()[0].apagarAlarma()
                        Robot.getRobots()[0].escuchar(Habitacion.getHabitaciones())
                        Robot.getRobots()[0].escanear()
                        if Robot.getRobots()[0].isNextTo():
                            Robot.getRobots()[0].mover(Robot.getRobots()[0].getGoingTo())
                        elif Robot.getRobots()[0].isAware():
                            #print(robot.buscar(casa).getNumero())
                            Robot.getRobots()[0].mover(Robot.getRobots()[0].buscar(Habitacion.getHabitaciones())) # camino mas corto a la habitacion con alarma
                        else:
                            Robot.getRobots()[0].mover(Habitacion.getHabitaciones()[Robot.getRobots()[0].decidirDireccion() - 1]) # movimiento aleatorio
            if Robot.getRobots()[0].getUbicacion() == Intruso.getIntrusos()[0].getUbicacion() and Robot.getRobots()[0].getHealth() > 0:
                self._objeto.batalla()
            else:
                self._objeto.moverte()

        #interactuar
        elif self._tituloCriterios == 'interaccion':
            if self.getValue(0) == 'desbloquear':
                if self.getValue(1) == 'llave azul' and '5' in Intruso.getIntrusos()[0].habitacionesDisponibles()[1]:
                    Habitacion.getHabitaciones()[4].setBloqueada(False)
                    i ='5'
                elif self.getValue(1) == 'llave plateada' and '7' in Intruso.getIntrusos()[0].habitacionesDisponibles()[1]:
                    Habitacion.getHabitaciones()[6].setBloqueada(False)
                    i = '7'
                elif self.getValue(1) == 'llave dorada' and '9' in Intruso.getIntrusos()[0].habitacionesDisponibles()[1]:
                    Habitacion.getHabitaciones()[8].setBloqueada(False)
                    i = '9'
                self.actualizarDescripcion('Desbloqueaste la habitacion '+i+' con exito!')
            
            elif self.getValue(0) == 'recoger':
                self.actualizarDescripcion(Intruso.getIntrusos()[0].agarrar())

                self.textInv.delete('1.0','end-1c')
                self.textInv.insert('1.0',Intruso.getIntrusos()[0].mostrarArmas() + '\n' + Intruso.getIntrusos()[0].mostrarObjetos())

                for o in  Intruso.getIntrusos()[0].getObjectInventory():
                    if o.getName() == "La mascara de Ironman":
                        self._objeto.victoria()
                        break

            elif self.getValue(0) == 'curar':

                for o in  Intruso.getIntrusos()[0].getObjectInventory():
                    if o.getName() == self.getValue(1):
                        o.usar(Intruso.getIntrusos()[0])
                self.actualizarDescripcion("Te has curado, ahora tienes " + str(Intruso.getIntrusos()[0].getHealth()) + " puntos de vida.")
            
            elif self.getValue(0) == 'romper luces':
                if self.getValue(1) == 'ninguno':
                    self.actualizarDescripcion("Intentas romper las luces con tus manos, lamentablemente no tienes la fuerza suficiente para hacerlo")
                elif self.getValue(1) == 'Martillo de Thor':
                    Intruso.getIntrusos()[0].getUbicacion().setLuces(Ahorro.ROTO)
                    self.actualizarDescripcion("Las luces de esta habitacion no se volveran a encender.")

        #jarvis
        elif self._tituloCriterios == 'criterios':   
            if 'habitacion' in self.getValue(0):
                e = self.getValue(0).split()
                self.actualizarDescripcion(Habitacion.getHabitaciones()[int(e[1]) - 1].ayudaJarvis())
            elif self.getValue(0) == 'robot':
                self.actualizarDescripcion(Robot.getRobots()[0].ayudaJarvis())
            elif self.getValue(0) == 'apagar luces':
                if Intruso.getIntrusos()[0].getUbicacion().getLuces() is not  Ahorro.ROTO:
                    Intruso.getIntrusos()[0].getUbicacion().setLuces(Ahorro.APAGADO)
                    self.actualizarDescripcion("J.A.R.V.I.S.: Luces apagadas.")
                else:
                    self.actualizarDescripcion("J.A.R.V.I.S.: Las luces ya estan rotas.")
            elif self.getValue(0) == 'pista':
                opcion = Main.lanzarDados(10)
                if opcion < 4:
                    self.actualizarDescripcion(Jarvis.PISTA1)
                elif opcion < 6:
                    self.actualizarDescripcion(Jarvis.PISTA2)
                elif opcion < 8:
                    self.actualizarDescripcion(Jarvis.PISTA3)
                elif opcion < 10:
                    self.actualizarDescripcion(Jarvis.PISTA4)
                else:
                    self.actualizarDescripcion(Jarvis.PISTA5)
            elif self.getValue(0) == 'historial':
                h = ''
                for linea in Individuo.getHistorial():
                    h += linea + '\n'
                self.actualizarDescripcion(h)
        #cheatss                    
        elif self._tituloCriterios == 'codigo': 
            if self.getValue(0) == '100':
                Robot.getRobots()[0].setUbicacion(Intruso.getIntrusos()[0].getUbicacion())
                self._objeto.batalla("CHEAT: TRAJISTE AL ROBOT A ESTA HABITACION.\n")
            elif self.getValue(0) == '300':
                Robot.getRobots()[0].setHealth(0)
                messagebox.showinfo(title="CHEAT", message="CHEAT: EL ROBOT SE AUTODESTRUYO.", detail="")
            elif self.getValue(0) == '400':
                Intruso.getIntrusos()[0].setHealth(0)
                messagebox.showinfo(title="CHEAT", message="CHEAT: FORZASTE GAME OVER.", detail="")
                self._objeto.derrota()
            elif self.getValue(0) == '500':
                messagebox.showinfo(title="CHEAT", message="CHEAT: FORZASTE LA VICTORIA.", detail="")
                self._objeto.victoria()
            elif self.getValue(0) == '600':
                Intruso.getIntrusos()[0].getUbicacion().setAlarma(Ahorro.ENCENDIDO)
                messagebox.showinfo(title="CHEAT", message="CHEAT: ACTIVASTE LA ALARMA.", detail="")
                self._objeto.moverte()
                    
        elif self._tituloCriterios == 'tu turno': 
            huir = False
            if self.getValue(0) == 'atacar':
                dados = Main.lanzarDados(5)
                if self.getValue(1) == 'ninguno' and dados >= Robot.getRobots()[0].getArmor():
                    Intruso.getIntrusos()[0].atacar(Robot.getRobots()[0])
                    m = "Le diste un puño al robot, probablemente te dolió mas a ti que a él.\nTe sobas la mano."
                elif self.getValue(1) == 'Martillo de Thor' and dados >= Robot.getRobots()[0].getArmor():
                    Intruso.getIntrusos()[0].atacar(Robot.getRobots()[0], Intruso.getIntrusos()[0].getWeaponInventory()[0].getBonusDamage())
                    m = "Atacaste al robot exitosamente"
                elif dados < Robot.getRobots()[0].getArmor():
                    m = "El Robot bloqueo tu ataque!"
            elif self.getValue(0) == 'bloquear':
                m = "Tomas una posición defensiva y te preparas para recibir el ataque"
                Intruso.getIntrusos()[0].setArmor(3)
            elif self.getValue(0) == 'usar':
                for o in  Intruso.getIntrusos()[0].getObjectInventory():
                    if o.getName() == self.getValue(1):
                        if o.isShocker():
                            o.usar(Robot.getRobots()[0])
                            m = "Aturdiste al robot."
                        else:
                            o.usar(Intruso.getIntrusos()[0])
                            m = "Recibiste la bonificacion del objeto seleccionado."
            elif self.getValue(0) == 'huir':
                if Intruso.getIntrusos()[0].getSpeed() + random.randint(1,5) >= 4:
                    huir = True
                    m = "Tu agilidad te permitió saltar fuera del combate."
                else:
                    m = "Intentas huir, pero el robot te cierra el paso, mas suerte la proxima vez."

            messagebox.showinfo(title="Ataque", message=m, detail="")

            if huir:
                self._objeto.moverte()
            elif Robot.getRobots()[0].getHealth() > 0:
                self._objeto.batalla()
            else:
                messagebox.showinfo(title="Combate", message="Destruiste al robot, ahora solo falta obtener la mascara.", detail="")
                self._objeto.moverte()


                
            


                
            
            
                