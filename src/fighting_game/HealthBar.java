/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fighting_game;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Zero
 */
public class HealthBar extends JLabel {
    private int health;
    private int WIDTH = 200, HEIGHT = 30;
    private int x = 50, y = 50; // Adjusted initial position

    public HealthBar() {
        this.setBounds(x, y, WIDTH, HEIGHT);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setVisible(true);
        this.health = 100; // Set initial health value
        updateLabel();
        repaint();
        revalidate();
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth() {
        // Adjust the health decrement logic as needed
        health -= 10;
        if (health < 0) {
            health = 0;
        }
        updateLabel();
        revalidate();
        repaint();
    }


    private void updateLabel() {
        this.setText("Health: " + health);
    }
}

