/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1_frame_work;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author omar
 */
public class PacketGenerator {

    private Random random = new Random();

    
    public Packet generatePacket(long cardId) {
        double temperature = 15 + (30 - 15) * random.nextDouble(); // Température aléatoire entre 15°C et 30°C
        String gpsLocation = generateRandomGps(); 
        long timeFrame = random.nextLong(); 
        return new Packet(temperature, gpsLocation, cardId, timeFrame);
    }

    
    private String generateRandomGps() {
        double lat = 35 + (50 - 35) * random.nextDouble(); // Latitude entre 35 et 50
        double lon = -120 + (0 - (-120)) * random.nextDouble(); // Longitude entre -120 et 0
        return String.format("%.4f,%.4f", lat, lon); 
    }
}
