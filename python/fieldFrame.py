import os.path
from tkinter import *

class FieldFrame(Frame):

    
    def __init__(self, ventana, tituloCriterios = "", criterios = None, tituloValores = "", valores = None, habilitado = None):
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
        

        self.map = PhotoImage(file=f'{os.path.dirname(os.path.abspath(__file__))}/images/map.png')
        self.map = self.map.subsample(2)

        
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
            self.label_map['image'] = self.map
            self.label_map.grid(column=1, row=len(self._criterios)+1, padx = (10,10), pady = (10,10),sticky='nsew')   
        elif self._tituloCriterios == 'interaccion':
            labelanex= Label(self, text = 'Tu Inventario', font = ("Helvetica 14", 12),anchor=CENTER)
            labelanex.grid(column=0, row=len(self._criterios)+1, padx = (10,10), pady = (10,10),sticky='nsew')

            self.textInv = Text(master=self,width=20,height=5)
            self.textInv.grid(column=1, row=len(self._criterios)+1, padx = (10,10), pady = (10,10),sticky='nsew')
            self.textInv.insert('1.0','inventario')

        self.crearBotones(0,'Aceptar',None)
        self.crearBotones(1,'Borrar',self.borrar)


    def getValue(self, criterio):
        indice = self._criterios.index(criterio)
        return self._elementos[indice].get()
    
    def borrar(self):
        for e in self._elementos:
            e.delete(0,'end')

    def crearBotones(self, col, t, comando1):
        aceptar = Button(self, text=t, font = ("Helvetica 14", 12), fg = "white", bg = "#B1B1B1", command=comando1).grid(pady = 50, column = col, row = len(self._criterios)+2)
