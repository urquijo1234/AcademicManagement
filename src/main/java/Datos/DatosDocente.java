package Datos;

import Reglas.Docente;
import Reglas.Estudiante;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class DatosDocente {
    
    public DatosDocente() {
    }
    
    public int DeterminarLineas() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String sCadena;
        int NumeroLineas = 0;
        try {
            fileReader = new FileReader("Docente.txt");
            bufferedReader = new BufferedReader(fileReader);
            while ((sCadena = bufferedReader.readLine()) != null) {
                NumeroLineas++;
            }
        } catch (Exception exception) {
            NumeroLineas = 0;
        }
        return NumeroLineas;
    }
    
    public void grabarDocente(Docente pdocente) {
        FileWriter fileWriter;
        PrintWriter printWriter;
        try {
            fileWriter = new FileWriter("Docente.txt", true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(pdocente.getDocnombre());
            printWriter.println(pdocente.getDocapellido());
            printWriter.println(pdocente.getDocnumeroDocumento());
            printWriter.println(pdocente.getCiudadResidencia());
            printWriter.println(pdocente.getCorreo());
            printWriter.println(pdocente.getProfesion());
            printWriter.println(pdocente.getAñoInicioUniversidad());
            printWriter.println(pdocente.getAñoFinalizacionDocencia());
            fileWriter.close();
        } catch (Exception exception) {
        }
    }
    
    public Docente cargarDocente(int pNumeroDocente) {
        Docente rdocente;
        FileReader fileReader;
        BufferedReader bufferedReader;
        int i;
        rdocente = new Docente();
        try {
            fileReader = new FileReader("Docente.txt");
            bufferedReader = new BufferedReader(fileReader);
            try {
                i = 1;
                while (i <= pNumeroDocente) {
                    rdocente.setDocnombre(bufferedReader.readLine());
                    rdocente.setDocapellido(bufferedReader.readLine());
                    rdocente.setDocnumeroDocumento(bufferedReader.readLine());
                    rdocente.setCiudadResidencia(bufferedReader.readLine());
                    rdocente.setCorreo(bufferedReader.readLine());
                    rdocente.setProfesion(bufferedReader.readLine());
                    rdocente.setAñoInicioUniversidad(Integer.parseInt(bufferedReader.readLine()));
                    rdocente.setAñoFinalizacionDocencia(Integer.parseInt(bufferedReader.readLine()));                    
                    i++;
                }
            } catch (Exception exception) {
                rdocente = new Docente();
            }
            bufferedReader.close();
        } catch (Exception exception) {
        }
        return rdocente;
    }
    
}
