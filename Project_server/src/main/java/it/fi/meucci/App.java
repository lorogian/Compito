package it.fi.meucci;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws JsonGenerationException, JsonMappingException, IOException
    {
      
        

        // 
        Messaggio m = new Messaggio();
        Biglietto a1=new Biglietto("palco-1a");
        Biglietto a2=new Biglietto("parterre-2b");
        Biglietto a3=new Biglietto("parterre-1a");
        Biglietto a4=new Biglietto("tribuna-4e");
        Biglietto a5=new Biglietto("palco-3c");
        m.crea(a1);
        m.crea(a2);
        m.crea(a3);
        m.crea(a4);
        m.crea(a5);


        MultiServer sasso = new MultiServer(m);
        sasso.avvio();
        
}}
