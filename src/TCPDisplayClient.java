import java.net.*;
import java.io.*;
public class TCPDisplayClient
{
    private static String msg = "00000";
    private static int turn = 0;


    public static void main(String[] args) throws IOException
    {
        byte[] byteArrray = msg.getBytes();
        String ss = new String(byteArrray);
        String[][] array = {{"wCa", "wKN", "wBi", "wKi", "wQu", "wBi", "wKn", "wCa"},
                            {"wPa", "wPa", "wPa", "wPa", "wPa", "wPa", "wPa", "wPa"},
                            {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
                            {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
                            {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
                            {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
                            {"bPa", "bPa", "bPa", "bPa", "bPa", "bPa", "bPa", "bPa"},
                            {"bCa", "bKn", "bBi", "bKi", "bQu", "bBi", "bKn", "bCa"}};


        if( args.length != 2 )
        {
            throw new IllegalArgumentException(
                    "Parameters: <Server> <Port>" );
        }
        String server = args[0];
        int port = Integer.parseInt(args[1]);
        String input = "";
        byte[] byteBuffer;
        int bufferSize = 5;
        while( true )
        {
            Socket mySocket = new Socket(server, port);

            InputStream in = mySocket.getInputStream();
            OutputStream out = mySocket.getOutputStream();
            input = "";
            for( int i = 0; i < bufferSize; i++ )
            {
                input = input + " ";
            }
            byteBuffer = input.getBytes();
            out.write( byteBuffer );
            int totalBytesRcvd = 0;
            int bytesRcvd;
            while( totalBytesRcvd < bufferSize )
            {
                if( (bytesRcvd = in.read(byteBuffer, totalBytesRcvd, bufferSize - totalBytesRcvd) ) == -1 )
                {
                    throw new SocketException( "Connection closed prematurely" );
                }
                totalBytesRcvd += bytesRcvd;
            }
            printBoard(array);
            //System.out.println( new String(byteBuffer) );
            String moveToSpace = new String(byteBuffer);
            //System.out.println("movetospace:" + moveToSpace + ".");
            //System.out.println("input:" + input + ".");
            System.out.println("Waiting for Opponent...");
            if(turn%2 != 0)
            {
                System.out.println("It is now Black's turn");

            }else
            {
                System.out.println("It is now Whites's turn");

            }

            if(moveToSpace.charAt(0) != '0')
            {

                int x1 = (moveToSpace.charAt(0))-97;
                int y1 = (moveToSpace.charAt(1))-49;
                int x2 = (moveToSpace.charAt(3))-97;
                int y2 = (moveToSpace.charAt(4))-49;
                //System.out.println("Moved from" + x1 +"," + y1 + "to" + x2 + "," + y2);

                turn++;
                array[y2][x2] = array[y1][x1];

                array[y1][x1] = "   ";

            }

            moveToSpace = "0000";




            mySocket.close();
            try
            {
                Thread.sleep( 2000 );
            }
            catch( Exception e )
            {
                e.printStackTrace();
            }
        }
    }
    public static void printBoard(String[][] array)
    {
        System.out.println("        a       b       c       d       e       f       g       h");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("1   |" + array[0][0] + "    |" + array[0][1] + "    |" + array[0][2] + "    |" + array[0][3] + "    |" + array[0][4] + "    |" + array[0][5] + "    |" + array[0][6] + "    |" + array[0][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("2   |" + array[1][0] + "    |" + array[1][1] + "    |" + array[1][2] + "    |" + array[1][3] + "    |" + array[1][4] + "    |" + array[1][5] + "    |" + array[1][6] + "    |" + array[1][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("3   |" + array[2][0] + "    |" + array[2][1] + "    |" + array[2][2] + "    |" + array[2][3] + "    |" + array[2][4] + "    |" + array[2][5] + "    |" + array[2][6] + "    |" + array[2][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("4   |" + array[3][0] + "    |" + array[3][1] + "    |" + array[3][2] + "    |" + array[3][3] + "    |" + array[3][4] + "    |" + array[3][5] + "    |" + array[3][6] + "    |" + array[3][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("5   |" + array[4][0] + "    |" + array[4][1] + "    |" + array[4][2] + "    |" + array[4][3] + "    |" + array[4][4] + "    |" + array[4][5] + "    |" + array[4][6] + "    |" + array[4][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("6   |" + array[5][0] + "    |" + array[5][1] + "    |" + array[5][2] + "    |" + array[5][3] + "    |" + array[5][4] + "    |" + array[5][5] + "    |" + array[5][6] + "    |" + array[5][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("7   |" + array[6][0] + "    |" + array[6][1] + "    |" + array[6][2] + "    |" + array[6][3] + "    |" + array[6][4] + "    |" + array[6][5] + "    |" + array[6][6] + "    |" + array[6][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("8   |" + array[7][0] + "    |" + array[7][1] + "    |" + array[7][2] + "    |" + array[7][3] + "    |" + array[7][4] + "    |" + array[7][5] + "    |" + array[7][6] + "    |" + array[7][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");

    }
}