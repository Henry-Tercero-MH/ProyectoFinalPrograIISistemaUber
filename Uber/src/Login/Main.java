package Login;

import Clases.SimulacionCarga;
import Validaciones.Validador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(".::Menu Principal:.");
            System.out.println("1. UBER DRIVER");
            System.out.println("2. UBER USER");
            System.out.println("3. Salir");
            opcion = Validador.obtenerEnteroDesdeConsola(scanner);

            switch (opcion) {
                case 1:
                   new SimulacionCarga().simularBarraCarga();
                    System.out.println(".:BIENVENIDO A UBER DIRVER:.");
          LoginConductorM.MenuConductor();
                    break;
                case 2:
                    new SimulacionCarga().simularBarraCarga();
                    System.out.println(".:BIEVENIDO A UBER USER:.");
              LoginUsuarioM.MenuUsuario();

                case 3:
                    System.out.println("Saliendo del sistema del conductor.");
                    new SimulacionCarga().simularBarraCarga();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }
}