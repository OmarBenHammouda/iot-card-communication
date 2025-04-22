/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1_frame_work;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author omar
 */

public class Serveur {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur démarré, en attente de connexions...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connecté : " + clientSocket.getInetAddress());

                try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     Scanner scanner = new Scanner(System.in)) {

                    System.out.println("Entrez le nombre de cartes à générer : ");
                    int numCards = scanner.nextInt();

                    System.out.println("Entrez le nombre de paquets par carte : ");
                    int numPackets = scanner.nextInt();

                    for (int i = 0; i < numCards; i++) {
                        long cardId = CardReader.readCardId();

                        for (long j = 0; j < numPackets; j++) {
                            Packet packet = PacketGenerator.generatePacket(cardId, j);
                            out.println(packet);
                            System.out.println("Paquet envoyé : " + packet);
                            Thread.sleep(500);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    clientSocket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    

    
    

    
    
    
    

