/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1_frame_work;
import java.util.Scanner;


/**
 *
 * @author omar
 */

public class CardReader {

   
    public static long readCardId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer l'identifiant de la carte (64 bits) : ");
        long cardId = scanner.nextLong();
        return cardId;
    }
}
