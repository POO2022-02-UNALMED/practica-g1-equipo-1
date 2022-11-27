import os.path
from tkinter import *
from tkinter import messagebox
from fieldFrame import FieldFrame

from Intruso import Intruso
from Main import Main

class ventana2:

    def iniciarMenu(self):
        self.menuUsuario = Menu(self.window,relief=RAISED)
        self.archivo = Menu(self.menuUsuario,tearoff = 0)
        self.acciones = Menu(self.menuUsuario,tearoff = 0)
        self.ayuda = Menu(self.menuUsuario,tearoff=0)

        self.archivo.add_command(label="Aplicacion", command = self.aplicacion)
        self.archivo.add_command(label='Salir', command = self.cerrar)
        self.acciones.add_command(label='Moverte', command=self.moverte)
        self.acciones.add_command(label='Interactuar', command = self.interactuar)
        self.acciones.add_command(label='Hablar', command = self.hablar)
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
        self.detalles = Text(self.detallesFrame,bg='black',fg='white',font='console', wrap= 'word',relief='sunken',padx=0,pady=0)
        self.detalles.grid(row=0,column=0,sticky='nsew')
        self.detalles.insert('1.0',msj)
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

        Main.main()

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
        •
        •
        •
        •
        
        '''
        messagebox.showinfo(title="Acerca de", message=msj, detail="Universidad Nacional De Colombia")

    def moverte(self):
        self.titulo.set('Te vas a mover de Habitacion')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0',Intruso.getIntrusos[0].habitacionesDisponibles())
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'movimiento',['Habitaciones Disponibles','Habitaciones Bloqueadas','A donde te mueves?'],'valores',['1','2',''],None)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')
        self.fm2.grid_propagate(False)

    def interactuar(self):
        self.titulo.set('Vas a interactuar')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0','detalles interactuar aqui!')
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'interaccion',['Que deseas hacer?','Con que Objeto?'],'valores',['1','2'],None)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')
        self.fm2.grid_propagate(False)

    def hablar(self):
        self.titulo.set('Vas a hablar con J.A.R.V.I.S.')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0','detalles hablar aqui!')
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'criterios',['Obtener informacion de:'],'valores',['1'],None)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')
        self.fm2.grid_propagate(False)

    def cheats(self):
        self.titulo.set('Ingresa tus CHEATS')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0','detalles cheats aqui!')
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'criterios',['Ingrese su codigo'],'valores',['1'],None)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')
        self.fm2.grid_propagate(False)

    def batalla(self):
        self.titulo.set('Estas en Combate')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0','detalles combate aqui!')
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'criterios',['Que desea hacer?','Seleccione un objeto'],'valores',['1','2'],None)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')
        self.fm2.grid_propagate(False)

    def getFm2(self):
        return self.fm2

    
        

if __name__ == '__main__':
    prueba = ventana2()