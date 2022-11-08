package it.fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientStr {
    String name_server = "localhost";
    int serverport = 8080;
    Socket mysocket;
    BufferedReader keyboard;
    String user =null;
    String received;
    DataOutputStream output;
    BufferedReader input;

    public Socket connect() {
        System.out.println("partito in esecuzione...");
        try {
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            mysocket = new Socket(name_server, serverport);
            output = new DataOutputStream(mysocket.getOutputStream());
            input = new BufferedReader(new InputStreamReader(mysocket.getInputStream()));
        } catch (UnknownHostException e) {

            System.err.println("Unknowed host");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error during connection");
            System.exit(1);
        }
        return mysocket;

    }

    public void comunicate() {
        for (;;) {
            try {
                System.out.println("inserisci string " + '\n');
                user = keyboard.readLine();
                System.out.println("mandato string to server");
                output.writeBytes(user + '\n');
                received = input.readLine();
                System.out.println("server risposta" + '\n' + received);
                
                if (user.equals("FINE")) {
                    System.out.println("CLIENT : execution ended");
                    mysocket.close();
                    break;
                }
                
                
            } catch (Exception e) {

                System.out.println(e.getMessage());
                System.out.println("Error during connection");
                System.exit(1);
            }
        }

    }
}
