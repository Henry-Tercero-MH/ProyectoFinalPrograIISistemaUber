package Clases;

public class SimulacionMapa {

    public void simularMapa(int distanciaRecorrida) {
        // int distanciaRecorrida = 20;

        for (int i = distanciaRecorrida; i >= 0; i--) {
            System.out.print("");
            for (int j = 0; j <= distanciaRecorrida; j++) {
                if (j == i) {
                    System.out.print("🚗"); // Imprimir el carrito
                } else {
                    System.out.print("🏁"); // Imprimir la bandera
                }
            }
            System.out.print("" + (distanciaRecorrida - i + " km") + "\r");
            try {
                Thread.sleep(500); // Pausa de 0.5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mantener la bandera impresa al final
        for (int i = 0; i < 20; i++) {
            System.out.print("");
            for (int j = 0; j <= distanciaRecorrida; j++) {
                System.out.print("🏁"); // Imprimir solo la bandera
            }
            System.out.print("" + (0 + " km") + "\r");
            try {
                Thread.sleep(500); // Pausa de 0.5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}






