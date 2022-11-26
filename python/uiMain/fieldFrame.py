from tkinter import *

class FieldFrame(Frame):

    
    def __init__(self, ventana, tituloCriterios = "", criterios = None, tituloValores = "", valores = None, habilitado = None):
        super().__init__(ventana)
        self.pack(expand=True,fill='both')
        self._tituloCriterios = tituloCriterios
        self._criterios = criterios
        self._tituloValores = tituloValores
        self._valores = valores
        self._habilitado = habilitado

        
        self._elementos = [] #Array elementos

        #titulo de criterios
        labelTituCrite = Label(self, text = tituloCriterios, font= ("Helvetica 14", 14))
        labelTituCrite.grid(column=0, row=0, padx = (10,10), pady = (10,10))

        #colocar titulo de los valores
        labelTituVal = Label(self, text = tituloValores, font= ("Helvetica 14", 14))
        labelTituVal.grid(column=1, row=0, padx = (10,10), pady = (10,10))

        #crea los criterios
        for  i in range(len(criterios)):
            labelCriterio = Label(self, text = criterios[i], font = ("Helvetica 14", 12))
            labelCriterio.grid(column=0, row=i+1, padx = (10,10), pady = (10,10))

            entryValor = Entry(self, font = ("Helvetica 14", 12))
            entryValor.grid(column=1, row=i+1, padx = (10,10), pady = (10,10))

            #poner valor inicial
            if valores is not None:
                entryValor.insert(0, valores[i])

            #deshabilitar si es no editable
            if habilitado is not None and not habilitado[i]:
                entryValor.configure(state = DISABLED)
        
            self._elementos.append(entryValor)

    def getValue(self, criterio):
        indice = self._criterios.index(criterio)
        return self._elementos[indice].get()

    def crearBotones(self, comando1):
        aceptar = Button(self, text="Aceptar", font = ("Helvetica 14", 12), fg = "white", bg = "#245efd", command=comando1).grid(pady = 50, column = 0, row = len(self._criterios)+1)
