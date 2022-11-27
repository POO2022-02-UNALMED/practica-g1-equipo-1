import os.path
from tkinter import *
from tkinter import messagebox
from ventana_usuario import ventana2

class ventana1:

    def __init__(self):
        self.window = Tk()
        self.window.geometry('900x600')
        self.window.title('Escape Room Game')
        self.window.option_add('*tearOff', FALSE)

#Barra menu 
        self.menubar = Menu(self.window)
        self.menu1 = Menu(self.menubar)
        self.menubar.add_cascade(menu=self.menu1, label='Inicio')
        self.menu1.add_command(label="Descripcion", command=self.info)
        self.menu1.add_command(label="Salir de la aplicación", command=self.evento)
        self.window['menu'] = self.menubar

# Ventana de inicio
        self.outer_frame = Frame(self.window)
        self.outer_frame.pack(side="top", fill="both", expand=True, padx=20, pady=20)

        # ------- Frame principal P1 -------
        self.frame_P1 = Frame(master=self.outer_frame, borderwidth=2, relief="groove")
        self.frame_P1.pack(side='left', fill="both", expand=False, padx=5, pady=5)


# Frame anidado P3
        self.frame_P3 = Frame(master=self.frame_P1, width=295, borderwidth=2, relief="groove")
        self.label_P3 = Label(master=self.frame_P3,wraplength= 340, text='Te damos la Bienvenida a: \r\nEscape Room Game: Ironmans Mask', font="Helvetica 14")
        self.frame_P3.pack(side=TOP, fill="both", expand=True, padx=5, pady=5)
        self.label_P3.pack(expand=True,fill='both',padx=1,pady=5)


# Frame anidado P4
        self.frame_P4 = Frame(master=self.frame_P1, borderwidth=2, relief="groove")
        self.frame_P4.pack(side=BOTTOM, padx=5, pady=5)

# Cargar imágenes
        self.img2 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/testing.png')
        self.img2 = self.img2.subsample(2)
        self.img3 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/testing2.png')
        self.img3 = self.img3.subsample(2)
        self.img4 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/testing3.png')
        self.img4 = self.img4.subsample(2)
        self.img5 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/testing.png')
        self.img5 = self.img5.subsample(2)
        self.img1 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/testing2.png')
        self.img1 = self.img1.subsample(2)

        self.imgLuis1 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/luis.png')
        self.imgLuis1 = self.imgLuis1.subsample(2)
        self.imgLuis2 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/luis2.png')
        self.imgLuis2 = self.imgLuis2.subsample(2)
        self.imgLuis3 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/luis3.png')
        self.imgLuis3 = self.imgLuis3.subsample(2)
        self.imgLuis4 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/luis4.png')
        self.imgLuis4 = self.imgLuis4.subsample(2)

        self.label_img = Label(master=self.frame_P4)
        self.label_img['image'] = self.img2
        self.label_img.pack()

        boton_ingreso = Button(master=self.frame_P4, text='Ingresar', font="Helvetica 14 bold", command=self.inicio)
        boton_ingreso.pack(side=BOTTOM)

# Control del cursor para cambio en imagenes
        self.label_img.bind("<Enter>", self.change_img2)


# ------- Frame principal P2 -------
        self.frame_P2 = Frame(master=self.outer_frame, borderwidth=2, relief="groove")
        self.frame_P2.pack(side='right', fill="both", expand=True, padx=5, pady=5)

# Frame anidado P5
        self.frame_P5 = Frame(master=self.frame_P2, borderwidth=2, relief="groove",bg="#D3D3D3")
        self.frame_P5.pack(fill="both", expand=True, padx=5, pady=5)

# Nombre de cada integrante
        self.label_P5 = Label(master=self.frame_P5, text='Luis Altamar:', font="Helvetica 14")
        self.label_P5.bind("<Button-1>", self.show_nombreIntegrante)
        self.label_P5.pack(side=LEFT,anchor='w', padx=5)
        self.nombres = Label(master=self.frame_P5, text="Estudiante de Ing. de Sistemas \n4 semestre de avance \nProfesor de matematicas a medio tiempo", font="Helvetica 12", justify='left') #copiar y poner los nombres de cada uno con su pack
        self.nombres.bind("<Button-1>", self.show_nombreIntegrante)
        self.nombres.pack(pady=5)


# Control del cursor para cambio en hojas de vida
        self.frame_P5.bind("<Button-1>", self.show_nombreIntegrante)

# Frame anidado P6
        self.frame_img = Frame(master=self.frame_P2, borderwidth=2, relief="groove")
        self.frame_img.pack(fill="both", expand=True, padx=5, pady=5)
        self.frame_P6 = Frame(master=self.frame_img)
        self.frame_P6.pack()

# ----------- Posicionamiento Grid de fotos -----------
        self.label_photo1 = Label(master=self.frame_P6)
        self.label_photo1['image'] = self.imgLuis1
        self.label_photo1.grid(row=0, column= 0, padx=5, pady=5)

        self.label_photo2 = Label(master=self.frame_P6)
        self.label_photo2['image'] = self.imgLuis2
        self.label_photo2.grid(row=0, column= 1, padx=5, pady=5)

        self.label_photo3 = Label(master=self.frame_P6)
        self.label_photo3['image'] = self.imgLuis3
        self.label_photo3.grid(row=1, column= 0, padx=5, pady=5)

        self.label_photo4 = Label(master=self.frame_P6)
        self.label_photo4['image'] = self.imgLuis4
        self.label_photo4.grid(row=1, column= 1, padx=5, pady=5)

        self.window.mainloop()
    


#Eventos ventana inicio
    def info(self):
        self.frame_P3.pack_forget()
        self.label_P3.place_forget()
        self.label_inf = Label(master=self.frame_P3, wraplength= 340, justify= 'left',
              text="Te encuentras en la casa de Tony Stark y tu misión, si decides aceptarla, es conseguir la mascara de Ironman. Pero no creas que será tan sencillo, en tu recorrido tendrás diferentes obstáculos como objetos que te activarán alarmas, puertas con su acceso bloqueado y  un robot que te estará buscando constantemente.\r\n" + "Pero no todo es malo, encontrarás objetos útiles en algunas habitaciones y quizá tengas la ayuda de alguien o algo.\r\n" + "", font="Helvetica 10")
        self.label_inf.pack(expand=True,fill='both',padx=1,pady=1)
        self.frame_P3.pack(side=TOP, fill="both", expand=True, padx=5, pady=5)

    def evento(self):
        self.window.deiconify()
        self.window.destroy()

    def inicio(self):
        self.window.destroy()
        self.usuario = ventana2()
        
    #escape = Toplevel()
    #escape.geometry('900x600')
    #escape.title('Escape room game')
    #window.iconify()
    #escape.option_add('*tearOff', FALSE)  # Eliminar underline

    #ventana de usuario
    def ventanaInicio(self):
       # window.deiconify()
        self.usuario.cerrar()

    #def act():
     #   messagebox.showinfo(title="Nuestras funcionalidades",
      #                      message="cuadrar mensaje",
       #                     detail="")

    def evento(self):
        self.window.deiconify()
        self.window.destroy()

    def venta():
        pass

    def dev():
        pass

    def ejec_contra():
        pass

    def fin_contra():
        pass

    def masivo():
        pass

    #def inf():
    #    messagebox.showinfo(title="Definir info",
    #                        message="definir inf",
    #                        detail="Universidad Nacional De Colombia")

    #Ventana usuario
    #usuario = PanedWindow(master=escape, orient=VERTICAL)
    #usuario.pack(fill=BOTH, expand=True)

    # ZONA 1
    #zona1 = PanedWindow(master=usuario, orient=HORIZONTAL, )
    #zona1.pack(fill=BOTH, expand=True)
    #usuario.add(zona1)

    # Botones de zona1
    #archivo = Menubutton(zona1, text="Archivo", activebackground='lightblue')
    #archivo.pack(side=LEFT,expand=False)
    #zona1.add(archivo)

    #procesos = Menubutton(zona1, text="Procesos y consultas", activebackground='lightblue')
    #procesos.pack(side=LEFT,expand=False)
    #zona1.add(procesos)

    #ayuda = Menubutton(zona1, text="Ayuda", activebackground='lightblue',)
    #ayuda.pack(side=LEFT,expand=False)
    #zona1.add(ayuda)

    # Configurar menus
    #archivo.menu = Menu(archivo, tearoff=0)
    #archivo["menu"] = archivo.menu
    #archivo.menu.add_command(label="Aplicación", command=act)
    #archivo.menu.add_command(label="Volver a ventana de inicio", command=ventanaInicio)

    #procesos.menu = Menu(procesos, tearoff=0)
    #procesos["menu"] = procesos.menu
    #procesos.menu.add_command(label="agregar", command=venta)
    #procesos.menu.add_command(label="agregar", command=dev)
    #procesos.menu.add_command(label="agregar", command=ejec_contra)
    #procesos.menu.add_command(label="agregar", command=fin_contra)
    #procesos.menu.add_command(label="agregar", command=masivo)

    #ayuda.menu = Menu(ayuda, tearoff=0)
    #ayuda["menu"] = ayuda.menu
    #ayuda.menu.add_command(label="Acerca de", command=inf)

    # ZONA 2
    #zona2 = PanedWindow(master=usuario, orient=VERTICAL)
    #zona2.pack(fill=BOTH, expand=True)
    #usuario.add(zona2)

    #nombre_proceso = Label(zona2, text="cuadrar text")
    #zona2.add(nombre_proceso)

    #descripcion_proceso = Label(zona2, text="arreglar")
    #zona2.add(descripcion_proceso)


#Eventos del ratón (Para cambiar hojas de vida)
    def show_names(self,e):
        self.descripcion.pack_forget()
        self.label_aux.pack_forget()
        self.frame_P6.pack_forget()
        self.label_P5.pack(side=LEFT,anchor='w',padx=5)
        self.nombres.pack(pady=5)
        self.label_photo1['image'] = self.imgLuis1 
        self.label_photo2['image'] = self.imgLuis2
        self.label_photo3['image'] = self.imgLuis3
        self.label_photo4['image'] = self.imgLuis4
        self.frame_P6.pack()

        self.frame_P5.bind("<Button-1>", self.show_nombreIntegrante)

    def show_nombreIntegrante(self,e):
        #global self.descripcion
        #global self.label_P5
        #global self.label_aux
        self.nombres.pack_forget()
        self.label_P5.pack_forget()
        self.label_aux = Label(master=self.frame_P5, text='Juan Pablo:', font="Helvetica 14")
        self.label_aux.bind("<Button-1>", self.show_name2)
        self.label_aux.pack(side=LEFT,anchor='w',padx=5)
        self.descripcion = Label(master=self.frame_P5, text='Estudiante de Ing. de Sistemas', font="Helvetica 12")
        self.descripcion.bind("<Button-1>", self.show_name2) 
        self.descripcion.pack(pady=5)
        

        self.frame_P6.pack_forget()
        self.label_photo1['image'] = self.imgLuis4
        self.label_photo2['image'] = self.imgLuis3
        self.label_photo3['image'] = self.imgLuis2
        self.label_photo4['image'] = self.imgLuis1
        self.frame_P6.pack()

        self.frame_P5.bind("<Button-1>", self.show_name2)

    def show_name2(self,e):
        #global descripcion
        #global label_P5
        #global label_aux
        self.descripcion.pack_forget()
        self.nombres.pack_forget()
        self.label_P5.pack_forget()
        self.label_aux.pack_forget()
        self.label_aux = Label(master=self.frame_P5, text='Juan Jose:', font="Helvetica 14",)
        self.label_aux.bind("<Button-1>", self.show_name3)
        self.label_aux.pack(side=LEFT,anchor='w',padx=5) 
        self.descripcion = Label(master=self.frame_P5, text="Estudiante de Ciencias ...", font="Helvetica 12")
        self.descripcion.bind("<Button-1>", self.show_name3)
        self.descripcion.pack(pady=5)

        self.frame_P6.pack_forget()
        self.label_photo1['image'] = self.imgLuis2
        self.label_photo2['image'] = self.imgLuis4
        self.label_photo3['image'] = self.imgLuis1
        self.label_photo4['image'] = self.imgLuis3
        self.frame_P6.pack()

        self.frame_P5.bind("<Button-1>", self.show_name3)

    def show_name3(self,e):
        #global descripcion
        #global label_P5
        #global label_aux
        self.descripcion.pack_forget()
        self.label_P5.pack_forget()
        self.label_aux.pack_forget()
        self.label_aux = Label(master=self.frame_P5, text='Juan Manuel:', font="Helvetica 14",)
        self.label_aux.bind("<Button-1>", self.show_name4)
        self.label_aux.pack(side=LEFT,anchor='w',padx=5)
        self.descripcion = Label(master=self.frame_P5, text="Estudiante de Ing. de Sistemas", font="Helvetica 12")
        self.descripcion.bind("<Button-1>", self.show_name4)
        self.descripcion.pack(pady=5)

        self.frame_P6.pack_forget()
        self.label_photo1['image'] = self.imgLuis3
        self.label_photo2['image'] = self.imgLuis1
        self.label_photo3['image'] = self.imgLuis4
        self.label_photo4['image'] = self.imgLuis2
        self.frame_P6.pack()

        self.frame_P5.bind("<Button-1>", self.show_name4)

    def show_name4(self,e):
        #global descripcion
        #global label_P5
        #global label_aux
        self.descripcion.pack_forget()
        self.nombres.pack_forget()
        self.label_P5.pack_forget()
        self.label_aux.pack_forget()
        self.label_aux = Label(master=self.frame_P5, text='Santiago:', font="Helvetica 14",)
        self.label_aux.bind("<Button-1>", self.show_names)
        self.label_aux.pack(side=LEFT,anchor='w',padx=5)
        self.descripcion = Label(master=self.frame_P5, text="Estudiante de Ciencias ...", font="Helvetica 12")
        self.descripcion.bind("<Button-1>", self.show_names)
        self.descripcion.pack(pady=5)

        self.frame_P6.pack_forget()
        self.label_photo1['image'] = self.imgLuis2
        self.label_photo2['image'] = self.imgLuis4
        self.label_photo3['image'] = self.imgLuis1
        self.label_photo4['image'] = self.imgLuis3
        self.frame_P6.pack()

        self.frame_P5.bind("<Button-1>", self.show_names)      

# Eventos del ratón para cambiar imágenes en ventana inicio
    def change_img2(self,e):
    #frame_P4.pack_forget()
        self.label_img['image'] = self.img2
    #frame_P4.pack(side=BOTTOM)
        self.label_img.bind('<Enter>', self.change_img3)

    def change_img3(self,e):
    #frame_P4.pack_forget()
        self.label_img['image'] = self.img3
    #frame_P4.pack(side=BOTTOM)
        self.label_img.bind('<Enter>', self.change_img4)

    def change_img4(self,e):
    #frame_P4.pack_forget()
        self.label_img['image'] = self.img4
    #frame_P4.pack(side=BOTTOM)
        self.label_img.bind('<Enter>', self.change_img5)

    def change_img5(self,e):
    #frame_P4.pack_forget()
        self.label_img['image'] = self.img5
    #frame_P4.pack(side=BOTTOM)
        self.label_img.bind('<Enter>',self.change_img1)

    def change_img1(self,e):
    #frame_P4.pack_forget()
        self.label_img['image'] = self.img1
    #frame_P4.pack(side=BOTTOM)
        self.label_img.bind('<Enter>', self.change_img2)



    
if __name__ == '__main__':
    prueba = ventana1()



