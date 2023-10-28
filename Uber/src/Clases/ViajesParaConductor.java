package Clases;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ViajesParaConductor {
    private String nombre;
    private String ubicacionActual;
    private String destino;
    private double distancia;
    private double costoViaje;

    public ViajesParaConductor(String nombre, String ubicacionActual, String destino, double distancia, double costoViaje) {
        this.nombre = nombre;
        this.ubicacionActual = ubicacionActual;
        this.destino = destino;
        this.distancia = distancia;
        this.costoViaje = costoViaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacionActual() {
        return ubicacionActual;
    }

    public String getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getCostoViaje() {
        return costoViaje;
    }

    @Override
    public String toString() {
        String separator = "+----------------------+----------------------+----------------------+------------+------------+%n";

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        return String.format(
                separator +
                        "|        Nombre        |   Ubicación Actual   |       Destino        |  Distancia  |  Costo Viaje|%n" +
                        separator +
                        "| %-20s | %-20s | %-20s | %10s | %10s |%n",
                nombre, ubicacionActual, destino, df.format(distancia), df.format(costoViaje)) +
                separator;
    }
}
