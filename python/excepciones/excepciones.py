class ErrorAplicacion(Exception):
    _e = ""
    
    def __init__(self):
        super().__init__("Manejo de errores de la Aplicación: " + self._e)

    @classmethod
    def setE(cls,e):
        cls._e = e
        
    

class ExcepcionC1(ErrorAplicacion):
    def __init__(self, e):
        super().setE(e)
        super().__init__()
        


class ExcepcionC2(ErrorAplicacion):
    def __init__(self, e):
        super().setE(e)
        super().__init__()
        

class ExcepcionObjetos(ExcepcionC1): #Salta cuando usas un objeto que no sirve para la interaccion que deseas (usar una llave para combate por ejemplo)
    def __init__(self):
        super().__init__("Este objeto no sirve para eso. Por favor seleccione otro.")


class ExcepcionInventario(ExcepcionC1): #Salta cuando deseas acceder a un objeto que aun no tienes en el inventario
    def __init__(self):
        super().__init__("Este objeto no existe o no esta en tu inventario.")

class ErrorTipoDeDato(ExcepcionC1): #ingresas un tipo de dato diferente al que se te pide
    def __init__(self):
        super().__init__("Tipo de dato no valido. Por favor intente de nuevo.")

class ExcepcionMovimiento(ExcepcionC2): #te intentas mover a una habitacion no disponible
    def __init__(self):
        super().__init__("Esta habitacion no existe o no esta disponible.")

class OpcionInvalida(ExcepcionC2): #seleccionas una opcion no valida en el menu
    def __init__(self):
        super().__init__("No puedes hacer esto.")

class CamposFaltantes(ExcepcionC2): #no llenaste todos los campos necesarios
    def __init__(self):
        super().__init__("Aun faltan campos por llenar.")