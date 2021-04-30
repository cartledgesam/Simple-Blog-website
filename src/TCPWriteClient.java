import java.net.*;
import java.io.*;
public class TCPWriteClient
{

    public static void main( String[] args ) throws IOException
    {
        if( args.length != 2 )
        {
            throw new IllegalArgumentException(
                    "Parameters: <Server> <Port>" );
        }
        String server = args[0];
        int port = Integer.parseInt(args[1]);
        String input = "00000";
        byte[] byteBuffer;
        while( !input.substring(0,4).equals("quit") )
        {
            Socket mySocket = new Socket(server, port);
            OutputStream out = mySocket.getOutputStream();
            System.out.println( "User Input: " );
            input = System.console().readLine();
            byteBuffer = input.getBytes();
            out.write(byteBuffer);
            mySocket.close();
        }
    }
}