/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1_frame_work;

/**
 *
 * @author omar
 */

public class Tp1_Frame_Work{

    public static void main(String[] args) {
        // Démarrer le serveur dans un thread séparé
        Thread serverThread = new Thread(() -> {
            Serveur.main(args); // Démarrer le serveur
        });
        serverThread.start();

        // Laisser le serveur démarrer un peu avant de démarrer le client
        try {
            Thread.sleep(1000); // Attendre 1 seconde pour que le serveur ait le temps de démarrer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Démarrer le client dans un thread séparé
        Thread clientThread = new Thread(() -> {
            Client.main(args); // Démarrer le client
        });
        clientThread.start();
    }
}

