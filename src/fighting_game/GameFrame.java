/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fighting_game;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zero
 */
public class GameFrame extends JPanel{
    int WIDTH = 1000, HEIGHT = 500;
    public GameFrame() {
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setBackground(Color.black);
    }
    public Color getBackgroundColor() {
        return getBackground();
    }

    public void setBackgroundColor(Color color) {
        setBackground(color);
        revalidate();
        repaint();
    }
    public void setBackgroundColorByString(String colorString) {
    switch (colorString.toLowerCase()) {
        case "yellow":
            setBackgroundColor(Color.yellow);
            break;
        case "red":
            setBackgroundColor(Color.red);
            break;
        case "blue":
            setBackgroundColor(Color.blue);
            break;
        default:
            setBackgroundColor(Color.white);
            break;
    }
}
    
}
