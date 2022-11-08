package it.fi.meucci;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClientStr cliente = new ClientStr();
        cliente.connect();
        cliente.comunicate();
        
    }
}
