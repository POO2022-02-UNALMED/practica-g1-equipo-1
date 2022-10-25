package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import gestorAplicacion.clasesLogicas.*;
import gestorAplicacion.clasesLogicasHerencia.*;
import java.util.ArrayList;

public class Deserializador {
	//private static File rutaTemp = new File ("src\\baseDatos\\temp");
	public static <E> void deserializar (ArrayList<E> lista,String name) {
		//File[] docs = rutaTemp.listFiles();
		
		FileInputStream fis;
                try {
			String tempPath = System.getProperty("user.dir") + "/src/baseDatos/temp/" + name + ".txt";
			fis = new FileInputStream(tempPath);
			ObjectInputStream in = new ObjectInputStream(fis);
			ArrayList<E> listaNueva = (ArrayList<E>) in.readObject();
			
			for (E elemento : listaNueva) {
				lista.add(elemento);
			}
			in.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			//System.out.println("El archivo está vacío");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	        //ObjectInputStream ois;
		
                /*for(File file:docs) {
                if(file.getAbsolutePath().contains("ahorros")){
                try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                
                Ahorro.setAhorros((List<Ahorro>)ois.readObject());
                
                
                }catch(FileNotFoundException e){
                e.printStackTrace();
                }catch (IOException e) {
                e.printStackTrace();
                }catch(ClassNotFoundException e) {
                e.printStackTrace();
                }
                
                
                
                }else if (file.getAbsolutePath().contains("armas")){
                try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                
                Armas.setArmas((List<Armas>)ois.readObject());
                
                
                }catch(FileNotFoundException e){
                e.printStackTrace();
                }catch (IOException e) {
                e.printStackTrace();
                }catch(ClassNotFoundException e) {
                e.printStackTrace();
                }
                
                
                }else if (file.getAbsolutePath().contains("habitaciones")){
                try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                
                Habitacion.setHabitaciones((List<Habitacion>)ois.readObject());
                
                
                }catch(FileNotFoundException e){
                e.printStackTrace();
                }catch (IOException e) {
                e.printStackTrace();
                }catch(ClassNotFoundException e) {
                e.printStackTrace();
                }
                
                
                }else if (file.getAbsolutePath().contains("individuos")){
                try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                
                Individuo.setIndividuos((List<Individuo>)ois.readObject());
                
                
                }catch(FileNotFoundException e){
                e.printStackTrace();
                }catch (IOException e) {
                e.printStackTrace();
                }catch(ClassNotFoundException e) {
                e.printStackTrace();
                }
                
                
                }else if (file.getAbsolutePath().contains("intrusos")){
                try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                
                Intruso.setIntrusos((List<Intruso>)ois.readObject());
                
                
                }catch(FileNotFoundException e){
                e.printStackTrace();
                }catch (IOException e) {
                e.printStackTrace();
                }catch(ClassNotFoundException e) {
                e.printStackTrace();
                }
                
                
                }else if (file.getAbsolutePath().contains("robots")){
                try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                
                Robot.setRobots((List<Robot>)ois.readObject());
                
                
                }catch(FileNotFoundException e){
                e.printStackTrace();
                }catch (IOException e) {
                e.printStackTrace();
                }catch(ClassNotFoundException e) {
                e.printStackTrace();
                }
                
                
                }
                
                }*/
			
	}
        
        public static void deserializarDatos(){
            Deserializador.deserializar(Habitacion.getHabitaciones(), "Habitacion");
		Deserializador.deserializar(Armas.getArmas(), "Armas");
		Deserializador.deserializar(Intruso.getIntrusos(), "Intruso");
		Deserializador.deserializar(Robot.getRobots(), "Robot");
		Deserializador.deserializar(Objetos.getObjetos(), "Objetos");
        }
	
	
	}
