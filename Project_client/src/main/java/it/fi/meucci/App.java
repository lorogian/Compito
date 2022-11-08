package it.fi.meucci;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonGenerationException, JsonMappingException, IOException
    {
        ClientStr cliente = new ClientStr();
        cliente.connect();
        cliente.comunicate();
       

        /**/
    }
}
