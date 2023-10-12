package Datos;

import Reglas.Estudiante;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class DatosEstudiante {

    public DatosEstudiante() {
    }

    public int DeterminarLineas() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String sCadena;
        int NumeroLineas = 0;
        try {
            fileReader = new FileReader("Estudiante.txt");
            bufferedReader = new BufferedReader(fileReader);
            while ((sCadena = bufferedReader.readLine()) != null) {
                NumeroLineas++;
            }
        } catch (Exception exception) {
            NumeroLineas = 0;
        }
        return NumeroLineas;
    }

    public void grabarEstudiante(Estudiante pestudiante) {
        FileWriter fileWriter;
        PrintWriter printWriter;
        try {
            fileWriter = new FileWriter("Estudiante.txt", true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(pestudiante.getNombre());
            printWriter.println(pestudiante.getApellido());
            printWriter.println(pestudiante.getNumeroDocumento());
            printWriter.println(pestudiante.getLugarResidencia());
            printWriter.println(pestudiante.getCorreoElectronico());
            printWriter.println(pestudiante.getNumeroTelefono());
            printWriter.println(pestudiante.getFechaNacimiento());
            printWriter.println(pestudiante.getUniversidad());
            printWriter.println(pestudiante.getMateriasRepetidas());
            printWriter.println(pestudiante.getPagosRealizados());
            fileWriter.close();
        } catch (Exception exception) {
        }
    }

    public Estudiante cargarEstudiante(int pNumeroEstudiante) {
        Estudiante restudiante;
        FileReader fileReader;
        BufferedReader bufferedReader;
        int i;
        restudiante = new Estudiante();
        try {
            fileReader = new FileReader("Estudiante.txt");
            bufferedReader = new BufferedReader(fileReader);
            try {
                i = 1;
                while (i <= pNumeroEstudiante) {

                    restudiante.setNombre(bufferedReader.readLine());
                    restudiante.setApellido(bufferedReader.readLine());
                    restudiante.setNumeroDocumento(bufferedReader.readLine());
                    restudiante.setLugarResidencia(bufferedReader.readLine());
                    restudiante.setCorreoElectronico(bufferedReader.readLine());
                    restudiante.setNumeroTelefono(bufferedReader.readLine());
                    // Conversión de la fecha de nacimiento
                    String fechaNacimientoStr = bufferedReader.readLine();
                    Date fechaNacimiento = Estudiante.parseFecha(fechaNacimientoStr);
                    restudiante.setFechaNacimiento(fechaNacimiento);
                    restudiante.setUniversidad(bufferedReader.readLine());
                    restudiante.setMateriasRepetidas(Integer.parseInt(bufferedReader.readLine()));
                    restudiante.setPagosRealizados(Integer.parseInt(bufferedReader.readLine()));
                    i++;
                }
            } catch (Exception exception) {
                restudiante = new Estudiante();
            }
            bufferedReader.close();
        } catch (Exception exception) {
        }
        return restudiante;
    }

}
