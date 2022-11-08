package it.fi.meucci;
import java.net.*;
import java.io.*;
class ServerThread extends Thread{
    ServerSocket server = null;
    Socket client=null;
    String stringIn = null;
    String stringMd=null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;


    public ServerThread(Socket s){
        client=s;
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
                outVersoClient.writeBytes(stringIn+" "+"stringa ricevuta e trasmessa"+"\n");
            }
        }
        outVersoClient.close();
        inDalClient.close();
        System.out.println("chiusura socket"+client);
        client.close();
    }
}
