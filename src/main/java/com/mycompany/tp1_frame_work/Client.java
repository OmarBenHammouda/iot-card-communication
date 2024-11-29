/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1_frame_work;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author omar
 */
public class Client {

    private static final String SERVER_HOST = "localhost"; 
    private static final int SERVER_PORT = 12345; 

    // Méthode pour se connecter au serveur et recevoir des paquets
    public static void receivePackets() {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            System.out.println("Connexion au serveur établie...");

            // Lire les paquets envoyés par le serveur
            while (true) {
                try {
                    Packet packet = (Packet) in.readObject();
                    System.out.println("Paquet reçu : " + packet);

                    // Filtrer les paquets selon des critères spécifiques (exemple : température)
                    if (filterPacket(packet)) {
                        System.out.println("Paquet filtré : " + packet);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Filtre les paquets selon des critères (ici, on filtre les paquets avec une température supérieure à 25°C)
    public static boolean filterPacket(Packet packet) {
        // Filtrage : par exemple, on affiche uniquement les paquets avec une température > 25°C
        return packet.getTemperature() > 25;
    }

    public static void main(String[] args) {
        // Appeler la méthode pour recevoir et filtrer les paquets
        receivePackets();
    }
}