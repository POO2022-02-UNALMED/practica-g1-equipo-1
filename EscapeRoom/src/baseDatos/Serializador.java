package baseDatos;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import gestorAplicacion.clasesLogicas.*;
import gestorAplicacion.clasesLogicasHerencia.*;
public class Serializador {
	private static File rutaTemp = new File ("src\\baseDatos\\temp");
	public static void serializar () {
		FileOutputStream fos;
		ObjectOutputStream oos;
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
			if(file.getAbsolutePath().contains("Ahorro")){
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
				else if(file.getAbsolutePath().contains("Habitacion")) {
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
				else if(file.getAbsolutePath().contains("Individuo")) {
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
				else if(file.getAbsolutePath().contains("Intruso")) {
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
				else if(file.getAbsolutePath().contains("Robot")) {
					try {
						fos = new FileOutputStream(file);
						oos = new ObjectOutputStream(fos);
						oos.writeObject(Robot.getRobots());
						
						
					}catch(FileNotFoundException e){
						e.printStackTrace();
					}catch (IOException e) {
						e.printStackTrace();
					}
					
					
				
			}
			
	}
	
	
}
}