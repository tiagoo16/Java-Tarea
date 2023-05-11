import Clases.Alumno;
import Clases.Materias;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Tiago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Creamos el scanner
        Scanner sc= new Scanner(System.in);
        
        //Creamos 5 Materias
        List<Materias> materias= new ArrayList<Materias>();
        for(int i=1;i<=5;i++){
            System.out.print("Ingrese el nombre de la materia "+ i+ ": ");
            String lectormaterias= sc.nextLine();
            materias.add(new Materias(lectormaterias));
            
        }
         //Creamos 3 Alumnos y agregamos las 5 materias
        List<Alumno> alumnos= new ArrayList<Alumno>();
        for(int i=1;i<=3;i++){
            System.out.print("Ingrese el nombre del alumno "+ i+ ": ");
            String lectoralumno= sc.nextLine();
            
            Alumno alumno= new Alumno(lectoralumno);
            for(Materias materia : materias){
                System.out.println("Ingrese la calificacion del alumno "+ i+ " en "+ materia.getNombre()+": ");
                int calificacion= Integer.parseInt(sc.nextLine());
                materia.setCalificacion(calificacion);
                alumno.agregarMaterias(materia);
            }
            alumnos.add(alumno);
        }
        //Guardamos los datos en un archivo de texto
        try{
            PrintWriter writer= new PrintWriter("datos.txt","UTF-8");
            for(Alumno alumno : alumnos){
                writer.println(alumno.getNombre());
                for(Materias materia: alumno.getMaterias()){
                    writer.print(materia.getNombre()+": "+ materia.getCalificacion()+"\t");
                }
                writer.println();
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Error al guardaar los datos en el archivo");
        }
        //Mostrar los datos por pantalla
        try{
            Scanner archivo= new Scanner(new File("datos.txt"));
            while(archivo.hasNextLine()){
                System.out.println(archivo.nextLine());
            }
            archivo.close();
            
        }catch(FileNotFoundException e){
            System.out.println();
        }
        File file= new File("datos.txt");
        System.out.println("El archivo se encuentra en la siguiente ruta: "+ file.getAbsolutePath()
        );
         
     
    }
    
}
