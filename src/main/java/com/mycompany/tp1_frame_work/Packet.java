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
public class Packet {

    private double temperature; 
    private String gpsLocation; // Localisation GPS sous forme de chaîne (latitude, longitude)
    private long cardId; 
    private long timeFrame; 
    private int checksum; 

    // Constructeur
    public Packet(double temperature, String gpsLocation, long cardId, long timeFrame) {
        this.temperature = temperature;
        this.gpsLocation = gpsLocation;
        this.cardId = cardId;
        this.timeFrame = timeFrame;
        this.checksum = calculateChecksum();
    }

    
    private int calculateChecksum() {
        
        return (int) (temperature + gpsLocation.hashCode() + cardId + timeFrame) % 255;
    }

    
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
       
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
         
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
        
    }

    public long getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(long timeFrame) {
        this.timeFrame = timeFrame;
        
    }

    public int getChecksum() {
        return checksum;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "temperature=" + temperature +
                ", gpsLocation='" + gpsLocation + '\'' +
                ", cardId=" + cardId +
                ", timeFrame=" + timeFrame +
                ", checksum=" + checksum +
                '}';
    }

}

