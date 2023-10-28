package Clases;

public class SimulacionCarga {
    public void simularBarraCarga(){
        // Simulación de la animación de carga
        for (int i = 0; i <= 10; i++) {
            System.out.print("[ ");
            for (int j = 0; j <= 10; j++) {
                if (j < i) {
                    System.out.print("🔋");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print(" ] " + (i * 10) + "%\r");
            try {
                Thread.sleep(500); // Pausa de 0.5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
