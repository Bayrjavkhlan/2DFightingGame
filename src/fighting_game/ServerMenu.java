/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fighting_game;
//test
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static fighting_game.PortChecker.isPortAvailable;

/**
 *
 * @author Zero
 */
public class ServerMenu extends JFrame implements KeyListener{
    GameFrame gm;
    ServerMenu sm;
    private ServerSocketHandler serverSocketHandler;
    public JButton BackButton;
    public JButton Start;
    public JButton ChooseChar;
    public int P1ChosenCharNum=1;
    public JButton Char1 , Char2 , Char3;
    int gameWidth = 1000 , gameHeight = 500 , x = 0 , y = 0;

    public ServerMenu(){
        gm = new GameFrame(); // Initialize GameFrame here

                if (isPortAvailable(12345)) startServer(12345,sm,gm);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);  
        addKeyListener(this);  

        setSize(gameWidth, gameHeight);
        setResizable(false);
        setLocationRelativeTo(null);
        Font font = new Font("Arial", Font.PLAIN, 30);
        System.out.println("Server Menu orson");
        setLayout(null);
        BackButton = new JButton("Go back to Main menu");
        BackButton.setFont(font);
        JLabel ipAddressLabel = new JLabel("IP Address: ");
        ipAddressLabel.setBounds(50,75,400,100);
        JLabel connectedPlayerIp = new JLabel("Connected Player IP:");
        connectedPlayerIp.setBounds(50, 125, 400, 100);
        connectedPlayerIp.setFont(font);
        JLabel connectedPlayerIpDisp = new JLabel("Nothing");
        connectedPlayerIpDisp.setBounds(50, 175, 400, 100);
        connectedPlayerIpDisp.setFont(font);
        
        try {
            // Get the local host's IP address
            InetAddress localhost = InetAddress.getLocalHost();
            String ipAddress = localhost.getHostAddress();
            ipAddressLabel.setText("IP Address: " + ipAddress);
            ipAddressLabel.setFont(font);

        } catch (UnknownHostException e) {
            ipAddressLabel.setText("IP Address: N/A");
        }
        BackButton.setBounds(0, 0, 1000, 100);
        BackButton.setBackground(Color.white);
        
        Start = new JButton("Start");
        Start.setBounds( 125, 300, 250,100);
        Start.setBackground(Color.white);
        Start.setFont(font);

        ChooseChar = new JButton("Select a character");
        ChooseChar.setBounds(600, 300, 250, 100);
        ChooseChar.setBackground(Color.white);
        ChooseChar.setFont(font);
        
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
        
        
        
        add(BackButton);
        add(ipAddressLabel);
        add(connectedPlayerIp);
        add(connectedPlayerIpDisp);
        add(Start);
        add(ChooseChar);
        add(Char1);
        add(Char2);
        add(Char3);
        BackButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Main btn daragdsan");
                MainMenu mm = new MainMenu();
                mm.setVisible(true);
                
                dispose();
                revalidate();
                repaint();
            }
        });   
            Start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            if (serverSocketHandler != null) {
                serverSocketHandler.sendMessage("start");
            }
                System.out.println("Start btn daragdsan");
//                gm = new GameFrame();
                gm.setVisible(true);
                add(gm);
                remove(ipAddressLabel);
                remove(connectedPlayerIp);
                remove(connectedPlayerIpDisp);
                remove(Start);
                remove(ChooseChar);
                remove(Char1);
                remove(Char2);
                remove(Char3);
//                ppg = new PingPongGame();
////                ppg.setVisible(true);
//                add(ppg);
//                ServerMenu sm = new ServerMenu();
//                sm.setVisible(false);
////                remove(sm);
//                remove(BackButton);
//                remove(ipAddressLabel);
//                remove(Start);
//dispose();
                revalidate();
                repaint();
            }
        });   
        
        Char1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                P1ChosenCharNum=1;
                System.out.println(P1ChosenCharNum);
            }
        });
        Char2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Character 2 selected");
                P1ChosenCharNum=2;
                System.out.println(P1ChosenCharNum);

            }
        });
        Char3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Character 3 selected");
                P1ChosenCharNum=3;
                System.out.println(P1ChosenCharNum);

            }
        });
    }
    private void startServer(int port,ServerMenu sm,GameFrame gm) {
        serverSocketHandler = new ServerSocketHandler(12345,sm,gm);
        serverSocketHandler.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

@Override
    public void keyPressed(KeyEvent e) {
        System.out.println("ServerPressed: " + e.getKeyChar());
                char pressedKey = e.getKeyChar();
        // Send the pressed key to the connected client
        if (serverSocketHandler != null) {
            serverSocketHandler.sendMessage(String.valueOf(pressedKey)); 
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


        
}
