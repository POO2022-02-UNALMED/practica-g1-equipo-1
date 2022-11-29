import os.path
import random
from tkinter import *
from tkinter import messagebox
from fieldFrame import FieldFrame

from Intruso import Intruso
from Robot import Robot
from Bot import Bot

from Main import Main

class ventana2:

    Main().__init__()
    _regulador = False

    def iniciarMenu(self):
        self.menuUsuario = Menu(self.window,relief=RAISED)
        self.archivo = Menu(self.menuUsuario,tearoff = 0)
        self.acciones = Menu(self.menuUsuario,tearoff = 0)
        self.ayuda = Menu(self.menuUsuario,tearoff=0)

        self.archivo.add_command(label="Aplicacion", command = self.aplicacion)
        self.archivo.add_command(label='Salir', command = self.cerrar)
        self.acciones.add_command(label='Moverte', command=self.moverte)
        self.acciones.add_command(label='Interactuar', command = self.interactuar)
        self.acciones.add_command(label='Hablar con Jarvis', command = self.hablar)
        self.acciones.add_command(label='Cheats', command= self.cheats)
        self.ayuda.add_command(label='Acerca de', command=self.acercaDe)

        self.menuUsuario.add_cascade(label='Archivo',menu=self.archivo)
        self.menuUsuario.add_cascade(label='Acciones',menu=self.acciones)
        self.menuUsuario.add_cascade(label='Ayuda',menu=self.ayuda)

        self.window.config(menu=self.menuUsuario)

    def iniciarFrames(self):
        self.tituloFrame = Frame(self.window,relief='groove',pady=2)
        self.tituloFrame.grid(row=0, column=0,columnspan=4, sticky='nsew')

        self.detallesFrame = Frame(self.window)
        self.detallesFrame.grid(row=1,column=1,columnspan=2,sticky='nsew')
        self.detallesFrame.grid_propagate(False)
        self.detallesFrame.grid_columnconfigure(0,weight=1)
        self.detallesFrame.grid_columnconfigure(1,weight=0)

        self.fm2 = Frame(self.window, bg='blue')
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew',ipadx=0,ipady=0)

        self.titulo = StringVar() 
        self.titulo.set('La Aventura Ha Comenzado')
        Label(self.tituloFrame, textvariable=self.titulo, font=("Courier", 20),relief='solid',pady=2).pack(expand=True)
        self.field = Label(master = self.fm2, text='Field frame here',  bg="blue",  fg="white", font=("Courier", 20))
        self.field.pack(expand=True)
        
        msj='''Tu objetivo es obtener un objeto (la máscara de Iron Man) en una casa de 3x3 habitaciones mientras un robot vigilante intenta capturarte. 
Cuando hayas logrado robar la máscara de Iron Man o cuando tu vida llegue cero termina el juego (ganas o pierdes respectivamente).
Buena Suerte!'''
        self.detalles = Text(self.detallesFrame,bg='black',fg='white',font='console', wrap= 'word',relief='sunken', height=6,padx=0,pady=0)
        self.detalles.grid(row=0,column=0,sticky='nsew')
        self.detalles.insert('1.0',msj)
        ys = Scrollbar(self.detallesFrame, orient = 'vertical', command = self.detalles.yview)
        self.detalles['yscrollcommand'] = ys.set
        self.detalles.__setitem__('state','disabled')

    def __init__(self):
        self.window = Tk()
        self.window.geometry('900x600')
        self.window.title('Escape Room Game')
        self.window.option_add('*tearOff', FALSE)
        self.window.grid_rowconfigure(0, weight=1, uniform="rows_g1")
        self.window.grid_rowconfigure(1, weight=4, uniform="rows_g1")
        self.window.grid_rowconfigure(2, weight=12, uniform="rows_g1")
        self.window.grid_columnconfigure(0, weight = 1, uniform="cols_g1")
        self.window.grid_columnconfigure(1, weight=5,  uniform="cols_g1")
        self.window.grid_columnconfigure(2, weight=5,  uniform="cols_g1")
        self.window.grid_columnconfigure(3, weight=1,  uniform="cols_g1")
        self.iniciarMenu()
        self.iniciarFrames()

        self.window.mainloop()
        

    def cerrar(self):
        from ventana_inicio import ventana1
        self.window.destroy()
        continuar = ventana1()

    def aplicacion(self):
        msj = '''Acciones:

Moverte:
• Puedes cambiar de ubicación a otra habitación disponible seleccionando el numero de la habitación.

Interactuar:
• Desbloquear: desbloquea una habitación adyacente (si tienes la llave en tu inventario).
• Recoger: recoge todos los objetos de la habitación actual.
• Curar: eliges el objeto con el cual deseas curar tu salud y te curas.
• Romper luces: rompes las luces de la habitación actual (requiere un arma).

Hablar con Jarvis:
• Habitacion i: dependiendo la habitación que le pidas te muestra cuantos objetos hay en la habitación y si tu o el robot están ahí.
• Robot: te muestra en que habitación esta el robot, sus puntos de vida y si nota o no tu presencia.
• Apagar luces: Las luces de la habitación se apagan.
• Pista: te muestra una pista aleatoria.
• Historial: te muestra el historial de movimientos

En Batalla:
• Atacar: atacas al robot con o sin armas.
• Bloquear: obtienes una bonificación de armadura hasta tu siguiente turno.
• Usar: usas un objeto de tu inventario, ya sea para aturdir al robot, bloquear o para curarte.
• Huir: tienes una probabilidad para terminar el combate y continuar con el juego.

CHEATS: esto nos ayudara a probar ciertas funcionalidades
• 100: fuerza batalla con robot
• 300: el robot se autodestruye
• 400: fuerzas la derrota
• 500: fuerzas la victoria
• 600: activas la alarma'''
        
        messagebox.showinfo(title="Manual de Usuario", message=msj, detail="")

    def acercaDe(self):
        msj = '''Desarrolladores:
        •Luis Altamar Romero
        •Juan Pablo Gómez
        •Juan Manuel Ortiz
        •
        •
        
        '''
        messagebox.showinfo(title="Acerca de", message=msj, detail="Universidad Nacional De Colombia")

    def moverte(self):
        self.titulo.set('Te vas a mover de Habitacion')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0',Intruso.getIntrusos()[0].ayudaJarvis())
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'movimiento',['Habitaciones Disponibles','Habitaciones Bloqueadas','A donde te mueves?'],'valores',[Intruso.getIntrusos()[0].habitacionesDisponibles()[0],Intruso.getIntrusos()[0].habitacionesDisponibles()[1],''],[False,False,True],self)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=2, sticky='nsew')
        self.fm2.grid_propagate(False)

    def interactuar(self):
        self.titulo.set('Vas a interactuar')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0',Intruso.getIntrusos()[0].ayudaJarvis())
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'interaccion',['Que deseas hacer?','Con que Objeto?'],'valores',['','ninguno'],None,self)
        self.field.pack(expand=True)
        
        self.fm2.grid(row=2, column=2, sticky='nsew')
        # self.fm2.grid_columnconfigure(0, weight=1)
        # self.fm2.grid_propagate(False)

    def hablar(self):
        self.titulo.set('Vas a hablar con J.A.R.V.I.S.')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0',"Tus habilidades en Hacking te permiten tomar control de la IA Jarvis..." + "\nJ.A.R.V.I.S.: ¿En qué te puedo asistir?")
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'criterios',['Obtener informacion de:'],'valores',['pista'],None,self)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=2 ,sticky='nsew')
        self.fm2.grid_propagate(False)

    def cheats(self):
        self.titulo.set('Ingresa tus CHEATS')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0','Espacio de Pruebas (SOLO DESARROLLADORES)')
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'codigo',['Ingrese su codigo'],'valores',[''],None,self)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=2, sticky='nsew')
        self.fm2.grid_propagate(False)

    def batalla(self,s = ''):
        self.titulo.set('Estas en Combate')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0', s + 'El robot te ha encontrado! preparate para luchar!!')
        x = True
        d = True
        while x:
            print('while')
            self.detalles.insert('end',"\nTienes " + str(Intruso.getIntrusos()[0].getHealth()) + " puntos de vida.")
            self.detalles.insert('end',"\nEl robot tiene " + str(Robot.getRobots()[0].getHealth()) + " puntos de vida.")
            iniciativa = [None for _ in range(2)]

            #iniciativa
            if ventana2._regulador:
                print('regulador')
                iniciativa[0] = Robot.getRobots()[0]
            else:
                print('iniciativa')
                if Robot.getRobots()[0].getSpeed() + random.randint(1,5) > Intruso.getIntrusos()[0].getSpeed() + random.randint(1,5):
                    print('robot primero')
                    iniciativa[0] = Robot.getRobots()[0]
                    iniciativa[1] = Intruso.getIntrusos()[0]
                else:
                    print('intruso primero')
                    iniciativa[1] = Robot.getRobots()[0]
                    iniciativa[0] = Intruso.getIntrusos()[0]
                    ventana2._regulador = True

            #turnos
            for i in range(0, 2):
                print('turnos')
                if iniciativa[i] is Intruso.getIntrusos()[0]:
                    print('intruso')
                    self.detalles.insert('end',"\nEs tu turno:")
                    if Intruso.getIntrusos()[0].isStunned():
                        self.detalles.insert('end',"\nEstas aturdido, no puedes moverte")
                        Intruso.getIntrusos()[0].stun(False)
                    else:
                        x = False
                        break
                else:
                    print('robot')
                    self.detalles.insert('end',"\nEs el turno del robot:")
                    if Robot.getRobots()[0].isStunned():
                        self.detalles.insert('end',"\nEl robot esta aturdido, no puede hacer nada.")
                        Robot.getRobots()[0].stun(False)
                    else:
                        if Robot.getRobots()[0].isCargaRobot():
                            desicionRobot = 100
                            self.detalles.insert('end','\n'+Robot.getRobots()[0].ataqueCargado(Intruso.getIntrusos()[0]))
                        else:
                            desicionRobot = random.randint(1,10)
                            self.detalles.insert('end','\n'+Robot.getRobots()[0].turno(desicionRobot, Intruso.getIntrusos()[0]))
                            self.detalles.insert('end','\n'+Robot.getRobots()[1].turno(desicionRobot, Intruso.getIntrusos()[0]))
                            Robot.getRobots()[1].atacar(Intruso.getIntrusos()[0])
                            self.detalles.insert('end','\n'+"El bot revolotea te estorba en la batalla")
                        Intruso.getIntrusos()[0].setArmor(0)
                        if Intruso.getIntrusos()[0].getHealth() <= 0:
                            self.derrota()
                            d = False
                        if ventana2._regulador:
                            break
                        ventana2._regulador = False
        #self.detalles.__setitem__('state','disabled')
        if d:
            self.field.pack_forget()
            self.fm2.pack_forget()
            self.field = FieldFrame(self.fm2,'tu turno',['Que desea hacer?','Seleccione un objeto'],'valores',['','ninguno'],None,self)
            self.field.pack(expand=True)
            self.fm2.grid(row=2, column=2, sticky='nsew')
            self.fm2.grid_propagate(False)
    
    def victoria(self):
        self.titulo.set('VICTORIA')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0',"Despues de un arduo trabajo conseguiste lo que buscabas, la mascara de Ironman te permitio abrir un hueco en la pared y huir." + "\nPor fin podras añadir esto a tu mesa de trofeos, tu proximo objetivo: La Capa de Dr Strange... pero eso sera en otra ocasion." + "\nBuen trabajo y Gracias por Jugar!!!")
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = Label(master = self.fm2, text='PANTALLA DE VICTORIA',  bg="blue",  fg="white", font=("Courier", 20))
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')
        self.fm2.grid_propagate(False)
        

    def derrota(self):
        self.titulo.set('GAME OVER')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0',"Todo se volvio negro, y cuando abriste los ojos te encontraste en una celda de maxima seguridad." + "\nParece que estaras aqui por un buen tiempo." + "\nFin del Juego.")
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = Label(master = self.fm2, text='PANTALLA DE GAME OVER',  bg="blue",  fg="white", font=("Courier", 20))
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=2, sticky='nsew')
        self.fm2.grid_propagate(False)

    def getFm2(self):
        return self.fm2

    
        

if __name__ == '__main__':
    prueba = ventana2()
