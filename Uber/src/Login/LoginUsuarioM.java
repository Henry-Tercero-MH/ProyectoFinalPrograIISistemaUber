package Login;

import Clases.SimulacionCarga;
import Login.LoginUsuario;
import Validaciones.Validador;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static Login.LoginUsuario.*;
import static Validaciones.Validador.obtenerEnteroDesdeConsola;

public class LoginUsuarioM {
    private static Map<String, String> usuarios = new HashMap<>();
    private static final String FILENAMEUSUARIOS = "usuarios.txt";
    public static void MenuUsuario() {
        cargarUsuariosU();
        Validador validador = new Validador();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = obtenerEnteroDesdeConsola(scanner);

            switch (opcion) {
                case 1:
                  //  cargarDatosDesdeArchivo();
                    String email, password;
                    System.out.println("Ingrese su correo electrónico: ");

                    email =  validador.validarCorreoElectronico(scanner);
                                    System.out.print("Ingrese su contraseña: ");
                                    password =  validador.validarContrasena(scanner);
                                    new SimulacionCarga().simularBarraCarga();
                                    iniciarSesion(email, password);
                                    break;


                case 2:
                    //cargarDatosDesdeArchivo();
                    System.out.print("Ingrese su correo electrónico: ");

                    email=validador.validarCorreoElectronico(scanner);
                                    System.out.print("Ingrese su contraseña: ");
                                    password =  validador.validarContrasena(scanner);
                                    new SimulacionCarga().simularBarraCarga();
                                    if (registrarUsuario(email, password)) {
                                        System.out.println("Exito-----");
                                        break;
                                    }else{
                                        System.out.println("Usuario ya esta en uso!");
                                        break;
                                    }


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


