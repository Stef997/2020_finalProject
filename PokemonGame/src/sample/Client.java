package sample;

// A Java program for a Client
import java.net.*;
import java.io.*;

public class Client
{
    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;

    // constructor to put ip address and port
    public Client(String address, int port, int selfHP, int enemyHP)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            //input  = new DataInputStream(System.in);

            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // string to read message from input
        String line = "";

        String selfString = String.valueOf(selfHP);

        String enemyString = String.valueOf(enemyHP);
        int j = 0;
        // keep reading until "Over" is input
        //while (j < 1)
        //{
            try
            {

                out.writeUTF(selfString);
                out.writeUTF(" ");
                out.writeUTF(enemyString);
                out.writeUTF("Over");
                //j++;
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        //}

        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        //Client client = new Client("127.0.0.1", 5000);
    }
}