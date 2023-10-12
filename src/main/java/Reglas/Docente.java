package Reglas;
public class Docente {
 private String docnombre;
    private String docapellido;
    private String docnumeroDocumento;
    private String ciudadResidencia;
    private String correo;
    private String profesion;
    private int añoInicioUniversidad;
    private int añoFinalizacionDocencia;
   //constructores, setter getter y toString

    public Docente() {
    }

    public Docente(String docnombre, String docapellido, String docnumeroDocumento, String ciudadResidencia, String correo, String profesion, int añoInicioUniversidad, int añoFinalizacionDocencia) {
        this.docnombre = docnombre;
        this.docapellido = docapellido;
        this.docnumeroDocumento = docnumeroDocumento;
        this.ciudadResidencia = ciudadResidencia;
        this.correo = correo;
        this.profesion = profesion;
        this.añoInicioUniversidad = añoInicioUniversidad;
        
    }
    

    public String getDocnombre() {
        return docnombre;
    }

    public void setDocnombre(String docnombre) {
        this.docnombre = docnombre;
    }

    public String getDocapellido() {
        return docapellido;
    }

    public void setDocapellido(String docapellido) {
        this.docapellido = docapellido;
    }

    public String getDocnumeroDocumento() {
        return docnumeroDocumento;
    }

    public void setDocnumeroDocumento(String docnumeroDocumento) {
        this.docnumeroDocumento = docnumeroDocumento;
    }



    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getAñoInicioUniversidad() {
        return añoInicioUniversidad;
    }

    public void setAñoInicioUniversidad(int añoInicioUniversidad) {
        this.añoInicioUniversidad = añoInicioUniversidad;
    }

    public int getAñoFinalizacionDocencia() {
        return añoFinalizacionDocencia;
    }

    public void setAñoFinalizacionDocencia(int añoFinalizacionDocencia) {
        this.añoFinalizacionDocencia = añoFinalizacionDocencia;
    }

 @Override
     public String toString() {
        return "Nombre: " + docnombre + "\n" +
               "Apellido: " + docapellido + "\n" +
               "Número de Documento: " + docnumeroDocumento + "\n" +
               "Ciudad de Residencia: " + ciudadResidencia + "\n" +
               "Correo Electrónico: " + correo + "\n" +
               "Profesión: " + profesion + "\n" +
               "Año de Inicio en la Universidad: " + añoInicioUniversidad;
    }

    
    
}
