package Reglas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Estudiante {
 private String nombre;
    private String apellido;
    private String numeroDocumento;
    private String lugarResidencia;
    private String correoElectronico;
    private String numeroTelefono;
    private Date fechaNacimiento;
    private String universidad;
    private int materiasRepetidas;
    private int pagosRealizados;


public static Date parseFecha(String fechaStr) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha = formatoFecha.parse(fechaStr);
            return fecha;
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Manejo de errores
        }
    }    
  //constructores, getter y setter y toString 

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String numeroDocumento, String lugarResidencia, String correoElectronico, String numeroTelefono, Date fechaNacimiento, String universidad, int materiasRepetidas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
        this.lugarResidencia = lugarResidencia;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.fechaNacimiento = fechaNacimiento;
        this.universidad = universidad;
        this.materiasRepetidas = materiasRepetidas;
        this.pagosRealizados=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public int getMateriasRepetidas() {
        return materiasRepetidas;
    }

    public void setMateriasRepetidas(int materiasRepetidas) {
        this.materiasRepetidas = materiasRepetidas;
    }

    public int getPagosRealizados() {
        return pagosRealizados;
    }

    public void setPagosRealizados(int pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }
    
    public void incrementarPagosRealizados() {
    pagosRealizados++;
}

    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Apellido: " + apellido + "\n" +
               "Número de Documento: " + numeroDocumento + "\n" +
               "Lugar de Residencia: " + lugarResidencia + "\n" +
               "Correo Electrónico: " + correoElectronico + "\n" +
               "Número de Teléfono: " + numeroTelefono + "\n" +
               "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
               "Universidad: " + universidad;
    }
   

    
         
           
}
