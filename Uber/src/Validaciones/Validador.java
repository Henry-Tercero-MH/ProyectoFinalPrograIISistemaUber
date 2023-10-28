package Validaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {
    public static String buscarUbicacionValidada(Scanner scanner) {
String ubicacionABuscar;
        do {
            ubicacionABuscar = scanner.nextLine(); // Ubicación ingresada por el usuario
            String[] resultado = validarUbicacion(ubicacionABuscar);
            if (resultado != null) {
                System.out.println("Código Postal: " + resultado[0]);
                System.out.println("Ubicación: " + resultado[1]);
                break;
            } else {
                System.out.println("La ubicación no se encontró en el archivo. Intente de nuevo.");
            }
        } while (true);
        return ubicacionABuscar;
    }

    public static String[] validarUbicacion(String ubicacionABuscar) {
        String nombreArchivo = "DeptoMuni.txt"; // Nombre del archivo de ubicaciones

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("%");
                if (partes.length == 2 && partes[1].equalsIgnoreCase(ubicacionABuscar)) {
                    return partes;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean archivoExiste(String nombreArchivo) {
        //validacion para un arvhivo txt
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }
    public static int obtenerEnteroDesdeConsola(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opción no válida. Debe ingresar un número entero.");
                scanner.next(); // Limpia el búfer del escáner
            }
        }
    }
    public static String validarCorreoElectronico(Scanner scanner) {
        String correo;
        do {
            correo = scanner.nextLine();
            if (validarCorreo(correo)) {
                return correo; // Retorna el correo si es válido
            } else {

            }
        } while (true);
    }

    private static boolean validarCorreo(String correo) {
        String expresionRegular = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pat = Pattern.compile(expresionRegular);
        Matcher mat = pat.matcher(correo);
        return mat.matches();
    }

    public String validarNumeroTelefono(Scanner scanner) {
        String numeroTelefono;
        boolean esValido = false;
        do {
            numeroTelefono = scanner.nextLine();

            if (numeroTelefono.matches("\\d{8}")) {
                esValido = true;
            } else {
                System.out.print("Ingrese su número de teléfono: ");
            }
        } while (!esValido);

        return numeroTelefono;
    }
    public String validarNombre(Scanner scanner) {
        String nombre;
        do {
            nombre = scanner.nextLine();

            if (nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÜüñÑ,\\s]+$"
            )) {
                // La cadena es válida si contiene solo letras, espacios, apóstrofes y letras con acentos
                break;
            } else {
                System.out.println("El nombre no es válido. Debe contener solo letras, espacios, apóstrofes y letras con acentos.");
            }

            // Consumir el salto de línea restante
            scanner.nextLine();
        } while (true);

        return nombre;
    }
    public String validarPlacaGuatemala(Scanner scanner) {
        String placa;
        do {
            placa = scanner.nextLine();

            if (placa.matches("^[A-Z]{3}-\\d{5}$")) {
                // La placa es válida si coincide con el formato el que usamos en guate
                break;
            } else {
                System.out.println("La placa no es válida. Debe seguir el formato  (ejemplo: ABC-12345).");
            }
        } while (true);

        return placa;
    }

    public static String validarContrasena(Scanner scanner) {
        String contrasena;
        do {
            contrasena = scanner.nextLine();

            if (validarContrasenaFormato(contrasena)) {
                // La contraseña es válida si cumple con los requisitos especificados
                break;
            } else {
                System.out.println("La contraseña no es válida. Debe cumplir con los requisitos. (por ejemplo, !, @, #, $, %, etc.)");
            }
        } while (true);

        return contrasena;
    }
    public static boolean validarContrasenaFormato(String contrasena) {
        // Reemplaza esta expresión regular con tus criterios de validación
        String expresionRegular = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";

        return contrasena.matches(expresionRegular);
    }


}
