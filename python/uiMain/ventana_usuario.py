import os.path
from tkinter import *
from tkinter import messagebox
from fieldFrame import FieldFrame

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
        self.tituloFrame = Frame(self.window, bg='red')
        self.tituloFrame.grid(row=0, column=0,columnspan=4, sticky='nsew')

        self.detallesFrame = Frame(self.window)
        self.detallesFrame.grid(row=1,column=1,columnspan=2,sticky='nsew')
        self.detallesFrame.grid_propagate(False)
        self.detallesFrame.grid_columnconfigure(0,weight=1)
        self.detallesFrame.grid_columnconfigure(1,weight=0)

        self.fm2 = Frame(self.window, bg='blue')
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew',ipadx=0,ipady=0)

        self.titulo = StringVar() 
        self.titulo.set('NOMBRE DEL PROCESO')
        Label(self.tituloFrame, textvariable=self.titulo,  bg="red",  fg="white", font=("Courier", 20)).pack(expand=True)
        self.field = Label(master = self.fm2, text='Field frame here',  bg="blue",  fg="white", font=("Courier", 20))
        self.field.pack(expand=True)

        self.detalles = Text(self.detallesFrame,bg='black',fg='white',font='console',padx=0,pady=0)
        self.detalles.grid(row=0,column=0,sticky='nsew')
        self.detalles.insert('1.0',"descripciones aqui!!!")
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
        messagebox.showinfo(title="Nuestras funcionalidades", message="cuadrar mensaje", detail="")

    def acercaDe(self):
        messagebox.showinfo(title="Definir info", message="definir inf", detail="Universidad Nacional De Colombia")

    def moverte(self):
        self.titulo.set('Te vas a mover de Habitacion')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0','detalles movimiento aqui!')
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'criterios',['1','2'],'valores',['1','2'],None)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')

    def interactuar(self):
        self.titulo.set('Vas a interactuar')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0','detalles interactuar aqui!')
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'criterios',['interactuar','2'],'valores',['1','2'],None)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')

    def hablar(self):
        self.titulo.set('Vas a hablar con J.A.R.V.I.S.')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0','detalles hablar aqui!')
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'criterios',['hablarr','2'],'valores',['1','2'],None)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')

    def cheats(self):
        self.titulo.set('Ingresa tus CHEATS')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0','detalles cheats aqui!')
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'criterios',['cheats','2'],'valores',['1','2'],None)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')

    def batalla(self):
        self.titulo.set('Estas en Combate')

        self.detalles.__setitem__('state','normal')
        self.detalles.delete('1.0','end-1c')
        self.detalles.insert('1.0','detalles combate aqui!')
        self.detalles.__setitem__('state','disabled')

        self.field.pack_forget()
        self.fm2.pack_forget()
        self.field = FieldFrame(self.fm2,'criterios',['peleaa','2'],'valores',['1','2'],None)
        self.field.pack(expand=True)
        self.fm2.grid(row=2, column=1,columnspan=2, sticky='nsew')

    def getFm2(self):
        return self.fm2


#class FieldFrame(Frame):
 #   def __init__(self):
  #      super().__init__(master = ventana2.getFm2)
   #     self.detalles = Text(bg='white',font='console').grid(row = 0, column=0,columnspan=2,sticky='nsew')
        

    
        

if __name__ == '__main__':
    prueba = ventana2()
