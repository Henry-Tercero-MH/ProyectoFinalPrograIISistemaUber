package Login;
import Clases.DatosViajesConductor;
import Clases.SimulacionCarga;
import Validaciones.Validador;

import java.io.*;
import java.util.*;

public class LoginConductor {

    private static final Map<String, String> conductores = new HashMap<>();
    private static final String FILENAMECONDUCTORES = "conductores.txt";
    private static final String UserPassword= "UserPasswordConductores.txt";
    private static final String FILENAMEDATOSCONDUCTOR = "DatosConductores.txt";


    public static void cargarDatosConductores() {
        conductores.clear(); // Limpia el mapa para cargar los datos actualizados
        try (BufferedReader br = new BufferedReader(new FileReader(UserPassword))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    conductores.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean iniciarSesionC(String email, String password) {
        if (verificarCredencialesConductor(email, password)) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido al sistema de UBER, " + email + "!");
            return true;

        } else {
            new SimulacionCarga().simularBarraCarga();
            System.out.println("Nombre de conductor o contraseña incorrectos. Inténtelo de nuevo.");
        }
        return false;
    }

    public static boolean verificarCredencialesConductor(String username, String password) {
        return conductores.containsKey(username) && conductores.get(username).equals(password);
    }


    public static boolean registrarConductor(String newUsername, String newPassword) {
        Validador validador = new Validador();
        if (conductores.containsKey(newUsername) || conductorExisteEnArchivo(newUsername)) {
            System.out.println("El nombre de conductor ya está en uso. Intente con otro nombre de conductor.");
            return false; // Registro no exitoso
        } else {
            Scanner scanner = new Scanner(System.in);
// Solicitar y validar los datos del conductor
            System.out.print("Ingrese su nombre: ");
            String nombre = validador.validarNombre(scanner);
            System.out.print("Ingrese el modelo de su vehículo: ");
            String modeloVehiculo = validador.validarNombre(scanner);
            System.out.print("Ingrese la placa de su vehículo: ");
            String placaVehiculo = validador.validarPlacaGuatemala(scanner);
            System.out.print("Ingrese el color de su vehículo: ");
            String color = validador.validarNombre(scanner);
            Random random = new Random();
            double numeroAleatorio = 1.5 + random.nextDouble() * (4.9 - 1.5);
            double numeroRedondeado = Math.round(numeroAleatorio * 10.0) / 10.0;
            String numeroAleatorioString = String.valueOf(numeroRedondeado);
// Guardar los datos del conductor
            DatosViajesConductor newConductor = new DatosViajesConductor(nombre, modeloVehiculo, placaVehiculo, color, numeroAleatorioString);
            conductores.put(newUsername, newPassword);

            guardarCredenciales(newUsername, newPassword, nombre, modeloVehiculo, placaVehiculo, color, numeroAleatorioString);
            guardarCredencialesConductor(nombre, modeloVehiculo, placaVehiculo, color, numeroAleatorioString);
            System.out.println(newConductor.toString());
            System.out.println("Registro exitoso. ¡Bienvenido al sistema de UBER, " + newUsername + "!");

            return true; // Registro exitoso
        }
    }

    public static boolean conductorExisteEnArchivo(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAMECONDUCTORES))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void guardarCredenciales(String username, String password, String nombre, String apellido, String direccion, String numeroTelefono, String rd) {
        if (username == null || username.isEmpty() ||
                password == null || password.isEmpty() ||
                nombre == null || nombre.isEmpty() ||
                apellido == null || apellido.isEmpty() ||
                direccion == null || direccion.isEmpty() ||
                numeroTelefono == null || numeroTelefono.isEmpty() ||
                rd == null || rd.isEmpty()) {
            System.out.println("Error: Uno o más campos requeridos son nulos o vacíos. Las credenciales no se guardarán.");
            return; // Salir de la función si hay campos nulos o vacíos
        } else {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAMECONDUCTORES, true))) {
                writer.println(username + ","+ password+ ","+nombre+ ","+ apellido+ ","+direccion+ ","+numeroTelefono+ ","+new Date());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void guardarCredencialesConductor(String nombre, String modeloVehiculo, String placaVehiculo, String color, String calificacion) {
        if (nombre == null || nombre.isEmpty() ||
                modeloVehiculo == null || modeloVehiculo.isEmpty() ||
                placaVehiculo == null || placaVehiculo.isEmpty() ||
                color == null || color.isEmpty() ||
                calificacion == null || calificacion.isEmpty()) {
            System.out.println("Error: Uno o más campos requeridos son nulos o vacíos. Las credenciales no se guardarán.");
            return; // Salir de la función si hay campos nulos o vacíos
        } else {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAMEDATOSCONDUCTOR, true))) {
                writer.println(nombre+","+modeloVehiculo+","+placaVehiculo+","+color+","+calificacion);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}


