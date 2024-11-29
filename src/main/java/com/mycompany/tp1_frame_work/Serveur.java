/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1_frame_work;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author omar
 */

public class Serveur {

    private static final int PORT = 12345; // Port pour la connexion TCP
    private static final int NUM_PACKETS = 5; // Nombre de paquets à générer pour chaque carte
    private static final int NUM_CARDS = 3; // Nombre de cartes à générer des paquets pour chaque

    // Méthode pour générer un paquet
    private static Packet generatePacket(long cardId) {
        PacketGenerator generator = new PacketGenerator();
        return generator.generatePacket(cardId);
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        ExecutorService executor = Executors.newFixedThreadPool(10); // Pool de threads pour gérer les clients multiples

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Serveur démarré, en attente de connexions...");

            // Boucle pour accepter les connexions clients
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connecté : " + clientSocket.getInetAddress());

                // Lancer un thread pour gérer la connexion du client
                executor.submit(() -> {
                    try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {
                        // Générer et envoyer des paquets pour plusieurs cartes
                        for (int i = 0; i < NUM_CARDS; i++) {
                            long cardId = System.currentTimeMillis() + i; // Utiliser l'heure actuelle + index pour l'ID de carte unique
                            for (int j = 0; j < NUM_PACKETS; j++) {
                                Packet packet = generatePacket(cardId);
                                out.writeObject(packet); // Envoyer le paquet au client
                                out.flush();
                                System.out.println("Paquet envoyé : " + packet);
                                Thread.sleep(500); // Pause entre l'envoi de paquets
                            }
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

    

    
    

    
    
    
    

