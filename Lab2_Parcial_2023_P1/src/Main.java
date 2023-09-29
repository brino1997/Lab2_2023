import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        //menu punto 1
        var opc = 0;
        do {
            System.out.println("ingresar una opc del 1  al 7");
            System.out.println("1 - Listar Doctores");
            System.out.println("2 - Registrar un nuevo paciente");
            System.out.println("3 - Actualizar informacion de un paciente");
            System.out.println("4 - Consultar el historial medico de un paciente");
            System.out.println("5 - Nuevo historial para un paciente");
            System.out.println("6 - Cargar historial de paciente desde archivo");
            System.out.println("7 - Salir");
            Scanner sc = new Scanner(System.in);
            opc = sc.nextInt();
            System.out.println("opcion elegida "+opc);
        } while (opc != 7);
        System.out.println("proceso terminado");



    }
}
