package Vista;

import Datos.DatosDocente;
import Datos.DatosEstudiante;
import Reglas.Grupo;
import Reglas.Docente;
import Reglas.Estudiante;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class main {

    static ArrayList<Estudiante> est = new ArrayList<>();
    static ArrayList<Docente> doc = new ArrayList<>();
    static ArrayList<Grupo> grupos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            // Menú principal
            String opcionStr = JOptionPane.showInputDialog(
                    "Bienvenido a este maravilloso software Academico: \n"
                    + "1. Ingresar datos de los estudiantes\n"
                    + "2. Ingresar datos de los docentes\n"
                    + "3. Ver datos ingresados\n"
                    + "4. Crear Grupo\n"
                    + "5. Ver grupo\n"
                    + "6.Hacer Pago\n"
                    + "7.salir\n (se borraran los datos)");
            opcion = Integer.parseInt(opcionStr);
            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String apellido = JOptionPane.showInputDialog("Apellido:");
                    String numeroDocumento = JOptionPane.showInputDialog("Número de documento:");
                    String lugarResidencia = JOptionPane.showInputDialog("Lugar de residencia:");
                    String correoElectronico = JOptionPane.showInputDialog("Correo Electrónico:");
                    String numeroTelefono = JOptionPane.showInputDialog("Número de Teléfono:");
                    String fechaNacimientoStr = JOptionPane.showInputDialog("Fecha de Nacimiento (yyyy-MM-dd):");
                    Date fechaNacimiento = Estudiante.parseFecha(fechaNacimientoStr);
                    String universidad = JOptionPane.showInputDialog("Universidad:");
                    int materiasRepetidas = JOptionPane.showConfirmDialog(null, "Ha repetido Materias (Análisis y Diseño de Sistemas, paradigmas de programación, lógica de programación ó matemática básica)", "Confirmacion", JOptionPane.YES_NO_OPTION);
                    String materiasRepetidasStr = "";
                    if (materiasRepetidas == JOptionPane.YES_OPTION) {
                        materiasRepetidasStr = JOptionPane.showInputDialog(null, "Cuales materias repitio");
                    }
                    Estudiante estudatos = new Estudiante(nombre, apellido, numeroDocumento, lugarResidencia, correoElectronico, numeroTelefono, fechaNacimiento, universidad, materiasRepetidas);
                    est.add(estudatos);
                    //Invocacion de los metodos .txt
                    DatosEstudiante controladorestudiante = new DatosEstudiante();
                    controladorestudiante.grabarEstudiante(estudatos);
                    String datosestudiantecase1 = estudatos.toString();
                    String mensaje = "Los datos del estudiante son los siguientes: \n" + datosestudiantecase1 + "\nMaterias Repetidas: " + materiasRepetidasStr;
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
//                    
                case 2:
                    String docnombre = JOptionPane.showInputDialog(null, "nombre: ");
                    String docapellido = JOptionPane.showInputDialog(null, "apellido: ");
                    String docnumeroDocumento = JOptionPane.showInputDialog(null, "documento: ");
                    String ciudadResidencia = JOptionPane.showInputDialog(null, "ciudad de residencia: ");
                    String correo = JOptionPane.showInputDialog(null, "Correo institucional del docente");
                    String profesion = JOptionPane.showInputDialog(null, "Profesion del docente");
                    int añoInicioUniversidad = Integer.parseInt(JOptionPane.showInputDialog(null, "año de inicio en la universidad :"));
                    int añoFinalizacionDocencia = JOptionPane.showConfirmDialog(null, "¿El docente ya finalizo su docencia?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                    String añoFinalStr = "";
                    if (añoFinalizacionDocencia == JOptionPane.YES_OPTION) {
                        añoFinalStr = JOptionPane.showInputDialog(null, "En que año finalizo su docencia: ");
                    }
                    Docente docentedatos = new Docente(docnombre, docapellido, docnumeroDocumento, ciudadResidencia, correo, profesion, añoInicioUniversidad, añoFinalizacionDocencia);
                    doc.add(docentedatos);
                    DatosDocente controladordocente = new DatosDocente();
                    controladordocente.grabarDocente(docentedatos);
                    String datosdocentecase2 = docentedatos.toString();
                    String mensajedoc = "Los datos del docente son los siguientes: \n" + datosdocentecase2 + "\nAño finalizacion de labores " + añoFinalStr;
                    JOptionPane.showMessageDialog(null, mensajedoc);
                    break;

                case 3:
                    // Ver datos ingresados (estudiantes o docentes)
                    String tipoDatoStr = JOptionPane.showInputDialog(
                            "¿Qué tipo de datos quieres ver?\n"
                            + "1. Estudiantes\n"
                            + "2. Docentes\n"
                    );
                    int tipoDato = Integer.parseInt(tipoDatoStr);

                    if (tipoDato == 1) {
                        // Mostrar datos de estudiantes
                        // Puedes usar un bucle y JOptionPane para mostrar los datos de cada estudiante
                        for (Estudiante estudiante : est) {
                            String datosEstudiante = estudiante.toString();
                            JOptionPane.showMessageDialog(null, "Datos del estudiante:\n" + datosEstudiante);
                        }
                    } else if (tipoDato == 2) {
                        // Mostrar datos de docentes
                        // Puedes usar un bucle y JOptionPane para mostrar los datos de cada docente
                        for (Docente docente : doc) {
                            String datosDocente = docente.toString();
                            JOptionPane.showMessageDialog(null, "Datos del docente:\n" + datosDocente);
                        }
                    }
                    break;
                case 4:
                    // Crear Grupo
                    String materia = JOptionPane.showInputDialog("Ingrese el nombre de la materia:");

                    // Crear un nuevo grupo para la materia
                    Grupo nuevoGrupo = new Grupo(materia, new ArrayList<>(), new ArrayList<>(), new Date());

                    // Asignar estudiantes a este grupo
                    int numEstudiantes = est.size();
                    String[] estudiantesDisponibles = new String[numEstudiantes];
                    for (int i = 0; i < numEstudiantes; i++) {
                        estudiantesDisponibles[i] = est.get(i).getNombre();
                    }
                    int estudianteSeleccionado = -1; // Inicializamos con un valor que no tenga significado

                    if (numEstudiantes > 0) {
                        estudianteSeleccionado = JOptionPane.showOptionDialog(null,
                                "Seleccione el estudiante a asignar al grupo:",
                                "Asignar Estudiante",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                estudiantesDisponibles,
                                estudiantesDisponibles[0]);
                    }

                    if (estudianteSeleccionado >= 0) {
                        // Agregar el estudiante al grupo
                        nuevoGrupo.agregarEstudiante(est.get(estudianteSeleccionado));
                    }

                    // Asignar docentes a este grupo
                    int numDocentes = doc.size();
                    String[] docentesDisponibles = new String[numDocentes];
                    for (int i = 0; i < numDocentes; i++) {
                        docentesDisponibles[i] = doc.get(i).getDocnombre();
                    }
                    int docenteSeleccionado = -1; // Inicializamos con un valor que no tenga significado

                    if (numDocentes > 0) {
                        docenteSeleccionado = JOptionPane.showOptionDialog(null,
                                "Seleccione el docente a asignar al grupo:",
                                "Asignar Docente",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                docentesDisponibles,
                                docentesDisponibles[0]);
                    }

                    if (docenteSeleccionado >= 0) {
                        // Agregar el docente al grupo
                        nuevoGrupo.agregarDocente(doc.get(docenteSeleccionado));
                    }

                    // Agregar el grupo a la lista de grupos
                    grupos.add(nuevoGrupo);

                    JOptionPane.showMessageDialog(null, "Grupo creado y asignaciones realizadas.");
                    break;
                case 5:
                    // Ver Grupo
                    if (grupos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay grupos creados.");
                    } else {
                        JTextArea textArea = new JTextArea(20, 50); // Crear un JTextArea con 20 filas y 50 columnas
                        textArea.setEditable(false); // Hacer que el JTextArea sea de solo lectura

                        for (Grupo grupo : grupos) {
                            textArea.append("Materia: " + grupo.getMateria() + "\n");
                            textArea.append("Fecha de Vinculación: " + grupo.getFechaVinculacion() + "\n");
                            textArea.append("Estudiantes Asignados:\n");

                            for (Estudiante estudiante : grupo.getEstudiantes()) {
                                textArea.append("- " + estudiante.getNombre() + "\n");
                            }

                            textArea.append("Docentes Asignados:\n");

                            for (Docente docente : grupo.getDocentes()) {
                                textArea.append("- " + docente.getDocnombre() + "\n");
                            }

                            textArea.append("\n");
                        }

                        JScrollPane scrollPane = new JScrollPane(textArea); // Agregar un JScrollPane al JTextArea
                        JOptionPane.showMessageDialog(null, scrollPane, "Grupos y Asignaciones", JOptionPane.PLAIN_MESSAGE);
                    }
                    break;

                case 6:
                    // Hacer Pago
                    String docIdentificacion = JOptionPane.showInputDialog("Ingrese el número de documento del estudiante:");

                    // Buscar el estudiante
                    Estudiante estudiantePago = null;
                    for (Estudiante estudiante : est) {
                        if (estudiante.getNumeroDocumento().equals(docIdentificacion)) {
                            estudiantePago = estudiante;
                            break;
                        }
                    }

                    if (estudiantePago != null) {
                        // Verificar si el estudiante está asignado a un grupo y no ha realizado pagos
                        if (!grupos.isEmpty()) {
                            for (Grupo grupo : grupos) {
                                if (grupo.getEstudiantes().contains(estudiantePago) && estudiantePago.getPagosRealizados() == 0) {
                                    // Realizar el pago
                                    estudiantePago.incrementarPagosRealizados();

                                    // Imprimir comprobante de pago
                                    String mensajePago = "Comprobante de Pago:\n"
                                            + "Nombre: " + estudiantePago.getNombre() + " " + estudiantePago.getApellido() + "\n"
                                            + "Número de Documento: " + estudiantePago.getNumeroDocumento() + "\n"
                                            + "Materia: " + grupo.getMateria() + "\n"
                                            + "Fecha de Realización del Pago: " + new Date();
                                    JOptionPane.showMessageDialog(null, mensajePago, "Pago Realizado", JOptionPane.INFORMATION_MESSAGE);
                                } else if (estudiantePago.getPagosRealizados() > 0) {
                                    JOptionPane.showMessageDialog(null, "Este estudiante ya ha realizado un pago previamente.", "Pago Existente", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay grupos creados para realizar pagos.", "Sin Grupos", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un estudiante con el número de documento proporcionado.", "Estudiante no Encontrado", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Hasta Pronto");
            }

        } while (opcion != 7);
    }
}
