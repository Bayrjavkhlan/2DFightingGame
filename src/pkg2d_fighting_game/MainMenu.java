/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2d_fighting_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Zero
 */
public class MainMenu extends JPanel{
    public JButton server;
    public JButton client;
    int WIDTH = 1000, HEIGHT = 500;
    int x=0,y=0;
    ServerMenu sm;
    ClientMenu cm;
    FightingGame fg;
    public MainMenu(){
        setLayout(null); 
        setVisible(true);
        
        Font ServerClientFont = new Font("Arial", Font.PLAIN,30); 
        Border ServerClientBorder = new LineBorder(Color.black, 2, true);
        
        JLabel GameName = new JLabel("2D Fighting Game");
        GameName.setBounds(60, 20, 500, 60);
        Font GameNameFont = new Font("Arial", Font.PLAIN, 50);
        GameName.setFont(GameNameFont);
        add(GameName);
        
        server = new JButton(" Create a Server");
        server.setBounds(120, 160, 250, 100);
        server.setFont(ServerClientFont);
        server.setBorder(ServerClientBorder);
        server.setBackground(Color.white);
        add(server);
        
        client = new JButton(" Enter to Server");
        client.setBounds(120,300,250,100);
        client.setFont(ServerClientFont);
        client.setBorder(ServerClientBorder);
        client.setBackground(Color.white);
        add(client);
        
        
        
        
    
    }
    
}
      