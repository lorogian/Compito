package it.fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ClientStr {
    String name_server = "localhost";
    int serverport = 8080;
    Socket mysocket;
    BufferedReader keyboard;
    String user = null;
    String received;
    DataOutputStream output;
    BufferedReader input;
    Messaggio m = new Messaggio();
    String messaggino;
    String arraypieno;
    public Socket connect() throws JsonGenerationException, JsonMappingException, IOException {

        System.out.println("partito in esecuzione...");

        ObjectMapper objectMapper = new ObjectMapper();
        messaggino = objectMapper.writeValueAsString(m); // scrive dentro una string i parametri della classse
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
        int a;
       
        for (;;) {
            try {
                /* 
                do {

                    System.out.println("inserisci num biglietto interessato n 1-5 " + '\n');
                    user = keyboard.readLine();
                    a = Integer.parseInt(user);
                   
                   // Messaggio mess_ser = objectMapper.readValue(a, Messaggio.class);


                    m.getBiglietti().get(a - 1);

                    System.out.println("vuoi un altro biglietto si o no" + '\n');
                    user = keyboard.readLine();

                } while (user.equals("si")); // verifica se interessa piu biglietti*/

                System.out.println("mandato array voto to server" + messaggino);
                output.writeBytes(messaggino + '\n'); // manda a lserver una string con elementi della classe messaggino

                arraypieno = input.readLine();
                System.out.println(arraypieno + '\n');


                System.out.println("mandato biglietti to server");
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
