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

public class Deserializador {
	private static File rutaTemp = new File ("src\\baseDatos\\temp");
	public static void deserializar () {
		File[] docs = rutaTemp.listFiles();
		
		FileInputStream fis;
	    ObjectInputStream ois;
	
		
		
		
		for(File file:docs) {
			if(file.getAbsolutePath().contains("Ahorro")){
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
				
				
					
				}else if (file.getAbsolutePath().contains("Armas")){
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
					
					
				}else if (file.getAbsolutePath().contains("Habitacion")){
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
					
					
				}else if (file.getAbsolutePath().contains("Individuo")){
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
					
					
				}else if (file.getAbsolutePath().contains("Intruso")){
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
					
					
				}else if (file.getAbsolutePath().contains("Robot")){
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
				
			}
			
	}
	
	
	}
