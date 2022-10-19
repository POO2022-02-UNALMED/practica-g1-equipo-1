
package escapeRun;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int opcion; //aqui se guardan las opciones que va seleccionando el jugador
        boolean x = true; // variable temporal, mientras colocamos bien las condiciones
        
        System.out.println("Bienvenidos, Breve introduccion y tutorial aqui!!");
        System.out.println("\nPresiona cualquier tecla para comenzar");
        in.nextLine();
        
        //ciclo de turnos del jugador
        while (x){//COLOCAR CONDICION (hasta que gane o quede sin vida)
            
            System.out.println("Descripcion de la escena que ve");
            
            if(x){//COLOCAR CONDICION (si la ubicacion del jugador == ubicacion robot)
                System.out.println("El robot te ha encontrado! preparate para luchar!!");
                while(true){//COLOCAR COONDICION (hasta que la vida de alguno < 0, o el jugador logre escapar)
                    
                }
            }
            
            System.out.println("¿Que deseas hacer?:"
                    + "\n1. Moverte"
                    + "\n2. Interactuar"
                    + "\n3. Hablar con Jarvis");
            opcion = in.nextInt();
            switch(opcion){//aqui se implementan las diferentes funcionalidades
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
        
        //mensajes finales
        if(x){
            System.out.println("mensaje de Ganaste y descripcion del final");
        } else {
            System.out.println("mensaje de perdiste");
        }
        

    }
    
}
