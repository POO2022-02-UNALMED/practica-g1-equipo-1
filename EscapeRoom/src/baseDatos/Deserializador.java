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
					
					Ahorro.setAhorros((ArrayList<Ahorro>)ois.readObject());
										
					
				}catch(FileNotFoundException e){
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				
					
				}else if (file.getAbsolutePath().contains("alumnos")){
					try {
						fis = new FileInputStream(file);
						ois = new ObjectInputStream(fis);
						
						Departamento.setAlumnos((List<Alumno>)ois.readObject());
											
						
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
