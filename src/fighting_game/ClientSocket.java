package fighting_game;
//fhf
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    ClientMenu cm;
    GameFrame gm;
//    PingPongGame ppg;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClientSocket(ClientMenu cm,String serverIP, int port) {
        this.cm = cm;
        try {
            socket = new Socket(serverIP, port);
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.output = new PrintWriter(socket.getOutputStream(), true);
            
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        String receivedMessage = receiveMessage();
                            if(receivedMessage.equalsIgnoreCase("start")){
                                System.out.println("\nStaart daragsan genee\n");
//                                cm.callingPPG();
                                cm.displayPingPongGame();
                                
                            }
//                            //Paddle 111111111111111111111111111111111111111111111
//                            ppg = new PingPongGame();
//                            switch (receivedMessage) {
//                                case "a":
//                                    ppg.setPaddle1Location(ppg.getPaddle1Location() - 20);
//                                    ppg.revalidate(); 
//                                    ppg.repaint(); 
//                                    break;
//                                case "d":
//                                    ppg.setPaddle1Location(ppg.getPaddle1Location() + 20);
//                                    ppg.revalidate(); 
//                                    ppg.repaint(); 
//                                    break;
//                            }
                            gm = new GameFrame();
                            switch (receivedMessage) {
                            case "a":
                                gm.setBackgroundColor(Color.yellow);
                                break;
                            case "s":
                                gm.setBackgroundColor(Color.red);
                                break;
                            case "d":
                                gm.setBackgroundColor(Color.blue);
                                break;
                            default:
                                gm.setBackgroundColor(Color.white);
                                break;
                        }
                            
                            
//                            System.out.println("Server pressed: " + receivedMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public void sendMessage(String message) {
    System.out.println("Sending message: " + message);
    output.println(message);
    //Paddle 2222222222222222222222222222222222222222222222222222
//    switch (message) {
//        case "a":
//            ppg.setPaddle2Location(ppg.getPaddle1Location() - 20);
//            ppg.revalidate(); 
//            ppg.repaint(); 
//            break;
//        case "d":
//            ppg.setPaddle2Location(ppg.getPaddle1Location() + 20);
//            ppg.revalidate(); 
//            ppg.repaint(); 
//            break;
//    }
}


    public String receiveMessage() throws IOException {
        String str=this.input.readLine().trim();
        System.out.println("Server pressed: "+str);
        if(str.equalsIgnoreCase("start")){
            System.out.println("\nStaaaaaaaaaaaarrtttttttt\n");
//            PingPongGame ppg = new PingPongGame();
        }
        return str;
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


