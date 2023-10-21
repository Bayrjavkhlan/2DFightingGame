/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2d_fighting_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Zero
 */
public class ServerMenu extends JPanel{
    public JButton BackButton;
    public JButton Start;
    public ServerMenu(){
        setLayout(null);
        BackButton = new JButton("Go back to Main menu");
        JLabel ipAddressLabel = new JLabel("IP Address: ");
        ipAddressLabel.setBounds(0,150,500,100);
        try {
            // Get the local host's IP address
            InetAddress localhost = InetAddress.getLocalHost();
            String ipAddress = localhost.getHostAddress();
            ipAddressLabel.setText("IP Address: " + ipAddress);
            Font font = new Font("Arial", Font.PLAIN, 30);
            ipAddressLabel.setFont(font);

        } catch (UnknownHostException e) {
            ipAddressLabel.setText("IP Address: N/A");
        }
        BackButton.setBounds(0, 0, 500, 100);
        BackButton.setBackground(Color.white);
        
        Start = new JButton("Start");
        Start.setBounds( 125, 300, 250,100);
        Start.setBackground(Color.white);
        
        
        
        add(BackButton);
        add(ipAddressLabel);
        add(Start);

     
    }
}
