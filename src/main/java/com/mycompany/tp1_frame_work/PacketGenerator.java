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
    private static final Random random = new Random();

    public static Packet generatePacket(long cardId, long timeFrame) {
        int temperature = 10 + random.nextInt(31);
        String gpsCoordinates = generategpsCoordinates();
        return new Packet(cardId, timeFrame, temperature, gpsCoordinates);
    }
    private static String generategpsCoordinates() {
        double latitude = 35 + (50 - 35) * random.nextDouble();
        double longitude = -120 + (0 - (-120)) * random.nextDouble();
        return String.format("%.4f,%.4f", latitude, longitude);
    }

}
