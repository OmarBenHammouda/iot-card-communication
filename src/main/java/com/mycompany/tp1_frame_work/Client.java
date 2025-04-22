/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1_frame_work;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author omar
 */
public class Client {


    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connexion au serveur établie");

            String packet;
            while ((packet = in.readLine()) != null) {
                if (filterPacket(packet)) {
                    System.out.println("Paquet reçu : " + packet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean filterPacket(String packet) {
        try {
            String[] fields = packet.split(",");
            for (String field : fields) {
                if (field.contains("temperature=")) {
                    int temperature = Integer.parseInt(field.split("=")[1]);
                    return temperature < 30;
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur" + e.getMessage());
        }
        return false;
    }
}