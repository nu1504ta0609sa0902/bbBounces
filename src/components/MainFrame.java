package components;

import javax.swing.*;

/**
 * Created by tayyibah on 27/09/2018.
 */
public class MainFrame {

    public static int TOTAL_NUMBER_OF_BALLS = 10;
    public static int WIDTH = 500;
    public static int HEIGHT = 400;

    public static void main(String[] args){

        JFrame frame = new JFrame("Bouncing Balls");
        GamePanel gamePanel = new GamePanel();
        Thread theThread = new Thread(gamePanel);
        theThread.start();

        frame.add(gamePanel);
        frame.setResizable(false);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
