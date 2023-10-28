package Clases;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DatosViajesConductor {
    private String nombre;
    private String modeloVehiculo; // Corregido el nombre del atributo
    private String placaVehiculo; // Corregido el nombre del atributo
    private String color;
    private String calificacion;

    // Constructor
    public DatosViajesConductor(String nombre, String modeloVehiculo, String placaVehiculo, String color, String calificacion) {
        this.nombre = nombre;
        this.modeloVehiculo = modeloVehiculo;
        this.placaVehiculo = placaVehiculo;
        this.color = color;
        this.calificacion = calificacion;
    }

    // Métodos para acceder a los atributos y obtener la calificación aleatoria
    public String getNombre() {
        return nombre;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        String separator = "+------------------------+----------------------+--------------+------------+--------------+%n";

        // Crear un formato con punto como separador decimal
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);


        return String.format(
                separator +
                        "|      NOMBRE         |   MODELO VEHÍCULO   |  PLACA VEHÍCULO |   COLOR VEHÍCULO | CALIFICACIÓN  |%n" +
                        separator +
                        "| %-19s | %-20s | %-15s | %-16s | %-13s |%n",
                nombre, modeloVehiculo, placaVehiculo, color, calificacion) +
                separator;
    }
}


