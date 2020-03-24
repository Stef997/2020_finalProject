package sample;


// A Java program for a Server

import java.net.*;
import java.io.*;

public class Server {
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // constructor with port
    public Server(int port) {

        FileOutputStream fop = null;
        File file;
        // starts server and waits for a connection
        try {
            file = new File("c:/Test/output.txt");
            fop = new FileOutputStream(file);

            if(!file.exists()){
                file.createNewFile();
            }
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                    byte[] contentInBytes = line.getBytes();
                    fop.write(contentInBytes);

                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            fop.flush();
            fop.close();

            // close connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }
}

