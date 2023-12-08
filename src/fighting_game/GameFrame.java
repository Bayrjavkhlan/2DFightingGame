/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//garign gargadag bolgochod coliision detect higed hb bartai bolgod hp bar 0 bolhod duusgadag bolgochih tgel bolo
package fighting_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Zero
 */
public class GameFrame extends JPanel implements Runnable{
    private Thread gameThread;
    private Timer timer;
    private JLabel timerLabel;
    private int countdownSeconds = 100;

    int WIDTH = 1000, HEIGHT = 500;
    int attackWidth = 150, attackheight = 25;
    JLabel WinnerDecleration = new JLabel("Draw");
    
    Character Char1 = new Character();
    Character Char2 = new Character();
    Attack Attack1 = new Attack();
    Attack Attack2 = new Attack();
    HealthBar Char1Health = new HealthBar();
    HealthBar Char2Health = new HealthBar();
    Timer timer1;
    Timer timer2;
    int x1=100,y1=270;
    int x2=820,y2=270;
    int att1xHandPos = 85 ,att1yHandPos = 80;
    int att2xHandPos = 155 ,att2yHandPos = 80;
    int char1HealthLoc = 00 , char2HealthLoc = 690 , charHealthY = 0;
    int char1HealthWidth = 300, char2HealthWidth = 300 , charHealthHeight=50;
    public GameFrame() {
        
        
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setBackground(Color.black);
        
        
        timerLabel = new JLabel(""+countdownSeconds +"");
        timerLabel.setForeground(Color.black);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        timerLabel.setBounds(470, 10, 150, 30);
        add(timerLabel);
        
        WinnerDecleration.setFont(new Font("Arial", Font.PLAIN, 30));
        WinnerDecleration.setBounds(450, 200, 100, 100);
        WinnerDecleration.setBackground(Color.GRAY);
        WinnerDecleration.setVisible(true);
        WinnerDecleration.setForeground(Color.black);
//        add(WinnerDecleration);
        
        Char1.setBackground(Color.blue);
        Char2.setBackground(Color.red);
        
        Char1.setLocation(x1, y1);
        Char2.setLocation(x2, y2);
        
        Attack1.setBounds(x1+att1xHandPos, y1+att1yHandPos, attackWidth, attackheight);
        Attack1.setBackground(Color.white);
        Attack1.setVisible(false);//end suuld false
        
        Attack2.setBounds(x2-att2xHandPos, y2+att2yHandPos, attackWidth, attackheight);
        Attack2.setBackground(Color.white);
        Attack2.setVisible(false);//end bas martva
        
        Char1Health.setBackground(Color.green);
        Char1Health.setLocation(char1HealthLoc,charHealthY);
        Char1Health.setBounds(char1HealthLoc, charHealthY, char1HealthWidth, charHealthHeight);
        Char1Health.setVisible(true);
//        Char1HealthBack.setBackground(Color.RED);
//        Char1HealthBack.setLocation(char1HealthLoc,charHealthY);
//        Char1HealthBack.setBounds(char1HealthLoc, charHealthY, char1HealthWidth, charHealthHeight);
//        Char1HealthBack.setVisible(true);
        
        Char2Health.setBackground(Color.GREEN);
        Char2Health.setLocation(char2HealthLoc,charHealthY);
        Char2Health.setBounds(char2HealthLoc, charHealthY, 300, charHealthHeight);
        Char2Health.setVisible(true);
//        Char2HealthBack.setBackground(Color.RED);
//        Char2HealthBack.setLocation(char1HealthLoc,charHealthY);
//        Char2HealthBack.setBounds(char1HealthLoc, charHealthY, 300, charHealthHeight);
//        Char2HealthBack.setVisible(true);
        
        
        
        this.add(Attack1);
        this.add(Attack2);
        this.add(Char1);
        this.add(Char2);
        this.add(Char1Health);
        this.add(Char2Health);
//        this.add(WinnerDecleration);

        gameThread = new Thread(this);
        gameThread.start();
        
        
        
        
        timer1 = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Attack1.setVisible(false);
                repaint();
                revalidate();
            }
        });
        timer2 = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Attack2.setVisible(false);
                repaint();
                revalidate();
            }
        });
        timer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimerLabel();
            }
        });

        timer.setInitialDelay(0);
        timer.start();

        repaint();
        revalidate();
    }
    public void char1Attack(){
        Attack1.setVisible(true);
        timer1.start();

        this.add(Attack1);
        repaint();
        revalidate();
    }
    public void char2Attack(){
        Attack2.setVisible(true);
        timer2.start();

        this.add(Attack2);
        repaint();
        revalidate();
        

    }
    public Color getBackgroundColor() {
        return getBackground();
    }

    public void setBackgroundColor(Color color) {
        setBackground(color);
        revalidate();
        repaint();
    }
    public void setBackgroundColorByStringChar1(String colorString) {
    switch (colorString.toLowerCase()) {
        case "a":
            checkCollisions();
            
            x1-=20;
            setBackgroundColor(Color.yellow);
            Char1.setLocation(x1, y1);
            Attack1.setLocation(x1+att1xHandPos, y1+att1yHandPos);
            

            revalidate();
            repaint();
            break;
        case "d":
            checkCollisions();
            x1+=20;
            setBackgroundColor(Color.PINK);
            Char1.setLocation(x1, y1);
            Attack1.setLocation(x1+att1xHandPos, y1+att1yHandPos);


            revalidate();
            repaint();
            break;
        case "s":
            setBackgroundColor(Color.blue);
            revalidate();
            repaint();
            break;
        case "w":
            setBackgroundColor(Color.ORANGE);
            revalidate();
            repaint();
            break;
        case "j":
            checkCollisions();
            char1Attack();
            revalidate();
            repaint();
            break;
        case "k":
            revalidate();
            repaint();
            break;
        default:
            setBackgroundColor(Color.white);
            revalidate();
            repaint();
            break;
    }
}
    public void setBackgroundColorByStringChar2(String colorString) {
    switch (colorString.toLowerCase()) {
        case "a":
            checkCollisions();
            x2-=20;
            setBackgroundColor(Color.yellow);
            Char2.setLocation(x2, y2);
            Attack2.setLocation(x2-att2xHandPos, y2+att2yHandPos);


            revalidate();
            repaint();
            break;
        case "d":
            checkCollisions();
            x2+=20;
            setBackgroundColor(Color.PINK);
            Char2.setLocation(x2, y2);
            Attack2.setLocation(x2-att2xHandPos, y2+att2yHandPos);


            revalidate();
            repaint();
            break;
        case "s":
            setBackgroundColor(Color.blue);
            revalidate();
            repaint();
            break;
        case "w":
            setBackgroundColor(Color.ORANGE);
            revalidate();
            repaint();
            break;
        case "j":
            checkCollisions();
            char2Attack();
            revalidate();
            repaint();
            break;
        default:
            setBackgroundColor(Color.white);
            revalidate();
            repaint();
            break;
    }
    }
public void checkCollisions() {
    Rectangle blueCharBounds = Char1.getBounds();
    Rectangle redCharBounds = Char2.getBounds();

    Rectangle attack1Bounds = Attack1.getBounds();
    Rectangle attack2Bounds = Attack2.getBounds();

    if (blueCharBounds.intersects(attack1Bounds) && Attack1.isVisible()) {
        System.out.println("Collision detected for Char1!");
        Char1Health.decreaseHealth();
        Char1Health.setBounds(char1HealthLoc, charHealthY, char1HealthWidth - 20, charHealthHeight);
        Char2.setLocation(x2 + 50, y2);
        System.out.println("Char1 Health: " + Char1Health.getHealth());
    }

    if (redCharBounds.intersects(attack2Bounds) && Attack2.isVisible()) {
        System.out.println("Collision detected for Char2!");
        Char2Health.decreaseHealth();
        Char2Health.setBounds(char2HealthLoc + 20, charHealthY, char2HealthWidth - 20, charHealthHeight);
        Char1.setLocation(x1 - 50, y1);
        System.out.println("Char2 Health: " + Char2Health.getHealth());
    }
}


    @Override
    public void run() {
        checkCollisions();
    repaint();
    revalidate();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                repaint();
                revalidate();
            }
        });
        try {
            Thread.sleep(16); // Adjust this value to control the frame rate (approximately 60 FPS)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        private void updateTimerLabel() {
        SwingUtilities.invokeLater(() -> {
            countdownSeconds--;

            if (countdownSeconds >= 0) {
                timerLabel.setText(""+countdownSeconds + "");
            } else {
//                this.remove(Char1);
//                this.remove(Char2);

                timerLabel.setText("Time's up!");
                timer.stop(); 
            }
        });
    }

}
    

