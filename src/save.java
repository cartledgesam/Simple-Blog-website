import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;
/*
public class TCPDisplayClient {
    private static String msg;
    private Socket clientSocket;

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "Parameters: <Server> <Port>");
        }
        String server = args[0];
        int port = Integer.parseInt(args[1]);




        String[][] array = {{"wCa", "wKN", "wBi", "wKi", "wQu", "wBi", "wKn", "wCa",}, {"wPa", "wPa", "wPa", "wPa", "wPa", "wPa", "wPa", "wPa"}, {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "}, {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "}, {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "}, {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "}, {"bPa", "bPa", "bPa", "bPa", "bPa", "bPa", "bPa", "bPa"}, {"bCa", "bKn", "bBi", "bKi", "bQu", "bBi", "bKn", "bCa"}};

        writeBoard(array);

        serverInput(server, port,array);
        getServer(server, port, array);
        serverInput(server, port, array);


        System.out.println("Waiting on Opponent...\n");



    }



    public static void writeBoard(String[][] array) {
        System.out.println("        a       b       c       d       e       f       g       h");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("8   |" + array[0][0] + "    |" + array[0][1] + "    |" + array[0][2] + "    |" + array[0][3] + "    |" + array[0][4] + "    |" + array[0][5] + "    |" + array[0][6] + "    |" + array[0][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("7   |" + array[1][0] + "    |" + array[1][1] + "    |" + array[1][2] + "    |" + array[1][3] + "    |" + array[1][4] + "    |" + array[1][5] + "    |" + array[1][6] + "    |" + array[1][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("6   |" + array[2][0] + "    |" + array[2][1] + "    |" + array[2][2] + "    |" + array[2][3] + "    |" + array[2][4] + "    |" + array[2][5] + "    |" + array[2][6] + "    |" + array[2][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("5   |" + array[3][0] + "    |" + array[3][1] + "    |" + array[3][2] + "    |" + array[3][3] + "    |" + array[3][4] + "    |" + array[3][5] + "    |" + array[3][6] + "    |" + array[3][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("4   |" + array[4][0] + "    |" + array[4][1] + "    |" + array[4][2] + "    |" + array[4][3] + "    |" + array[4][4] + "    |" + array[4][5] + "    |" + array[4][6] + "    |" + array[4][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("3   |" + array[5][0] + "    |" + array[5][1] + "    |" + array[5][2] + "    |" + array[5][3] + "    |" + array[5][4] + "    |" + array[5][5] + "    |" + array[5][6] + "    |" + array[5][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("2   |" + array[6][0] + "    |" + array[6][1] + "    |" + array[6][2] + "    |" + array[6][3] + "    |" + array[6][4] + "    |" + array[6][5] + "    |" + array[6][6] + "    |" + array[6][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("    |       |       |       |       |       |       |       |       |");
        System.out.println("1   |" + array[7][0] + "    |" + array[7][1] + "    |" + array[7][2] + "    |" + array[7][3] + "    |" + array[7][4] + "    |" + array[7][5] + "    |" + array[7][6] + "    |" + array[7][7] + "    |");
        System.out.println("    +-------+-------+-------+-------+-------+-------+-------+-------+");
    }

    public static void serverInput(String args1, int porrt, String[][] array) throws IOException {
        String server = args1;
        int port = porrt;
        String input = "00000000";
        byte[] byteBuffer;

        Socket mySocket = new Socket(server, port);
        OutputStream out = mySocket.getOutputStream();
        System.out.println("User Input: ");
        input = System.console().readLine();
        byteBuffer = input.getBytes();
        out.write(byteBuffer);
        mySocket.close();
        //getServer(args1, porrt, array);


    }
//javac TCPDisplayClient.java
    //java TCPDisplayClient 127.0.0.1 7

    public static void getServer(String server, int port, String[][] array) throws IOException {
        String input = "";
        byte[] byteBuffer;
        int bufferSize = 5;
        System.out.println("Waiting on Opponent...\n");

        while (true) {
            Socket mySocket = new Socket(server, port);
            InputStream in = mySocket.getInputStream();
            OutputStream out = mySocket.getOutputStream();
            input = "";
            for (int i = 0; i < bufferSize; i++) {
                input = input + " ";
            }
            byteBuffer = input.getBytes();
            out.write(byteBuffer);
            int totalBytesRcvd = 0;
            int bytesRcvd;
            while (totalBytesRcvd < bufferSize) {
                if ((bytesRcvd = in.read(byteBuffer, totalBytesRcvd, bufferSize
                        - totalBytesRcvd)) == -1) {
                    throw new SocketException("Connection closed prematurely");
                }
                totalBytesRcvd += bytesRcvd;
            }

            String userInput = new String(byteBuffer);
            Map mapLetter = new HashMap();
            mapLetter.put("a", 0);
            mapLetter.put("b", 1);
            mapLetter.put("c", 2);
            mapLetter.put("d", 3);
            mapLetter.put("e", 4);
            mapLetter.put("f", 5);
            mapLetter.put("g", 6);
            mapLetter.put("h", 7);
            Map mapNumber = new HashMap();
            mapNumber.put("8", 0);
            mapNumber.put("7", 1);
            mapNumber.put("6", 2);
            mapNumber.put("5", 3);
            mapNumber.put("4", 4);
            mapNumber.put("3", 5);
            mapNumber.put("2", 6);
            mapNumber.put("1", 7);
            int initial = 0;
            if (mapLetter.get(String.valueOf(userInput.charAt(initial))) != null) {
                int arrayCol1 = Integer.parseInt(mapLetter.get(String.valueOf(userInput.charAt(initial))).toString());
                int arrayRow1 = Integer.parseInt(mapNumber.get(String.valueOf(userInput.charAt(initial + 1))).toString());
                int arrayCol2 = Integer.parseInt(mapLetter.get(String.valueOf(userInput.charAt(initial + 3))).toString());
                int arrayRow2 = Integer.parseInt(mapNumber.get(String.valueOf(userInput.charAt(initial + 4))).toString());

                if (!array[arrayRow1][arrayCol1].equals("   ")) {
                    String aux = array[arrayRow1][arrayCol1];
                    array[arrayRow2][arrayCol2] = aux;
                    array[arrayRow1][arrayCol1] = "   ";
                }
            }
            writeBoard(array);
            mySocket.close();
            break;


        }
    }
}*/