import java.net.*;
import java.io.*;
public class TCPWriteDisplayServer
{
    private static final int BUFSIZE = 32;
    private static class WriteServer1 implements Runnable
    {
        public void run()
        {
            while( !(msg.substring(0,4).equals( "quit" ) ) )
            {
                try
                {
                    Socket writeClntSock1 = writeSocket1.accept();
                    InputStream in = writeClntSock1.getInputStream();
                    while( (writeMsgSize1 = in.read(writeBuffer1) ) != -1 )
                    {
                    }
                    msg = new String(writeBuffer1);
                    System.out.println( "msg in Server1: " + msg );
                    writeClntSock1.close();
                }
                catch( Exception e )
                {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class WriteServer2 implements Runnable
    {
        public void run()
        {
            while( !(msg.substring(0,4).equals( "quit" ) ) )
            {
                try
                {
                    Socket writeClntSock2 = writeSocket2.accept();
                    InputStream in = writeClntSock2.getInputStream();
                    while( (writeMsgSize2 = in.read(writeBuffer2) ) != -1 )
                    {
                    }
                    msg = new String(writeBuffer2);
                    System.out.println( "msg in Server2: " + msg );
                    writeClntSock2.close();
                }
                catch( Exception e )
                {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class DisplayServer1 implements Runnable
    {

        public void run()
        {
            try
            {
                while( !(msg.substring(0,4).equals("quit" ) ) )
                {
                    Socket displayClntSock1 = displaySocket1.accept();

                    InputStream in = displayClntSock1.getInputStream();
                    OutputStream out = displayClntSock1.getOutputStream();
                    displayBuffer1 = msg.getBytes();
                    while( (displayMsgSize1 = in.read(displayBuffer1) ) != -1 )
                    {
                        out.write( msg.getBytes(), 0, displayMsgSize1 );
                        msg = "00000";
                    }
                    displayClntSock1.close();
                }
            }
            catch( Exception e )
            {
                e.printStackTrace();
            }
        }
    }
    public static class DisplayServer2 implements Runnable
    {
        public void run()
        {
            try
            {
                while( !(msg.substring(0,4).equals("quit" ) ) )
                {
                    Socket displayClntSock2 = displaySocket2.accept();

                    InputStream in = displayClntSock2.getInputStream();
                    OutputStream out = displayClntSock2.getOutputStream();
                    displayBuffer2 = msg.getBytes();
                    while( (displayMsgSize2 = in.read(displayBuffer2) ) != -1 )
                    {
                        out.write( msg.getBytes(), 0, displayMsgSize2 );
                        msg = "00000";
                    }
                    displayClntSock2.close();
                }
            }
            catch( Exception e )
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        if( args.length != 4 )
        {
            throw new IllegalArgumentException( "Parameters: <WritePort> <DisplayPort> <WritePort> <DisplayPort>" );
        }

        int writePort1 = Integer.parseInt(args[0]);
        int displayPort1 = Integer.parseInt(args[1]);
        int writePort2 = Integer.parseInt(args[2]);
        int displayPort2 = Integer.parseInt(args[3]);

        writeSocket1 = new ServerSocket(writePort1);
        displaySocket1 = new ServerSocket(displayPort1);
        writeSocket2 = new ServerSocket(writePort2);
        displaySocket2 = new ServerSocket(displayPort2);
        writeBuffer1 = new byte[BUFSIZE];
        displayBuffer1 = new byte[BUFSIZE];
        writeBuffer2 = new byte[BUFSIZE];
        displayBuffer2 = new byte[BUFSIZE];
        msg = "00000";
        Thread t1 = new Thread( new WriteServer1() );
        Thread t2 = new Thread( new DisplayServer1() );
        Thread t3 = new Thread( new WriteServer2() );
        Thread t4 = new Thread( new DisplayServer2() );
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    private static ServerSocket writeSocket1;
    private static ServerSocket displaySocket1;
    private static ServerSocket writeSocket2;
    private static ServerSocket displaySocket2;
    private static byte[] writeBuffer1;
    private static byte[] displayBuffer1;
    private static byte[] writeBuffer2;
    private static byte[] displayBuffer2;
    private static int writeMsgSize1;
    private static int displayMsgSize1;
    private static int writeMsgSize2;
    private static int displayMsgSize2;
    private static String msg;
}