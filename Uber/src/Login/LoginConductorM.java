package Login;

import Clases.MenuConductor;
import Clases.SimulacionCarga;
import Validaciones.Validador;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Login.LoginConductor.*;
public class LoginConductorM {
    private static final Map<String, String> conductores = new HashMap<>();
    private static final String UserPassword= "UserPasswordConductores.txt";


    public static void MenuConductor() {
        cargarDatosConductores();
        Validador validador =new Validador();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Iniciar sesión como conductor");
            System.out.println("2. Registrarse como conductor");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = Validador.obtenerEnteroDesdeConsola(scanner);

            switch (opcion) {
                case 1:
                    String email, password;
                    System.out.print("Ingrese su correo electrónico como conductor: ");
                    email = Validador.validarCorreoElectronico(scanner);
                    System.out.print("Ingrese su contraseña: ");
                    password = Validador.validarContrasena(scanner);
                    new SimulacionCarga().simularBarraCarga();

                    if (iniciarSesionC(email, password)) {
                        MenuConductor menuConductor = new MenuConductor();
                        menuConductor.MenuConductor();
                    }

                    break;
                case 2:
                    System.out.print("Ingrese su correo electrónico: ");
                    email=validador.validarCorreoElectronico(scanner);
                    System.out.print("Ingrese su contraseña: ");
                    password =  validador.validarContrasena(scanner);
                    new SimulacionCarga().simularBarraCarga();
                    registrarConductor(email, password);
                   break;


                case 3:
                    System.out.println("Saliendo del sistema.");
                    new SimulacionCarga().simularBarraCarga();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }


}
