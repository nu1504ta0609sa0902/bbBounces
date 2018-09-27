import javax.swing.*;

/**
 * Created by tayyibah on 27/09/2018.
 */
public class Main {

    public static int WIDTH = 500;
    public static int HEIGHT = 400;

    public static void main(String[] args){

        JFrame frame = new JFrame("Bouncing Balls");
        frame.add(new GamePanel());
        frame.setResizable(false);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
