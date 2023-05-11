/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class Alumno {
private String nombre;

    public String getNombre() {
        return nombre;
    }
private List<Materias> materias;

    public List<Materias> getMaterias() {
        return materias;
    }

public Alumno(String nombre){
    this.nombre= nombre;
    this.materias= new ArrayList<Materias>();
}
public void agregarMaterias(Materias materia){
    this.materias.add(materia);
}

}
