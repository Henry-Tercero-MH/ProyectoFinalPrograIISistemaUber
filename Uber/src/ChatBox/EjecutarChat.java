package ChatBox;

public class EjecutarChat {

    public static void main(String[] args) {
        ejecutarConversacion();
    }

    public static void ejecutarConversacion() {
        // Crear e iniciar el servidor (Conductor) en un hilo separado
        Thread servidorThread = new Thread(() -> {
            Servidor.main(null);
        });
        servidorThread.start();

        // Agregar un pequeño retraso para asegurarnos de que el servidor se inicie primero
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Crear e iniciar el cliente (Usuario) en el hilo principal
        Cliente.main(null);

        // Esperar a que ambos hilos terminen
        try {
            servidorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lógica adicional, si es necesario, después de que los hilos terminen
    }
}
