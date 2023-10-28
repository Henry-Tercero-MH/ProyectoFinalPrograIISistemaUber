package Clases;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MostrarConductorRamndom {
    public static void MostrarConductor() {
        List<String> lines = new ArrayList<>();
        String fileName = "DatosConductores.txt"; // Reemplaza con la ruta correcta de tu archivo

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (lines.isEmpty()) {
            System.out.println("El archivo está vacío.");
            return;
        }

        // Genera un número aleatorio entre 0 y el tamaño de la lista
        Random random = new Random();
        int randomIndex = random.nextInt(lines.size());

        // Obtiene la línea seleccionada aleatoriamente
        String randomLine = lines.get(randomIndex);

        // Separa los datos de la línea y crea un objeto DatosViajesConductor
        String[] parts = randomLine.split(","); // Ajusta el separador según tu formato
        if (parts.length >= 5) {
            String nombre = parts[0].trim();
            String modeloVehiculo = parts[1].trim();
            String placaVehiculo = parts[2].trim();
            String color = parts[3].trim();
            String calificacion = parts[4].trim();
            // Resto de tu código para procesar los datos
            DatosViajesConductor conductor = new DatosViajesConductor(nombre, modeloVehiculo, placaVehiculo, color, calificacion);
            // Muestra los datos en pantalla llamando a su método toString
            System.out.println(conductor.toString());
        } else {
            System.out.println("Error al procesar la línea del archivo.");
        }
    }
}
