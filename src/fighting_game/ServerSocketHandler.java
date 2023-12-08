package fighting_game;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketHandler extends Thread {
//    PingPongGame ppg;
    GameFrame gm;
    ServerMenu sm;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;

    public ServerSocketHandler(int port, ServerMenu sm,GameFrame gm) {
//        this.ppg = ppg; //ene null bn gd bga
        this.gm = gm; // Initialize GameFrame here
        this.sm = sm;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started, port: "+port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // Accept a client connection
            clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Set up input and output streams
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            

            // Start a new thread to handle incoming messages
            while (true) {
                String receivedMessage = input.readLine();
                if (receivedMessage != null) {
                    System.out.println("Client pressed: " + receivedMessage);
                if (receivedMessage.equalsIgnoreCase("a")) {
                    System.out.println("\na daragsan genee ajilchach chi\n");
                    gm.setBackgroundColorByString("pink");
                } else {
                    gm.setBackgroundColorByString(receivedMessage);
                }

            
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        System.out.println("Sending message: " + message);
        if (output != null) {
            output.println(message);
        }
//        Paddle 222222222222222222222222222222222222222222222222
        switch (message) {
            case "a":
//                sm.paddle1moveRigth();
//                ppg.setPaddle2Location(ppg.getPaddle1Location() - 20);
//                ppg.revalidate(); 
//                ppg.repaint();  
                        break;
            case "d":
//                ppg.setPaddle2Location(ppg.getPaddle1Location() + 20);
//                ppg.revalidate(); 
//                ppg.repaint(); 
                break;
        }
        
    }
//    public String receiveMessage() throws IOException {
//        return input.readLine();
//    }

    public void close() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
