import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

// Clase principal que contiene el menú
class HospitalApp {
    private static ArrayList<Doctor> doctores = new ArrayList<>();
    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    public static void main(String[] args) {
        cargarDoctoresIniciales();
        cargarDatosDeContacto();

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    listarDoctores();
                    break;
                case 2:
                    registrarPaciente(scanner);
                    break;
                case 3:
                    actualizarInfoPaciente(scanner);
                    break;
                case 4:
                    consultarHistorialMedico(scanner);
                    break;
                case 5:
                    nuevoHistorialMedico(scanner);
                    break;
                case 6:
                    cargarDatosDeContacto();
                    break;
                case 7:
                    guardarRecuperarPacientes("guardar");
                    break;
                case 8:
                    guardarRecuperarPacientes("recuperar");
                    break;
                case 9:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 9);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nHospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399");
        System.out.println("Menú:");
        System.out.println("ingresar una opc del 1  al 7");
        System.out.println("1 - Listar Doctores");
        System.out.println("2 - Registrar un nuevo paciente");
        System.out.println("3 - Actualizar informacion de un paciente");
        System.out.println("4 - Consultar el historial medico de un paciente");
        System.out.println("5 - Nuevo historial para un paciente");
        System.out.println("6 - Cargar historial de paciente desde archivo");
        System.out.println("7 - Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void cargarDoctoresIniciales() {
        // Cargar algunos doctores iniciales (puedes agregar más si lo deseas)
        doctores.add(new Doctor("Dr. Pepe Suarez", "12123178", "02/10/1980", "odontologia"));
        doctores.add(new Doctor("Dr. Maria Antonienta", "98124532", "20/08/1775", "oftamologo"));
    }

    private static void listarDoctores() {
        System.out.println("LISTA DE DOCTORES:");
        for (Doctor doctor : doctores) {
            System.out.println(doctor.nombre + " - " + doctor.especialidad);
        }
    }

    private static void registrarPaciente(Scanner scanner) {
        System.out.print("Nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI del paciente: ");
        String dni = scanner.nextLine();
        System.out.print("Fecha de nacimiento (formato dd/MM/yyyy): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Número de teléfono (solo números): ");
        String telefono = scanner.nextLine();
        System.out.print("Tipo de sangre (solo números): ");
        String tipoSangre = scanner.nextLine();

        // Crear paciente y agrega a la lista
        Paciente paciente = new Paciente(nombre, dni, fechaNacimiento, telefono, tipoSangre);
        pacientes.add(paciente);

        System.out.println("se registro paciente.");
    }

    private static void actualizarInfoPaciente(Scanner scanner) {
        System.out.print("Ingrese el DNI del paciente que desea actualizar: ");
        String dni = scanner.nextLine();

        // Buscar al paciente por su DNI
        Paciente pacienteEncontrado = buscarPacientePorDNI(dni);

        if (pacienteEncontrado != null) {
            System.out.println("Paciente encontrado:");
            System.out.println("Nombre: " + pacienteEncontrado.nombre);
            System.out.println("DNI: " + pacienteEncontrado.dni);
            System.out.println("Fecha de Nacimiento: " + pacienteEncontrado.fechaNacimiento);
            System.out.println("Número de Teléfono: " + pacienteEncontrado.telefono);
            System.out.println("Tipo de Sangre: " + pacienteEncontrado.tipoSangre);

            // Solicitar informacion del paciente
            System.out.println("Ingrese la nueva información (deje en blanco para mantener la misma):");
            System.out.print("Nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Fecha de nacimiento (formato dd/MM/yyyy): ");
            String nuevaFechaNacimiento = scanner.nextLine();
            System.out.print("Número de teléfono (solo números): ");
            String nuevoTelefono = scanner.nextLine();
            System.out.print("Tipo de sangre (solo números): ");
            String nuevoTipoSangre = scanner.nextLine();

            // Actualizar la información si se proporciona
            if (!nuevoNombre.isEmpty()) {
                pacienteEncontrado.nombre = nuevoNombre;
            }
            if (!nuevaFechaNacimiento.isEmpty()) {
                pacienteEncontrado.fechaNacimiento = nuevaFechaNacimiento;
            }
            if (!nuevoTelefono.isEmpty()) {
                pacienteEncontrado.telefono = nuevoTelefono;
            }
            if (!nuevoTipoSangre.isEmpty()) {
                pacienteEncontrado.tipoSangre = nuevoTipoSangre;
            }

            System.out.println("Información actualizada exitosamente.");
        } else {
            System.out.println("No se encontró ningún paciente con el DNI proporcionado.");
        }
    }

    private static void nuevoHistorialMedico(Scanner scanner) {
        System.out.print("Ingrese el DNI del paciente al que desea agregar un nuevo historial médico: ");
        String dni = scanner.nextLine();

        // Buscar al paciente por su DNI
        Paciente pacienteEncontrado = buscarPacientePorDNI(dni);

        if (pacienteEncontrado != null) {
            System.out.print("Ingrese la fecha del evento (formato dd/MM/yyyy): ");
            String fechaEvento = scanner.nextLine();
            System.out.print("Ingrese las observaciones del evento médico: ");
            String observaciones = scanner.nextLine();

            String evento = fechaEvento + " - " + observaciones;

            // Agregar el evento al historial médico del paciente
            pacienteEncontrado.historialMedico.add(evento);

            System.out.println("Nuevo evento agregado al historial médico.");
        } else {
            System.out.println("No se encontró ningún paciente con el DNI proporcionado.");
        }
    }

    private static void consultarHistorialMedico(Scanner scanner) {
        System.out.print("Indique el DNI del paciente a buscar: ");
        String dni = scanner.nextLine();

        // Buscar al paciente por su DNI
        Paciente pacienteEncontrado = buscarPacientePorDNI(dni);

        if (pacienteEncontrado != null) {
            System.out.println("HISTORIAL MÉDICO:");
            for (String evento : pacienteEncontrado.historialMedico) {
                System.out.println(evento);
            }
        } else {
            System.out.println("No se encontró ningún paciente con el DNI proporcionado.");
        }
    }

    private static Paciente buscarPacientePorDNI(String dni) {
        for (Paciente paciente : pacientes) {
            if (paciente.dni.equals(dni)) {
                return paciente;
            }
        }
        return null;
    }

    private static void cargarDatosDeContacto() {
        try (Scanner entrada = new Scanner(new File("datos.txt"))) {
            String linea;
            System.out.println("\nDatos de Contacto del Hospital:");
            while (entrada.hasNextLine()) {
                linea = entrada.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al cargar los datos de contacto desde el archivo: " + e.getMessage());
        }
    }

    private static void guardarRecuperarPacientes(String accion) {
        if (accion.equals("guardar")) {
            try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("pacientes.dat"))) {
                salida.writeObject(pacientes);
                System.out.println("Pacientes guardados en archivo exitosamente.");
            } catch (IOException e) {
                System.err.println("Error al guardar los pacientes en el archivo: " + e.getMessage());
            }
        } else if (accion.equals("recuperar")) {
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("pacientes.dat"))) {
                pacientes = (ArrayList<Paciente>) entrada.readObject();
                System.out.println("Pacientes recuperados desde archivo exitosamente.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar los pacientes desde el archivo: " + e.getMessage());
            }
        }
    }
}

// Clase Doctor
class Doctor extends Persona {
    String especialidad;

    public Doctor(String nombre, String dni, String fechaNacimiento, String especialidad) {
        super(nombre, dni, fechaNacimiento);
        this.especialidad = especialidad;
    }
}

// Clase abstracta Persona
abstract class Persona implements Serializable {
    String nombre;
    String dni;
    String fechaNacimiento;

    public Persona(String nombre, String dni, String fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }
}

// Clase Paciente
class Paciente extends Persona implements Informacion, Serializable {
    String telefono;
    String tipoSangre;
    ArrayList<String> historialMedico = new ArrayList<>();

    public Paciente(String nombre, String dni, String fechaNacimiento, String telefono, String tipoSangre) {
        super(nombre, dni, fechaNacimiento);
        this.telefono = telefono;
        this.tipoSangre = tipoSangre;
    }

    public void verHistorialDeEventos() {
        if (historialMedico.isEmpty()) {
            System.out.println("El historial médico está vacío.");
        } else {
            System.out.println("HISTORIAL MÉDICO:");
            for (String evento : historialMedico) {
                System.out.println(evento);
            }
        }
    }
}

// Interfaz Informacion
interface Informacion {
    void verHistorialDeEventos();
}