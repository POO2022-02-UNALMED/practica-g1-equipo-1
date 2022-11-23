import os.path
from tkinter import *
from tkinter import messagebox


window = Tk()
window.geometry('900x600')
window.title('Escape Room Game')
window.option_add('*tearOff', FALSE)


#Eventos ventana inicio
def info():
    frame_P3.pack_forget()
    label_P3.place_forget()
    label_inf = Label(master=frame_P3, wraplength= 340, justify= 'left',
          text="Te encuentras en la casa de Tony Stark y tu misión, si decides aceptarla, es conseguir la mascara de Ironman. Pero no creas que será tan sencillo, en tu recorrido tendrás diferentes obstáculos como objetos que te activarán alarmas, puertas con su acceso bloqueado y  un robot que te estará buscando constantemente.\r\n" + "Pero no todo es malo, encontrarás objetos útiles en algunas habitaciones y quizá tengas la ayuda de alguien o algo.\r\n" + "", font="Helvetica 10")
    label_inf.pack(expand=True,fill='both',padx=1,pady=1)
    frame_P3.pack(side=TOP, fill="both", expand=True, padx=5, pady=5)

def evento():
    window.deiconify()
    window.destroy()

def inicio():
    escape = Toplevel()
    escape.geometry('900x600')
    escape.title('CRM')
    window.iconify()
    escape.option_add('*tearOff', FALSE)  # Eliminar underline

    #ventana de usuario
    def ventanaInicio():
        window.deiconify()
        escape.destroy()

    def act():
        messagebox.showinfo(title="Nuestras funcionalidades",
                            message="cuadrar mensaje",
                            detail="")

    def evento():
        window.deiconify()
        window.destroy()

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

    def inf():
        messagebox.showinfo(title="Definir info",
                            message="definir inf",
                            detail="Universidad Nacional De Colombia")

    #Ventana usuario
    usuario = PanedWindow(master=escape, orient=VERTICAL)
    usuario.pack(fill=BOTH, expand=True)

    # ZONA 1
    zona1 = PanedWindow(master=usuario, orient=HORIZONTAL)
    zona1.pack(fill=BOTH, expand=True)
    usuario.add(zona1)

    # Botones de zona1
    archivo = Menubutton(zona1, text="Archivo", activebackground='lightblue')
    archivo.pack(side=LEFT)
    zona1.add(archivo)

    procesos = Menubutton(zona1, text="def text", activebackground='lightblue')
    procesos.pack(side=LEFT)
    zona1.add(procesos)

    ayuda = Menubutton(zona1, text="Ayuda", activebackground='lightblue')
    ayuda.pack(side=LEFT)
    zona1.add(ayuda)

    # Configurar menus
    archivo.menu = Menu(archivo, tearoff=0)
    archivo["menu"] = archivo.menu
    archivo.menu.add_command(label="Aplicación", command=act)
    archivo.menu.add_command(label="Volver a ventana de inicio", command=ventanaInicio)

    procesos.menu = Menu(procesos, tearoff=0)
    procesos["menu"] = procesos.menu
    procesos.menu.add_command(label="agregar", command=venta)
    procesos.menu.add_command(label="agregar", command=dev)
    procesos.menu.add_command(label="agregar", command=ejec_contra)
    procesos.menu.add_command(label="agregar", command=fin_contra)
    procesos.menu.add_command(label="agregar", command=masivo)

    ayuda.menu = Menu(ayuda, tearoff=0)
    ayuda["menu"] = ayuda.menu
    ayuda.menu.add_command(label="Acerca de", command=inf)

    # ZONA 2
    zona2 = PanedWindow(master=usuario, orient=VERTICAL)
    zona2.pack(fill=BOTH, expand=True)
    usuario.add(zona2)

    nombre_proceso = Label(zona2, text="cuadrar text")
    zona2.add(nombre_proceso)

    descripcion_proceso = Label(zona2, text="arreglar")
    zona2.add(descripcion_proceso)


#Eventos del ratón (Para cambiar hojas de vida)
def show_names(e):
    descripcion.pack_forget()
    label_aux.pack_forget()
    frame_P6.pack_forget()
    label_P5.pack(side=LEFT,anchor='n')
    nombres.pack()
    label_photo1['image'] = imgLuis1 
    label_photo2['image'] = imgLuis2
    label_photo3['image'] = imgLuis3
    label_photo4['image'] = imgLuis4
    frame_P6.pack()

    frame_P5.bind("<Button-1>", show_nombreIntegrante)

def show_nombreIntegrante(e):
    global descripcion
    global label_P5
    global label_aux
    nombres.pack_forget()
    label_P5.pack_forget()
    descripcion = Label(master=frame_P5, text='Estudiante de ...', font="Helvetica 12")
    descripcion.pack()
    label_aux = Label(master=frame_P5, text='\n Juan:', font="Helvetica 14",)
    label_aux.pack(side=LEFT,anchor='n') 

    frame_P6.pack_forget()
    label_photo1['image'] = imgLuis4
    label_photo2['image'] = imgLuis3
    label_photo3['image'] = imgLuis2
    label_photo4['image'] = imgLuis1
    frame_P6.pack()

    frame_P5.bind("<Button-1>", show_name2)

def show_name2(e):
    global descripcion
    global label_P5
    global label_aux
    descripcion.pack_forget()
    nombres.pack_forget()
    label_P5.pack_forget()
    label_aux.pack_forget()
    descripcion = Label(master=frame_P5, text="Estudiante de Ciencias ...", font="Helvetica 12")
    descripcion.pack()
    label_aux = Label(master=frame_P5, text='\n Juan Jose:', font="Helvetica 14",)
    label_aux.pack(side=LEFT,anchor='n') 

    frame_P6.pack_forget()
    label_photo1['image'] = imgLuis2
    label_photo2['image'] = imgLuis4
    label_photo3['image'] = imgLuis1
    label_photo4['image'] = imgLuis3
    frame_P6.pack()

    frame_P5.bind("<Button-1>", show_name3)

def show_name3(e):
    global descripcion
    global label_P5
    global label_aux
    descripcion.pack_forget()
    label_P5.pack_forget()
    label_aux.pack_forget()
    descripcion = Label(master=frame_P5, text="Estudiante de ...", font="Helvetica 12")
    descripcion.pack()
    label_aux = Label(master=frame_P5, text='\n Juan Manuel:', font="Helvetica 14",)
    label_aux.pack(side=LEFT,anchor='n') 

    frame_P6.pack_forget()
    label_photo1['image'] = imgLuis3
    label_photo2['image'] = imgLuis1
    label_photo3['image'] = imgLuis4
    label_photo4['image'] = imgLuis2
    frame_P6.pack()

    frame_P5.bind("<Button-1>", show_names)

# Eventos del ratón para cambiar imágenes en ventana inicio
def change_img2(e):
    #frame_P4.pack_forget()
    label_img['image'] = img2
    #frame_P4.pack(side=BOTTOM)
    label_img.bind('<Enter>', change_img3)

def change_img3(e):
    #frame_P4.pack_forget()
    label_img['image'] = img3
    #frame_P4.pack(side=BOTTOM)
    label_img.bind('<Enter>', change_img4)

def change_img4(e):
    #frame_P4.pack_forget()
    label_img['image'] = img4
    #frame_P4.pack(side=BOTTOM)
    label_img.bind('<Enter>', change_img5)

def change_img5(e):
    #frame_P4.pack_forget()
    label_img['image'] = img5
    #frame_P4.pack(side=BOTTOM)
    label_img.bind('<Enter>', change_img1)

def change_img1(e):
    #frame_P4.pack_forget()
    label_img['image'] = img1
    #frame_P4.pack(side=BOTTOM)
    label_img.bind('<Enter>', change_img2)

#Barra menu 

menubar = Menu(window)
menu1 = Menu(menubar)
menubar.add_cascade(menu=menu1, label='Inicio', command=evento)
menu1.add_command(label="Descripcion", command=info)
menu1.add_command(label="Salir de la aplicación", command=evento)
window['menu'] = menubar


# Ventana de inicio
outer_frame = Frame(window)
outer_frame.pack(side="top", fill="both", expand=True, padx=20, pady=20)

# ------- Frame principal P1 -------
frame_P1 = Frame(master=outer_frame, borderwidth=2, relief="groove")
frame_P1.pack(side='left', fill="both", expand=False, padx=5, pady=5)


# Frame anidado P3
frame_P3 = Frame(master=frame_P1, width=295, borderwidth=2, relief="groove")
label_P3 = Label(master=frame_P3,wraplength= 340, text='Te damos la Bienvenida a: \r\nEscape Room Game: Ironmans Mask', font="Helvetica 14")
frame_P3.pack(side=TOP, fill="both", expand=True, padx=5, pady=5)
label_P3.pack(expand=True,fill='both',padx=1,pady=5)


# Frame anidado P4
frame_P4 = Frame(master=frame_P1, borderwidth=2, relief="groove")
frame_P4.pack(side=BOTTOM, padx=5, pady=5)

# Cargar imágenes
img2 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/testing.png')
img2 = img2.subsample(2)
img3 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/testing2.png')
img3 = img3.subsample(2)
img4 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/testing3.png')
img4 = img4.subsample(2)
img5 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/testing.png')
img5 = img5.subsample(2)
img1 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/testing2.png')
img1 = img1.subsample(2)

imgLuis1 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/luis.png')
imgLuis1 = imgLuis1.subsample(2)
imgLuis2 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/luis2.png')
imgLuis2 = imgLuis2.subsample(2)
imgLuis3 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/luis3.png')
imgLuis3 = imgLuis3.subsample(2)
imgLuis4 = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/luis4.png')
imgLuis4 = imgLuis4.subsample(2)

label_img = Label(master=frame_P4)
label_img['image'] = img2
label_img.pack()

boton_ingreso = Button(master=frame_P4, text='Ingresar', font="Helvetica 14 bold", command=inicio)
boton_ingreso.pack(side=BOTTOM)

# Control del cursor para cambio en imagenes
label_img.bind("<Enter>", change_img2)


# ------- Frame principal P2 -------
frame_P2 = Frame(master=outer_frame, borderwidth=2, relief="groove")
frame_P2.pack(side='right', fill="both", expand=True, padx=5, pady=5)

# Frame anidado P5
frame_P5 = Frame(master=frame_P2, borderwidth=2, relief="groove")
frame_P5.pack(fill="both", expand=True, padx=5, pady=5)

# Nombre de cada integrante
label_P5 = Label(master=frame_P5, text='\n Luis Altamar:', font="Helvetica 14")
label_P5.pack(side=LEFT,anchor='n')
nombres = Label(master=frame_P5, text="Estudiante de Ing. de Sistemas \n4 semestre de avance \nProfesor de matematicas a medio tiempo", font="Helvetica 12", justify='left') #copiar y poner los nombres de cada uno con su pack
nombres.pack()


# Control del cursor para cambio en hojas de vida
frame_P5.bind("<Button-1>", show_nombreIntegrante)

# Frame anidado P6
frame_img = Frame(master=frame_P2, borderwidth=2, relief="groove")
frame_img.pack(fill="both", expand=True, padx=5, pady=5)
frame_P6 = Frame(master=frame_img)
frame_P6.pack()

# ----------- Posicionamiento Grid de fotos -----------
label_photo1 = Label(master=frame_P6)
label_photo1['image'] = imgLuis1
label_photo1.grid(row=0, column= 0, padx=5, pady=5)

label_photo2 = Label(master=frame_P6)
label_photo2['image'] = imgLuis2
label_photo2.grid(row=0, column= 1, padx=5, pady=5)

label_photo3 = Label(master=frame_P6)
label_photo3['image'] = imgLuis3
label_photo3.grid(row=1, column= 0, padx=5, pady=5)

label_photo4 = Label(master=frame_P6)
label_photo4['image'] = imgLuis4
label_photo4.grid(row=1, column= 1, padx=5, pady=5)

window.mainloop()