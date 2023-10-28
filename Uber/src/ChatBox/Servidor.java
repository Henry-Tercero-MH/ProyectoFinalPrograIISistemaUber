package ChatBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    static boolean chatActivo = true;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5001);
            System.out.println(".:Bienvenido al chat de Uber Viajes:.");
            System.out.println("ChatBox del Conductor:");

            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);


            // Hilo para leer mensajes del cliente
            Thread recibirMensajes = new Thread(() -> {
                try {
                    String mensaje;
                    while (chatActivo && (mensaje = input.readLine()) != null) {
                        System.out.println("-----------------------------");
                        System.out.println("Cliente: " + mensaje);
                        System.out.println("-----------------------------");
                        if (mensaje.equalsIgnoreCase("adios")) {
                            System.out.println("ChatBox cerrado por el usuario");
                            chatActivo = false;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            recibirMensajes.start();

            // Hilo para enviar mensajes al cliente
            Thread enviarMensajes = new Thread(() -> {
                try {
                    String mensaje;
                    while (chatActivo) {
                        mensaje = scanner.nextLine();
                        output.println(mensaje);
                        if (mensaje.equalsIgnoreCase("adios")) {
                            System.out.println("ChatBox cerrado por el conductor");
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
