package it.fi.meucci;
import java.net.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
class ServerThread extends Thread{
    ServerSocket server = null;
    Socket client=null;
    String stringIn = null;
    String stringMd=null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    Messaggio mess;
    String messaggino;
    public ServerThread(Socket s,Messaggio mess){
        client=s;
        this.mess=mess;
    }

    public void run(){
        try{
            comunica();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
    }
    public void comunica() throws Exception{
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
        for(;;){
            stringIn = inDalClient.readLine();
            if(stringIn == null || stringIn.equals("FINE")){
                outVersoClient.writeBytes(stringIn+"(=> server in ciusura...)"+"\n");
                break;
            }
            else{

                System.out.println(stringIn);
                ObjectMapper objectMapper = new ObjectMapper();
                String mioOggettoSerrializzato = objectMapper.writeValueAsString(mess);
                outVersoClient.writeBytes(mioOggettoSerrializzato+"\n");
            }
        }
        outVersoClient.close();
        inDalClient.close();
        System.out.println("chiusura socket"+client);
        client.close();
    }
}
