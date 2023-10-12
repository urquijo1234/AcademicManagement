package Datos;

import Reglas.Docente;
import Reglas.Grupo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DatosGrupo {

    public DatosGrupo() {
    }
 public int DeterminarLineas() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String sCadena;
        int NumeroLineas = 0;
        try {
            fileReader = new FileReader("Grupo.txt");
            bufferedReader = new BufferedReader(fileReader);
            while ((sCadena = bufferedReader.readLine()) != null) {
                NumeroLineas++;
            }
        } catch (Exception exception) {
            NumeroLineas = 0;
        }
        return NumeroLineas;
    } 
public void grabarGrupo(Grupo pgrupo) {
        FileWriter fileWriter;
        PrintWriter printWriter;
        try {
            fileWriter = new FileWriter("Grupo.txt", true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(pgrupo.getMateria());
            printWriter.println(pgrupo.getEstudiantes());
            printWriter.println(pgrupo.getDocentes());
            printWriter.println(pgrupo.getFechaVinculacion());  
            fileWriter.close();
        } catch (Exception exception) {
        }
    }    
 public Grupo cargarGrupo(int pNumeroGrupo) {
        Grupo rgrupo;
        FileReader fileReader;
        BufferedReader bufferedReader;
        int i;
        rgrupo = new Grupo();
        try {
            fileReader = new FileReader("Grupo.txt");
            bufferedReader = new BufferedReader(fileReader);
            try {
                i = 1;
                while (i <= pNumeroGrupo) {
                    rgrupo.setMateria(bufferedReader.readLine());
//                    rgrupo.setEstudiantes(bufferedReader.readLine());
//                    rgrupo.setDocentes(bufferedReader.readLine());
//                    rgrupo.setFechaVinculacion(bufferedReader.readLine());                    
                    i++;
                }
            } catch (Exception exception) {
                rgrupo = new Grupo();
            }
            bufferedReader.close();
        } catch (Exception exception) {
        }
        return rgrupo;
    }   
    
    
}
