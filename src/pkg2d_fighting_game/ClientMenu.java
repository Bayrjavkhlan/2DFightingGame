/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2d_fighting_game;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Zero
 */
public class ClientMenu extends JPanel{
    JButton BackButton;
    public ClientMenu(){
        setLayout(null);
        BackButton = new JButton("Back back to Main menu");
        BackButton.setBounds(0, 0, 500, 100);
        BackButton.setBackground(Color.white);
        JLabel enterIp = new JLabel("Enter server's ip:");
        enterIp.setBounds(0, 125,250,100);
        Font font = new Font("Arial", Font.PLAIN, 30);
        enterIp.setFont(font);
        JTextArea ServerIP = new JTextArea();
        Border border = new LineBorder(Color.black, 2, true);
        ServerIP.setBorder(border);
        ServerIP.setFont(font);
        ServerIP.setBounds(240, 150, 240, 50);

        add(BackButton);
        add(enterIp);
        add(ServerIP);
        
    }
}
