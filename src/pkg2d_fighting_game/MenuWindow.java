/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2d_fighting_game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Zero
 */
public class MenuWindow extends JFrame {
    int WIDTH = 1000, HEIGHT = 500;
    int x=0,y=0;
    FightingGame fg;
    public MenuWindow() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setTitle("2D Fighting Game");
        setLayout(null);
        setVisible(true);
        
 
        
        MainMenu mm = new MainMenu();
        mm.setBounds(x, y, WIDTH, HEIGHT);
        add(mm);
        
        ServerMenu sm =new ServerMenu();
        sm.setBounds(x, y,WIDTH,HEIGHT);


        ClientMenu cm = new ClientMenu();
        cm.setBounds(x, y, WIDTH, HEIGHT);
        
        fg = new FightingGame();
        fg.setBounds(x, y, WIDTH, HEIGHT);


        mm.server.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(mm);
                remove(cm);
                add(sm);
                revalidate();
                repaint();
            }
        });
        mm.client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(mm);
                remove(sm);
                add(cm);
                revalidate();
                repaint();
            }
        });
        sm.BackButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(sm);
                add(mm);
                revalidate();
                repaint();
            }
        });
        sm.Start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(sm);
                add(fg);
                revalidate();
                repaint();
            }
            
        });
        cm.BackButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(cm);
                add(mm);
                revalidate();
                repaint();
            }
        });
        revalidate();
        repaint();
    }
        
}

