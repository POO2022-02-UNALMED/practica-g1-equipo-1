
package escapeRun;
import java.util.Scanner;

public class Main {
    
    public static int lanzarDados(int caras){//retorna un numero aleatorio del 1 a caras
        return (int) Math.floor(Math.random()*(caras)+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int opcion; //aqui se guardan las opciones que va seleccionando el jugador
        boolean x = true; // variable temporal, mientras colocamos bien las condiciones
        Individuo iniciativa[] = new Individuo[2]; //organiza los turnos de combate
        boolean cargaRobot = false; //se utiliza para el ataque cargado del robot
        int desicionRobot; //se utiliza para el turno de robot en la pelea
        
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
                    if(robot.getSpeed()+ Main.lanzarDados(5) > intruso.getSpeed()+ Main.lanzarDados(5)){//define el orden de turnos
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
                                case 1:
                                    System.out.println("¿Con que desea atacar?");
                                    System.out.println("1. A puñetazos");
                                    int j = 2;
                                    for (Herramientas inventory : intruso.getInventory()){//muestra en pantalla las armas que tiene en inventario
                                        System.out.println(j + ". " + inventory.getName());
                                        j++;
                                    }
                                    opcion = in.nextInt();
                                    if (opcion == 1 && Main.lanzarDados(5) >= robot.getArmor()){
                                        intruso.atacar(robot);//ataca a punetazos
                                        System.out.println("Le diste un puño al robot, probablemente te dolió mas a ti que a él.");
                                        System.out.println("Te sobas la mano.");
                                    } else if (Main.lanzarDados(5) >= robot.getArmor()) {
                                        intruso.atacar(robot, intruso.getInventory().get(opcion-2).getBonusDamage());//ataca + el bonus del arma 
                                    } else {
                                        System.out.println("El Robot bloqueo tu ataque!");//hay una probabilidad de que el robot bloquee
                                    }
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
                            System.out.println("Es el turno del robot:");
                            if (cargaRobot){//ataque cargado
                                desicionRobot = 100;//esta linea evita que haga otra cosa en el turno
                                if (Main.lanzarDados(5) >= intruso.getArmor()){
                                    robot.atacar(intruso);
                                    robot.atacar(intruso);
                                    robot.atacar(intruso);
                                    System.out.println("El robot lanza un poderoso laser hacia ti!!");   
                                } else {
                                    System.out.println("El robot lanza un poderoso laser hacia ti! Por suerte, logras esquivarlo");   
                                }
                                cargaRobot = false;
                            } else {
                                desicionRobot = Main.lanzarDados(10);
                            }
                            //ataque normal 
                            if (desicionRobot < 6){//del 1 al 5 ataque normal
                                if (Main.lanzarDados(5) >= intruso.getArmor()){
                                    robot.atacar(intruso);
                                } else {
                                    System.out.println("Bloqueaste el golpe del robot");
                                }
                                
                            } else if (desicionRobot == 6 || desicionRobot == 7) {// 6 o 7 recarga de ataque cargado
                                cargaRobot = true;
                                System.out.println("El pecho del robot comienza a brillar con fuerza");
                            } else if (desicionRobot == 8 || desicionRobot == 9){//8 o 9 stunear
                                
                            } else if (desicionRobot == 10) {//10 roba un objeto
                                //robar objeto
                            }
                            
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
