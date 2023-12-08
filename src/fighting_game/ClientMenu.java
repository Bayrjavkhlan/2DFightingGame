/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fighting_game;
//dsadas
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Zero
 */
public class ClientMenu extends JFrame implements KeyListener{
//    PingPongGame ppg;
    public JButton Char1 , Char2 , Char3;
    public int P2ChosenCharNum=1;

    int gameWidth = 1000 , gameHeight = 500 , x = 0 , y = 0;
    int port = 12345;
    JButton BackButton;
    JButton Ready;
    JButton ChooseChar;
    JTextArea ServerIP;

    private ClientSocket clientSocket;
    
    public ClientMenu(){

//        connectToServer(localhost.getText(), port);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setFocusable(true);  
        setSize(gameWidth, gameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PingPongGame");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        
        
        BackButton = new JButton("Back to Main menu");
        BackButton.setBounds(0, 0, 1000, 100);
        BackButton.setBackground(Color.white);
        JLabel enterIp = new JLabel("Enter server's ip:");
        enterIp.setBounds(0, 125,250,100);
        Font font = new Font("Arial", Font.PLAIN, 30);
        enterIp.setFont(font);
        ServerIP = new JTextArea();
        Border border = new LineBorder(Color.black, 2, true);
        ServerIP.setBorder(border);
        ServerIP.setFont(font);
        ServerIP.setBounds(240, 150, 240, 50);
        Ready = new JButton("Ready");
        Ready.setBounds( 125, 300, 250,100);
        Ready.setBackground(Color.white);
//        connectToServer(ServerIP.getText(),12345);
//        connectToServer("localhost", 12345);
        //192.168.1.12 serverin IP
        Char1 = new JButton();
        Char1.setBounds(525, 150, 100, 100);
        Char1.setBackground(Color.red);
        Char1.setFont(font);
        
        Char2 = new JButton();
        Char2.setBounds(675, 150, 100, 100);
        Char2.setBackground(Color.blue);
        Char2.setFont(font);

        
        Char3 = new JButton();
        Char3.setBounds(825, 150, 100, 100);
        Char3.setBackground(Color.yellow);
        Char3.setFont(font);

        
        ChooseChar = new JButton("Select a character");
        ChooseChar.setBounds(600, 300, 250, 100);
        ChooseChar.setBackground(Color.white);
        ChooseChar.setFont(font);
        
        add(BackButton);
        add(Ready);
        add(enterIp);
        add(ServerIP);
        add(ChooseChar);
        add(Char1);
        add(Char2);
        add(Char3);
        Char1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                P2ChosenCharNum=1;
                System.out.println(P2ChosenCharNum);
            }
        });
        Char2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Character 2 selected");
                P2ChosenCharNum=2;
                System.out.println(P2ChosenCharNum);

            }
        });
        Char3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Character 3 selected");
                P2ChosenCharNum=3;
                System.out.println(P2ChosenCharNum);

            }
        });
        

        Ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Connect to the server
                connectToServer("localhost", 12345);

                // Set focus on the ClientMenu to capture key events
                requestFocusInWindow();

                // Disable the Ready button after connecting
//                Ready.setEnabled(false);

                revalidate();
                repaint();
            }
        });

        BackButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clientSocket != null) {
                    clientSocket.close();
                }
                System.out.println("Main btn daragdsan");
                MainMenu mm = new MainMenu();
                mm.setVisible(true);
                dispose();
                revalidate();
                repaint();
            }
        });   
        ServerIP.addKeyListener(this);

    }
    public void displayPingPongGame() {  
//        if (ppg == null) {
//            ppg = new PingPongGame();
//            ppg.setBounds(0, 0, gameWidth, gameHeight);
//            add(ppg);
//            remove(Ready);
//            remove(BackButton);
//            remove(ServerIP);
//            revalidate();
//            repaint();
//        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("You typed keycharacter: " + e.getKeyChar());
                char pressedKey = e.getKeyChar();
        System.out.println("Client pressed: " + pressedKey);
        if (clientSocket != null) {
//            System.out.println("ene ajiljinu");
            clientSocket.sendMessage(String.valueOf(pressedKey));
        }
        //Paddle 2222222222222222222222222222222222222222222222222222222222
//        switch (e.getKeyChar()) {
//            case 'a':
//                ppg.setPaddle1Location(ppg.getPaddle1Location() - 20);
//                ppg.revalidate(); 
//                ppg.repaint(); 
//                break;
//            case 'd':
//                ppg.setPaddle1Location(ppg.getPaddle1Location() + 20);
//                ppg.revalidate(); 
//                ppg.repaint(); 
//                break;
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
            public void connectToServer(String serverIP, int port) {
        // Establish a socket connection when the user enters the server's IP
        clientSocket = new ClientSocket(this,serverIP, 12345);

        // Display a message based on the connection status
        if (clientSocket != null) {
            System.out.println("Connected successfully");
        } else {
            System.out.println("Error connecting to the server");
        }
    }

}
