/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientsocket;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edoar
 */
public class ClientSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("10.1.33.200", 5000);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
                    true);
            BufferedReader in = new BufferedReader(new InputStreamReader
        (clientSocket.getInputStream()));
            Scanner tastiera = new Scanner(System.in);
            boolean fine = false;
            String messaggio = null;
            while (!fine) {
                System.out.println("Cosa vuoi scrivere al server?");
                messaggio = tastiera.next();
                if (messaggio.equals("fine")) {
                    fine = true;
                }
                out.println(messaggio);
                System.out.println("Il server risponde: " + in.readLine());
            }
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
    }
    
}
