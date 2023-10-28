package Clases;

import Validaciones.Validador;

import java.util.Scanner;

public class MenuConductor {
    private String email;

    public MenuConductor() {
    }

    public void MenuConductor() {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            ViajesRandomConductor.mostrarConductor();
            System.out.println("Menú del Conductor:");
            System.out.println("1. Ver Solicitudes de Viaje Pendientes");
            System.out.println("2. Aceptar Viaje");
            System.out.println("3. Rechazar Viaje");
            System.out.println("4. Finalizar Viaje");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Validador.obtenerEnteroDesdeConsola(scanner);

            switch (opcion) {
                case 1:
                    // Aquí puedes mostrar una lista de solicitudes de viaje pendientes para el conductor
                    System.out.println("Solicitudes de Viaje Pendientes:");
                    ViajesRandomConductor.mostrarConductor();
                    ViajesRandomConductor.mostrarConductor();
                    ViajesRandomConductor.mostrarConductor();
                    ViajesRandomConductor.mostrarConductor();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    limpiarPantalla();

                    break;
                case 2:
                    System.out.println("-------------------------------------------------------------------------------------------");
                    ViajesRandomConductor.mostrarConductor();
                    System.out.println("Digite la Distancia del usuario:");
                    int distancia =Validador.obtenerEnteroDesdeConsola(scanner);
                    System.out.println(".................:VIAJE INICIADO:..........................");
                    String emoji = "🏝️";
                    imprimirValla(emoji, distancia + 1);
                    new SimulacionMapa().simularMapa(distancia);

                    break;
                case 3:
                    // Aquí puedes implementar la lógica para que el conductor rechace un viaje
                    System.out.println("Ha rechazado un viaje.");
                    // Implementa la lógica para rechazar el viaje
                    break;
                case 4:
                    // Aquí puedes implementar la lógica para finalizar un viaje
                    System.out.println("Ha finalizado un viaje.");
                    // Implementa la lógica para finalizar el viaje
                    break;
                case 5:
                    System.out.println("Saliendo del sistema del conductor.");
                    new SimulacionCarga().simularBarraCarga();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 5);

    }

    public static void imprimirValla(String emoji, int cantidad) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cantidad; i++) {
            sb.append(emoji);
        }

        System.out.println(sb.toString());
    }

        public void limpiarPantalla() {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
