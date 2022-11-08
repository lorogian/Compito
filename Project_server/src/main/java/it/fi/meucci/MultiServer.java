
 package it.fi.meucci;
 import java.net.ServerSocket;
 import java.net.Socket;
 
 public class MultiServer {
     public void avvio(){
         try{
 
             ServerSocket server = new ServerSocket(8080);
             for(;;){
                 System.out.println("server in attesa");
                 Socket socket=server.accept();
                 System.out.println("server  socket"+ socket);
                 ServerThread serverTh =new ServerThread(socket);
                 serverTh.start();
             }
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
     }
 }

