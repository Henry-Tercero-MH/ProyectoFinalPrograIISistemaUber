package ChatBox;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
          static  boolean chatActivo = true;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5001);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println(".:Bienvenido al chat de Uber Viajes:.");
            System.out.println("ChatBox del Usuario:");
            System.out.println("------------------------------------------");

            // Hilo para leer mensajes del servidor
            Thread recibirMensajes = new Thread(() -> {



                try {
                    String mensaje;
                    while (chatActivo && (mensaje = input.readLine()) != null) {
                        System.out.println("-----------------------------");
                        System.out.println("Conductor: " + mensaje);
                        System.out.println("-----------------------------");
                        if (mensaje.equalsIgnoreCase("adios")) {
                            System.out.println("ChatBox cerrado por el conductor");
                            chatActivo = false;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            recibirMensajes.start();

            // Hilo para enviar mensajes al servidor
            Thread enviarMensajes = new Thread(() -> {
                try {
                    String mensaje;
                    while (chatActivo) {
                        mensaje = scanner.nextLine();
                        output.println(mensaje);
                        if (mensaje.equalsIgnoreCase("adios")) {
                            System.out.println("ChatBox cerrado por el usuario");
                            chatActivo = false;
                            socket.close();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            enviarMensajes.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
