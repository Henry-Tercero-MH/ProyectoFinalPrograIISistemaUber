package Clases;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DatosViajesUsuario {
    private String nombre;
    private Date inicioViaje;
    private String ubicacionActual;
    private String destino;
    private double distancia;
    private double costoViaje;
    private Date finalizaViaje;
    private String tipoUber;
    private static int correlativo = 1000000;
    private int numeroCorrelativo;

    public void DatosViajesUsuario(String nombre, Date inicioViaje, String ubicacionActual, String destino,
                                   double distancia, double costoViaje, Date finalizaViaje, String tipoUber) {
        correlativo++; // Incrementa el valor correlativo
        this.numeroCorrelativo = correlativo;
        this.nombre = nombre;
        this.inicioViaje = inicioViaje;
        this.ubicacionActual = ubicacionActual;
        this.destino = destino;
        this.distancia = distancia;
        this.costoViaje = costoViaje;
        this.finalizaViaje = finalizaViaje;
        this.tipoUber = tipoUber;
    }

    public DatosViajesUsuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getInicioViaje() {
        return inicioViaje;
    }

    public void setInicioViaje(Date inicioViaje) {
        this.inicioViaje = inicioViaje;
    }

    public String getUbicacionActual() {
        return ubicacionActual;
    }

    public void setUbicacionActual(String ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getCostoViaje() {
        return costoViaje;
    }

    public void setCostoViaje(double costoViaje) {
        this.costoViaje = costoViaje;
    }

    public Date getFinalizaViaje() {
        return finalizaViaje;
    }

    public void setFinalizaViaje(Date finalizaViaje) {
        this.finalizaViaje = finalizaViaje;
    }

    public String getTipoUber() {
        return tipoUber;
    }

    public void setTipoUber(String tipoUber) {
        this.tipoUber = tipoUber;
    }

    public int getNumeroCorrelativo() {
        return numeroCorrelativo;
    }

    public void setNumeroCorrelativo(int numeroCorrelativo) {
        this.numeroCorrelativo = numeroCorrelativo;
    }

    @Override
    public String toString() {
        int numeroEntero = this.numeroCorrelativo;
        String numCorrelativo = String.valueOf(numeroEntero);
        SimpleDateFormat formatoS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        double dis = this.distancia;
        String distanciaKm = String.valueOf(dis);
        double costo = this.costoViaje;
        String costoStr = String.valueOf(costo);
        String fechaInicioComoString = formatoS.format(inicioViaje);
        String fechaFinComoString = formatoS.format(finalizaViaje);

        String formato = "| %-12s | %-15s | %-20s | %-20s | %-20s | %-12s | %-10s | %-15s | %-10s |%n";
        String encabezado = "+--------------+-----------------+--------------------+--------------------+--------------------+------------+----------+-----------------+------------+%n";

        return String.format(
                encabezado +
                        "| Factura No.  | Nombre          | Inicio del Viaje    | Ubicación Actual    | Destino             | Distancia Km | Tipo de Uber    | Costo Q.   | Finaliza Viaje    |%n" +
                        encabezado +
                        formato,
                numCorrelativo, nombre, fechaInicioComoString, ubicacionActual, destino, distanciaKm, tipoUber, costoStr, fechaFinComoString);
    }


}