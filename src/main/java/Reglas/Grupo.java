package Reglas;

import Reglas.Docente;
import Reglas.Estudiante;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Grupo {
private String materia;
private ArrayList<Estudiante> estudiantes;
private ArrayList<Docente> docentes;
private Date fechaVinculacion;

// Agregar un estudiante al grupo
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // Agregar un docente al grupo
    public void agregarDocente(Docente docente) {
        docentes.add(docente);
    }
    
    //constructores getter y setter

    public Grupo() {
    }

    public Grupo(String materia, ArrayList<Estudiante> estudiantes, ArrayList<Docente> docentes, Date fechaVinculacion) {
        this.materia = materia;
        this.estudiantes = estudiantes;
        this.docentes = docentes;
        this.fechaVinculacion = fechaVinculacion;
    }

    
    
    
    
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }


    
    
}
