
package escapeRun;
import java.util.Scanner;

public class Main {
    
    public static int lanzarDados(){//retorna un numero aleatorio del 1 al 5
        return (int) Math.floor(Math.random()*(5)+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int opcion; //aqui se guardan las opciones que va seleccionando el jugador
        boolean x = true; // variable temporal, mientras colocamos bien las condiciones
        Individuo iniciativa[] = new Individuo[2]; //organiza los turnos de combate
        
        System.out.println("Bienvenidos, Breve introduccion y tutorial aqui!!");
        System.out.println("\nPresiona cualquier tecla para comenzar");
        in.nextLine();
        
        //instancias de intruso y robot
        Intruso intruso = new Intruso();
        Robot robot = new Robot();
        
        //ciclo de turnos del jugador
        while (x){//COLOCAR CONDICION (hasta que gane o quede sin vida)
            
            System.out.println("Descripcion de la escena que ve");
            
            if(x){//COLOCAR CONDICION (si la ubicacion del jugador == ubicacion robot)
                System.out.println("El robot te ha encontrado! preparate para luchar!!");
                while(true){//COLOCAR COONDICION (hasta que la vida de alguno < 0, o el jugador logre escapar)
                    if(robot.getSpeed()+ Main.lanzarDados() > intruso.getSpeed()+ Main.lanzarDados()){//define el orden de turnos
                        iniciativa[0] = robot;
                        iniciativa[1] = intruso;
                    } else {
                        iniciativa[1] = robot;
                        iniciativa[0] = intruso;
                    }
                    for(int i = 0; i < 2; i++){
                        if(iniciativa[i].equals(intruso)){//acciones del jugador
                            System.out.println("Es tu turno:");
                            System.out.println("1. Atacar"
                                    + "\n2. Bloquear"
                                    + "\n3. Usar"
                                    + "\n4. Huir");
                            opcion = in.nextInt();
                            switch(opcion){
                                case 1://pregunta con que deseas atacar
                                    break;
                                case 2://aumenta tu armadura por un turno
                                    break;
                                case 3://utiliza un objeto especial
                                    break;
                                case 4://intentas huir del combate
                                    break;
                                default:
                                    break;
            }
                            
                        } else {//acciones del robot
                            //ataque normal, ataque cargado, stunear, quitar un objeto aleatorio
                        }
                    }
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
