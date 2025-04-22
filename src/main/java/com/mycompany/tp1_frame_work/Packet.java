/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1_frame_work;
import java.io.Serializable;
/**
 *
 * @author omar
 */
public class Packet implements Serializable {
    private long cardId;
    private long timeFrame;
    private int temperature;
    private String gpsCoordinates;
    private int checksum;

    public Packet(long cardId, long timeFrame, int temperature, String gpsCoordinates) {
        this.cardId = cardId;
        this.timeFrame = timeFrame;
        this.temperature = temperature;
        this.gpsCoordinates = gpsCoordinates;
        this.checksum = calculateChecksum();
    }

    private int calculateChecksum() {
        return (int) (temperature + gpsCoordinates.hashCode() + cardId + timeFrame) % 255;
    }

    public boolean isValid() {
        return this.checksum == calculateChecksum();
    }

    @Override
    public String toString() {
        return "Packet{" +
                "cardId=" + cardId +
                ", timeFrame=" + timeFrame +
                ", temperature=" + temperature +
                ", gpsCoordinates='" + gpsCoordinates + '\'' +
                ", checksum=" + checksum +
                '}';
    }
}

