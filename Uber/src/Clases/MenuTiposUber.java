package Clases;
import Login.LoginUsuario;

import java.util.Date;
import java.util.Scanner;

import static ChatBox.EjecutarChat.ejecutarConversacion;
import static Validaciones.Validador.buscarUbicacionValidada;
import static Validaciones.Validador.obtenerEnteroDesdeConsola;

public class MenuTiposUber {
    private String email;

    public MenuTiposUber() {
    }

    public MenuTiposUber(String email) {
    }

    public void MenuTiposUber(String email) {
        Scanner scanner = new Scanner(System.in);
        String nombre = email;
        int opcion;
        do {
            System.out.println("Menú de Tipos de Uber:");
            System.out.println("1. UberX");
            System.out.println("2. UberXL");
            System.out.println("3. UberBlack");
            System.out.println("4. Uber-Tuc-Tuc");
            System.out.println("5. UberVan");
            System.out.println("6. UberMoto");
            System.out.println("7. ChatBox Soporte");
            System.out.println("8. Regresar al menu anterior");
            System.out.print("Seleccione una opción: ");
            opcion = obtenerEnteroDesdeConsola(scanner);

            switch (opcion) {
                case 1:
                    String tipouber = "UberX";
                    double costo = 3;
                    solicitarViaje(scanner, email, costo, tipouber);
                    break;
                case 2:
                    System.out.println("Ha seleccionado UberXL.");
                    String tipouberXl = "UberXL";
                    double costoXL = 6;
                    solicitarViaje(scanner, email, costoXL, tipouberXl);
                    break;
                case 3:
                    System.out.println("Ha seleccionado UberBlack.");
                    String tipouberBlack = "UberBlack";
                    double costoBlack = 5;
                    solicitarViaje(scanner, email, costoBlack, tipouberBlack);
                    break;
                case 4:
                    System.out.println("Ha seleccionado Uber-Tuc-Tuc.");
                    String uberTuc = "Uber-Tuc-Tuc";
                    double costoTuc = 0.75;
                    solicitarViaje(scanner, email, costoTuc, uberTuc);
                    break;
                case 5:
                    System.out.println("Ha seleccionado UberVan.");
                    String uberVan = "UberVan";
                    double costoVan = 5;
                    solicitarViaje(scanner, email, costoVan, uberVan);
                    break;
                case 6:
                    System.out.println("Ha seleccionado UberMoto.");
                    String uberMoto = "UberMoto";
                    double costoMoto = 2;
                    solicitarViaje(scanner, email, costoMoto, uberMoto);
                    break;
                case 7:
                    ejecutarConversacion();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Su mensaje fue enviado, ");
                    System.out.println("Gracias por comunicarte con nosotros, le daremos solucion a tu problema lo mas pronto.!");
                    break;
                case 8:
                    System.out.println("Menu Anterior");
                    new SimulacionCarga().simularBarraCarga();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 8);
    }

    public static void solicitarViaje(Scanner scanner, String nombre, double costo, String tipouber) {

        System.out.println("Ha seleccionado UberX.");
        System.out.println("Buscando conductor...");
        new SimulacionCarga().simularBarraCarga();
        System.out.println("\n¡Conductor encontrado!");
        MostrarConductorRamndom.MostrarConductor();


        Date fechaInicio = new Date();

        String ubicacionActual, destino;
        double distancia;

        do {
            System.out.print("Ubicacion Actual: ");
            ubicacionActual = buscarUbicacionValidada(scanner);
        } while (ubicacionActual.isEmpty());

        do {
            System.out.print("Destino: ");
            destino = buscarUbicacionValidada(scanner);
        } while (destino.isEmpty());

        System.out.print("Distancia: ");
        distancia = Double.parseDouble(scanner.nextLine());

        double costoViaje = distancia * costo;
        Date fechaFin = new Date();
        DatosViajesUsuario viajes = new DatosViajesUsuario();
        ViajesRandomConductor viajesRamdomConductor = new ViajesRandomConductor(nombre, ubicacionActual, destino, distancia, costoViaje);

        viajes.DatosViajesUsuario(nombre, fechaInicio, ubicacionActual, destino, distancia, costoViaje, fechaFin, tipouber);
        try {
            Thread.sleep((long) (2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(viajes.toString());
        LoginUsuario.guardarDatosViaje(viajes.getNumeroCorrelativo(), viajes.getNombre(), fechaInicio, viajes.getUbicacionActual(), viajes.getDestino(), distancia, viajes.getCostoViaje(), fechaFin, viajes.getTipoUber());


    }


}



