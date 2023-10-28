package Login;
import Clases.MenuTiposUber;
import Clases.SimulacionCarga;
import Validaciones.Validador;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginUsuario {

    private static Map<String, String> usuarios1 = new HashMap<>();
    private static final String FILENAMEUSUARIOS = "usuarios.txt";
    private static final String userPassword = "userPassword.txt";
    private static final String FILENAMEDATOSUSUARIO = "DatosUsuarios.txt";

    static void cargarUsuariosU() {
        try (BufferedReader br = new BufferedReader(new FileReader(userPassword))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", 2);
                if (partes.length == 2) {
                    String usuario = partes[0];
                    String contrasena = partes[1];
                    usuarios1.put(usuario, contrasena);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAMEUSUARIOS))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    usuarios1.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void iniciarSesion(String email, String password) {
        if (verificarCredenciales(email, password)) {

            System.out.println("Inicio de sesión exitoso. ¡Bienvenido al sistema de UBER, " + email + "!");
            MenuTiposUber menuTiposUber = new MenuTiposUber();
            menuTiposUber.MenuTiposUber(email);

        } else {
            new SimulacionCarga().simularBarraCarga();
            System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");

        }
    }

    public static boolean registrarUsuario(String newUsername, String newPassword) {
        cargarUsuarios();
        if (usuarios1.containsKey(newUsername)) {
            System.out.println("El nombre de usuario ya está en uso. Intente con otro nombre de usuario.");
            return false; // Registro no exitoso
        } else {
            Scanner scanner = new Scanner(System.in);

            // Validación de la contraseña
            System.out.print("Ingrese su nombre: ");
            Validador validador = new Validador();
            String nombre = validador.validarNombre(scanner);
            System.out.print("Ingrese su apellido: ");
            String apellido = validador.validarNombre(scanner);
            System.out.print("Ingrese su dirección: ");
            String direccion = validador.validarNombre(scanner);
            System.out.print("Ingrese su número de teléfono: ");
            String numeroTelefono = validador.validarNumeroTelefono(scanner);

            userPassword(newUsername, newPassword);
            usuarios1.put(newUsername, newPassword);
            guardarCredenciales(newUsername, newPassword, nombre, apellido, direccion, numeroTelefono);
            System.out.println("Registro exitoso. ¡Bienvenido al sistema de UBER, " + newUsername + "!");
            return true; // Registro exitoso
        }
    }


    public static void registrarViajesUsuario(String newUsername, String newPassword) {
        if (usuarios1.containsKey(newUsername)) {
            System.out.println("El nombre de usuario ya está en uso. Intente con otro nombre de usuario.");

        } else {
            usuarios1.put(newUsername, newPassword);
        }
    }

    public static boolean verificarCredenciales(String username, String password) {
        return usuarios1.containsKey(username) && usuarios1.get(username).equals(password);
    }

    public static void userPassword(String username, String password) {
        if (username == null || username.isEmpty() ||
                password == null || password.isEmpty()
        ) {
            System.out.println("Error: Uno o más campos requeridos son nulos o vacíos. Las credenciales no se guardarán.");
            return; // Salir de la función si hay campos nulos o vacíos
        } else {
            try (PrintWriter writer = new PrintWriter(new FileWriter(userPassword, true))) {
                writer.println(username + "," + password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void guardarCredenciales(String username, String password, String nombre, String apellido, String direccion, String numeroTelefono) {
        if (username == null || username.isEmpty() ||
                password == null || password.isEmpty() ||
                nombre == null || nombre.isEmpty() ||
                apellido == null || apellido.isEmpty() ||
                direccion == null || direccion.isEmpty() ||
                numeroTelefono == null || numeroTelefono.isEmpty()) {
            System.out.println("Error: Uno o más campos requeridos son nulos o vacíos. Las credenciales no se guardarán.");
            return; // Salir de la función si hay campos nulos o vacíos
        } else {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAMEUSUARIOS, true))) {
                writer.println("Correo: " + username + " Password: " + password + " Nombre: "
                        + nombre + " Apellido: " + apellido + " Direccion: " + direccion + " Teléfono: "
                        + numeroTelefono + " Fecha de Creacion: " + new Date());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void guardarDatosViaje(int correlativo, String nombre, Date inicioViaje, String ubicacionActual, String destino, Double distancia, Double costoViaje, Date finalizaViaje, String tipoUber) {
        // Validar que los campos no sean nulos o vacíos
        if (nombre == null || nombre.isEmpty() ||
                inicioViaje == null ||
                ubicacionActual == null || ubicacionActual.isEmpty() ||
                destino == null || destino.isEmpty() ||
                distancia == null ||
                costoViaje == null ||
                finalizaViaje == null ||
                tipoUber == null || tipoUber.isEmpty()) {
            System.out.println("Error: Uno o más campos requeridos son nulos o vacíos. Los datos del viaje no se guardarán.");
            return; // Salir de la función si hay campos nulos o vacíos
        } else {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAMEDATOSUSUARIO, true))) {
                writer.println("Factura No. " + correlativo);
                writer.println("Nombre: " + nombre);
                writer.println("Inicio del viaje: " + inicioViaje);
                writer.println("Ubicación actual: " + ubicacionActual);
                writer.println("Destino: " + destino);
                writer.println("Distancia: " + distancia);
                writer.println("Costo del viaje: " + costoViaje);
                writer.println("Finalización del viaje: " + finalizaViaje);
                writer.println("Tipo Uber: " + tipoUber);

                writer.println(); // Agregar una línea en blanco para separar cada registro
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
