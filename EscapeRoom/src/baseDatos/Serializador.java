package baseDatos;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import gestorAplicacion.clasesLogicas.*;
import gestorAplicacion.clasesLogicasHerencia.*;
import java.util.ArrayList;

public class Serializador {
	//private static File rutaTemp = new File ("src\\baseDatos\\temp");
	public static <E> void serializar (ArrayList<E> lista,String name) {
            FileOutputStream fos;
            
            try {
			String tempPath = System.getProperty("user.dir") + "/src/baseDatos/temp/" + name + ".txt";
			fos = new FileOutputStream(tempPath);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(lista);
			
			out.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
            
            /*ObjectOutputStream oos;
            File[] docs  = rutaTemp.listFiles();
            PrintWriter pw;
            
            
            for(File file : docs) {
            try {
            pw  = new PrintWriter(file);
            
            
            }catch (FileNotFoundException e) {
            e.printStackTrace();
            }
            
            
            
            }
            for(File file:docs) {
            if(file.getAbsolutePath().contains("ahorros")){
            try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Ahorro.getAhorros());
            
            
            }catch(FileNotFoundException e){
            e.printStackTrace();
            }catch (IOException e) {
            e.printStackTrace();
            }
            
            }else if(file.getAbsolutePath().contains("Armas")) {
            try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Armas.getArmas());
            
            
            }catch(FileNotFoundException e){
            e.printStackTrace();
            }catch (IOException e) {
            e.printStackTrace();
            }
            
            
            }
            else if(file.getAbsolutePath().contains("habitaciones")) {
            try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Habitacion.getHabitaciones());
            
            
            }catch(FileNotFoundException e){
            e.printStackTrace();
            }catch (IOException e) {
            e.printStackTrace();
            }
            
            
            
            }
            else if(file.getAbsolutePath().contains("individuos")) {
            try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Individuo.getIndividuos());
            
            
            }catch(FileNotFoundException e){
            e.printStackTrace();
            }catch (IOException e) {
            e.printStackTrace();
            }
            
            
            
            }
            else if(file.getAbsolutePath().contains("intrusos")) {
            try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Intruso.getIntrusos());
            
            
            }catch(FileNotFoundException e){
            e.printStackTrace();
            }catch (IOException e) {
            e.printStackTrace();
            }
            
            
            
            }
            else if(file.getAbsolutePath().contains("robots")) {
            try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Robot.getRobots());
            
            
            }catch(FileNotFoundException e){
            e.printStackTrace();
            }catch (IOException e) {
            e.printStackTrace();
            }
            
            
            */
        }
        
        public static void serializarDatos(){
                Serializador.serializar(Habitacion.getHabitaciones(), "Habitacion");
		Serializador.serializar(Armas.getArmas(), "Armas");
		Serializador.serializar(Intruso.getIntrusos(), "Intruso");
		Serializador.serializar(Robot.getRobots(), "Robot");
		Serializador.serializar(Objetos.getObjetos(), "Objetos");
        }
			
	}
	
	
